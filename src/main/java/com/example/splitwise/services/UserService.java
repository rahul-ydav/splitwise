package com.example.splitwise.services;

import com.example.splitwise.models.User;
import com.example.splitwise.models.UserExpense;
import com.example.splitwise.repositories.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder encoder;

    public User createUser(User request) {
        String hashPassword = encoder.encode(request.getPassword());
        User user = request.toBuilder().password(hashPassword).build();
        return userRepository.save(user);
    }
    
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(List<Long> memberIds) {
        return userRepository.findAllById(memberIds);
    }
}
