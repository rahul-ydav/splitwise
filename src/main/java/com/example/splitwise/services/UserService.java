package com.example.splitwise.services;

import com.example.splitwise.models.User;
import com.example.splitwise.repositories.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(List<Long> memberIds) {
        return userRepository.findAllById(memberIds);
    }
}
