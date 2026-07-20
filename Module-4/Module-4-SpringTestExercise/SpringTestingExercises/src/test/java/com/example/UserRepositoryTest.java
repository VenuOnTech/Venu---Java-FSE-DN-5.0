package com.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.entity.User;
import com.example.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void testFindByName(){

        repository.save(new User(1L,"John"));

        List<User> users=repository.findByName("John");

        assertEquals(1,users.size());

    }

}