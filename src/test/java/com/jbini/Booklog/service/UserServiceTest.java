package com.jbini.Booklog.service;

import com.jbini.Booklog.dto.UserRequestDto;
import com.jbini.Booklog.entity.User;
import com.jbini.Booklog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

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
        //given
        User user = new User("servicetest@email.com","TestMan","test","testNick","");

        Long fakeUserId = 1l;
        ReflectionTestUtils.setField(user, "userId", fakeUserId);

        //mocking
        given(userRepository.findById(fakeUserId)).willReturn(Optional.ofNullable(user));

        //when
        Long newUserId = userService.findUserById(fakeUserId).getUserId();

        //then
        assertEquals(fakeUserId, newUserId);
        verify(userRepository).findById(newUserId);
    }

    @Test
    void findUserByEmail() {
        //given
        User user = new User("servicetest@email.com","TestMan","test","testNick","");

        Long fakeUserId = 1l;
        String userEmail = "servicetest@email.com";
        ReflectionTestUtils.setField(user, "userId", fakeUserId);
        ReflectionTestUtils.setField(user, "userEmail", userEmail);


        //mocking
        given(userRepository.findByUserEmail(userEmail)).willReturn(Optional.ofNullable(user));

        //when
        Long newUserId = userService.findUserByEmail(userEmail).getUserId();

        //then
        assertEquals(fakeUserId, newUserId);
        verify(userRepository).findByUserEmail(userEmail);
    }

    @Test
    void findAllUser() {
//        //given
//        User user = new User("servicetest@email.com","TestMan","test","testNick","");
//
//        Long fakeUserId = 1l;
//        String userEmail = "servicetest@email.com";
//        ReflectionTestUtils.setField(user, "userId", fakeUserId);
//        ReflectionTestUtils.setField(user, "userEmail", userEmail);
//
//
//        //mocking
//        given(userRepository.findByUserEmail(userEmail)).willReturn(Optional.ofNullable(user));
//
//        //when
//        Long newUserId = userService.findUserByEmail(userEmail).getUserId();
//
//        //then
//        assertEquals(fakeUserId, newUserId);
//        verify(userRepository).findByUserEmail(userEmail);

    }

    @Test
    void signUp() {
        //given


        //mocking

        //when

        //then
    }

    @Test
    void create(){
        //given
        UserRequestDto userRequestDto;


        //mocking

        //when

        //then
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