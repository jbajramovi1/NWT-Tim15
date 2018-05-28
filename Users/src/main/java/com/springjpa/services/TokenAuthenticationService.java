package com.springjpa.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.springjpa.model.User;
import com.springjpa.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenAuthenticationService {
    
	private static UserRepository repository;
    
	static final long EXPIRATIONTIME = 864_000_000; 
    static final String SECRET = "NWT-TourDeBosna";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletRequest req, HttpServletResponse res, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        res.addHeader("Roles", repository.findByUsername(username).getRole());
    }

    public static Authentication getAuthentication(HttpServletRequest request) {

        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        repository = webApplicationContext.getBean(UserRepository.class);
        
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            User userAccount = repository.findByUsername(user);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            if(userAccount != null) {
                authorities.add(new SimpleGrantedAuthority(userAccount.getRole()));
            }

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
                    null;
        }
        return null;
    }
}