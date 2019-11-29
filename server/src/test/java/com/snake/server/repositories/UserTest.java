package com.snake.server.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {


    transient User test;

    @BeforeEach
    void setUp(){
        test = new User("testName", "testPwd");
    }

    @Test
    void testConstructor(){
        User test = new User("usrnm", "qwerty");
        assertEquals("usrnm", test.getUsername());
        assertEquals("qwerty", test.getPassword());
        assertEquals(0, test.getMaxscore());
    }

    @Test
    void lowerMaxScoreTest(){
        test.setMaxscore(Long.valueOf(-1));
        assertEquals(0, test.getMaxscore());
    }

    @Test
    void correctMaxScoreTest(){
        test.setMaxscore(Long.valueOf(15));
        assertEquals(15, test.getMaxscore());
    }

    @Test
    void settersTest(){
        test.setId(Long.valueOf(15));
        test.setUsername("newUsrnm");
        test.setPassword("newPwd");
        assertEquals("newUsrnm", test.getUsername());
        assertEquals("newPwd", test.getPassword());
        assertEquals(Long.valueOf(15), test.getId());
    }
}
