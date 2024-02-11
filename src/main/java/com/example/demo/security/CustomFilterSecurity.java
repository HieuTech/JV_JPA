package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class CustomFilterSecurity {

    @Autowired
    CustomUserDetailService customUserDetailService;


    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withUsername("user2")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("123"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
         http
                 .cors().disable()
                 .csrf().disable()
                 .authorizeHttpRequests()
                 .requestMatchers("/login/signin","/login/signup")
                 .permitAll()
                 .anyRequest()
                 .authenticated()
                 .and()
                 //HTTPbasic là username, password truyền trên header.

                 .httpBasic()

         ;
         return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
}