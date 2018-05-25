package com.example.UserAuth.service;

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

import com.example.UserAuth.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        com.example.UserAuth.model.User userAccount = userRepository.findByUsername(s);
        if(userAccount == null) {
            throw new UsernameNotFoundException("User not found");
        }

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return User.withUsername(userAccount.getUsername())
                .password(encoder.encode(userAccount.getPasswordHash()))
                .authorities(getGrantedAuthorities(userAccount))
                .build();
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(com.example.UserAuth.model.User userAccount) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userAccount.getRole()));
        return authorities;
    }
}
