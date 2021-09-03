package com.mohsinkd786.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Value("jwt.username")
    private String username;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals(username)){
            // pass : admin
            // spring allows only hashed passwords = https://bcrypt-generator.com/
            // ideally the username & hashed password should come from database
            return new User(username,"$2a$12$denAuLFG3y7Sr9cnTZheyeaU/P1zib1LFXjJkmtJuQRXvCmsSraXq",new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found : "+username);
        }
    }
}
