package com.example;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.repository.UserRepository;
import com.example.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceExceptionTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    void testUserNotFound(){

        when(repository.findById(10L))
                .thenReturn(Optional.empty());

        java.util.NoSuchElementException ex = assertThrows(java.util.NoSuchElementException.class,
            () -> service.getUserById(10L));

    }

}