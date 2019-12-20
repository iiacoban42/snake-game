package com.snake.server.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxScoreRequestTest {

    @Test
    void testConstructor() {
        MaxScoreRequest lr = new MaxScoreRequest("username1", 10);

        assertEquals("username1", lr.getUsername());
        assertEquals(10, lr.getMaxScore());
    }

    @Test
    void testGetUsername() {
        MaxScoreRequest lr = new MaxScoreRequest("username2", 10);
        assertEquals("username2", lr.getUsername());
    }

    @Test
    void testGetMaxScore() {
        MaxScoreRequest lr = new MaxScoreRequest("username3", 11);
        assertEquals(11, lr.getMaxScore());
    }

    @Test
    void testSetUsername() {
        MaxScoreRequest lr = new MaxScoreRequest("username4", 12);
        lr.setUsername("username5");
        assertEquals("username5", lr.getUsername());
    }

    @Test
    void testSetPassword() {
        MaxScoreRequest lr = new MaxScoreRequest("username5", 13);
        lr.setMaxScore(14);
        assertEquals(14, lr.getMaxScore());
    }

}
