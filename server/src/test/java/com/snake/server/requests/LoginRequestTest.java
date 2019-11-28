package com.snake.server.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LoginRequestTest {

    @Test
    void testConstructor() {
        LogInRequest lr = new LogInRequest("username1", "password1");

        assertEquals("username1", lr.getUsername());
        assertEquals("password1", lr.getPassword());
    }

    @Test
    void testGetUsername() {
        LogInRequest lr = new LogInRequest("username2", "password2");
        assertEquals("username2", lr.getUsername());
    }

    @Test
    void testGetPassword() {
        LogInRequest lr = new LogInRequest("username3", "password3");
        assertEquals("password3", lr.getPassword());
    }

    @Test
    void testSetUsername() {
        LogInRequest lr = new LogInRequest("username4", "password4");
        lr.setUsername("username5");
        assertEquals("username5", lr.getUsername());
    }

    @Test
    void testSetPassword() {
        LogInRequest lr = new LogInRequest("username5", "password5");
        lr.setPassword("password6");
        assertEquals("password6", lr.getPassword());
    }

}
