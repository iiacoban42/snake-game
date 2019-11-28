package com.snake.server.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SignupRequestTest {

    @Test
    void testConstructor() {
        SignUpRequest sr = new SignUpRequest("username1", "password1");

        assertEquals("username1", sr.getUsername());
        assertEquals("password1", sr.getPassword());
    }

    @Test
    void testGetUsername() {
        SignUpRequest sr = new SignUpRequest("username2", "password2");
        assertEquals("username2", sr.getUsername());
    }

    @Test
    void testGetPassword() {
        SignUpRequest sr = new SignUpRequest("username3", "password3");
        assertEquals("password3", sr.getPassword());
    }

    @Test
    void testSetUsername() {
        SignUpRequest sr = new SignUpRequest("username4", "password4");
        sr.setUsername("username5");
        assertEquals("username5", sr.getUsername());
    }

    @Test
    void testSetPassword() {
        SignUpRequest sr = new SignUpRequest("username5", "password5");
        sr.setPassword("password6");
        assertEquals("password6", sr.getPassword());
    }

}
