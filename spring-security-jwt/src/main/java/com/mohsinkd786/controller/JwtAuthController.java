package com.mohsinkd786.controller;

import com.mohsinkd786.config.JwtTokenUtil;
import com.mohsinkd786.request.JwtRequest;
import com.mohsinkd786.response.JwtResponse;
import com.mohsinkd786.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest request) throws Exception{
        authenticate(request.getUsername(),request.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException ex){
            throw new Exception("USER DISABLED ",ex);
        }catch (BadCredentialsException ex){
            throw new Exception("INVALID CREDENTIALS",ex);
        }
    }
}
