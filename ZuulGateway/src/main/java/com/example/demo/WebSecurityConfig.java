package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST,"/user-login").permitAll()
        .antMatchers(HttpMethod.POST,"/tourhost-login").permitAll()
        .antMatchers(HttpMethod.POST,"/tourhost/register").permitAll()
        .antMatchers(HttpMethod.POST,"/tourhost/save").permitAll()
        .antMatchers(HttpMethod.POST,"/user-service/register").permitAll()
        .antMatchers(HttpMethod.POST,"/").permitAll()
        .anyRequest().authenticated();
    }
}