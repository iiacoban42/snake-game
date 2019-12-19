package com.snake.server.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.snake.server.domain.User;
import com.snake.server.repositories.UserRepository;
import com.snake.server.requests.LogInRequest;
import com.snake.server.requests.MaxScoreRequest;
import com.snake.server.requests.SignUpRequest;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class UserApiTest {

    transient User user;

    transient UserRepository userRepository;

    transient UserApi toTest;

    static String name = "testName";

    /**
     * Setup method.
     */
    @BeforeEach
    public void setUp() {
        user = new User(name, "testPwd");
        userRepository = Mockito.mock(UserRepository.class);
        toTest = new UserApi(userRepository);
        Mockito.when(userRepository.findByUsername(name)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findByUsername("noUser")).thenReturn(Optional.empty());
    }

    @Test
    public void nonExistentLoginTest() {
        LogInRequest req = new LogInRequest("noUser", "somePwd");
        ResponseEntity<?> res = toTest.authenticate(req);
        assertEquals(res.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(res.getBody(), "User not found!");
    }

    @Test
    public void goodPasswordTest() {
        LogInRequest logInRequest = new LogInRequest(name, "testPwd");
        ResponseEntity<?> res = toTest.authenticate(logInRequest);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
        assertEquals(res.getBody(), "Success!");
    }

    @Test
    public void wrongPasswordTest() {
        LogInRequest logInRequest = new LogInRequest(name, "qwerty");
        ResponseEntity<?> res = toTest.authenticate(logInRequest);
        assertEquals(HttpStatus.FORBIDDEN, res.getStatusCode());
        assertEquals("Wrong password!", res.getBody());
    }

    @Test
    public void takenUsernameTest() {
        SignUpRequest signUpRequest = new SignUpRequest(name, "asd");
        ResponseEntity<?> res = toTest.register(signUpRequest);
        assertEquals(HttpStatus.CONFLICT, res.getStatusCode());
        assertEquals("User with this username already exists!", res.getBody());
    }

    @Test
    public void newUserTest() {
        SignUpRequest signUpRequest = new SignUpRequest("newUser", "newPassword");
        User toSave = new User("newUser", "newPassword");
        Mockito.when(userRepository.save(toSave)).thenReturn(toSave);
        ResponseEntity<?> res = toTest.register(signUpRequest);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals("User created successfully!", res.getBody());
    }

    @Test
    public void noUserTest() {
        ResponseEntity<?> res = toTest.getInfo("noUser");
        assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
        assertEquals("User not found!", res.getBody());
    }

    @Test
    public void goodUser() {
        ResponseEntity<?> res = toTest.getInfo(name);
        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    public void updateMaxScoreCorrectTest() {
        int score = (int) Math.ceil(Math.random() * 100);
        MaxScoreRequest msr = new MaxScoreRequest(name, score);
        ResponseEntity<?> res = toTest.updateMaxScore(msr);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals(score, user.getMaxscore());
    }

    @Test
    public void updateMaxScoreIncorrectTest() {
        MaxScoreRequest msr = new MaxScoreRequest("noUser", 15);
        ResponseEntity<?> res = toTest.updateMaxScore(msr);
        assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
    }
}
