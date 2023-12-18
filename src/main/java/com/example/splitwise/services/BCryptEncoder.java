package com.example.splitwise.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class BCryptEncoder implements PasswordEncoder{

    private final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
    @Override
    public String encode(String password) {
        return bCrypt.encode(password);
    }

    @Override
    public boolean matches(String plainText, String hashed) {
        return bCrypt.matches(plainText, hashed);
    }
}
