package com.develop.ForumRest.controller;

import com.develop.ForumRest.dto.UserAuthentication;
import com.develop.ForumRest.model.User;
import com.develop.ForumRest.security.TokenDTO;
import com.develop.ForumRest.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserAuthentication userAuthentication){
        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthentication.username(),
                userAuthentication.password());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(jwtToken));
    }


}
