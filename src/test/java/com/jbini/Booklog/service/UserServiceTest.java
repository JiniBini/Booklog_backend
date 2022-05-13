package com.jbini.Booklog.service;

import com.jbini.Booklog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void existsByUserEmail() {
        //given


        //mocking

        //when

        //then
    }

    @Test
    void findUserById() {
    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void findAllUser() {
    }

    @Test
    void signUp() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getUserByUserEmail() {
    }
}