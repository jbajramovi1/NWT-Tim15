package com.example.TourHostAuthService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.TourHostAuthService.repository.TourHostRepository;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TourHostRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


    	com.example.TourHostAuthService.model.TourHost account = repository.findByUsername(s);
        if(account == null) {
            throw new UsernameNotFoundException("TourHost not found");
        }

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return User.withUsername(account.getUsername())
                .password(encoder.encode(account.getPassword()))
                .authorities(getGrantedAuthorities(account))
                .build();
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(com.example.TourHostAuthService.model.TourHost account) {        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}
