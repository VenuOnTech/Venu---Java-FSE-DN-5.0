package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.entity.User;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import org.springframework.http.MediaType;

@WebMvcTest
public class UserPostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService service;

    @Autowired
    ObjectMapper mapper;

    @Test
    void testCreateUser() throws Exception{

        User user=new User(1L,"John");

        when(service.saveUser(user)).thenReturn(user);

        String userJson = Objects.requireNonNull(mapper.writeValueAsString(user));

        mockMvc.perform(post("/users")
                .contentType(Objects.requireNonNull(MediaType.APPLICATION_JSON))
                .content(userJson))
                .andExpect(status().isOk());

    }

}