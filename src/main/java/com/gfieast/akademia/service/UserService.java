package com.gfieast.akademia.service;

import java.util.List;
import java.util.Optional;

import com.gfieast.akademia.exception.UserNotFoundException;
import com.gfieast.akademia.model.User;
import com.gfieast.akademia.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new UserNotFoundException(userId));
    }

}