package com.snake.server.requests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserResponseTest {

    @Test
    void constructorTest(){
        UserResponse test = new UserResponse("usernm", 15);
        assertEquals("usernm", test.getUsername());
        assertEquals(15, test.getMaxScore());
    }

    @Test
    void settersTest(){
        UserResponse test = new UserResponse("usernm", 15);
        test.setUsername("qwe");
        test.setMaxScore(25);
        assertEquals(25, test.getMaxScore());
        assertEquals("qwe", test.getUsername());
    }
}
