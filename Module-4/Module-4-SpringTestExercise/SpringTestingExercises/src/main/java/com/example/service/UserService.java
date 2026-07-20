package com.example.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(Long id){

        Objects.requireNonNull(id, "id must not be null");

        return repository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("User not found"));

    }

    public User saveUser(User user){

        Objects.requireNonNull(user, "user must not be null");
        User saved = repository.save(user);
        return Objects.requireNonNull(saved, "saved user must not be null");

    }

}