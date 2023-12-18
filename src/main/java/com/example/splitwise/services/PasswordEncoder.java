package com.example.splitwise.services;

public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String plainText, String hashed);
}
