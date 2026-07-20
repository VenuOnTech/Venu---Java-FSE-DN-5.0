package com.example;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    void testGetUser(){

        User user=new User(1L,"John");

        when(repository.findById(1L)).thenReturn(Optional.of(user));

        User result=service.getUserById(1L);

        assertEquals("John",result.getName());

    }

}