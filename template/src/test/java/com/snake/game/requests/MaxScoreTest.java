package com.snake.game.requests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MaxScoreTest {

    @Test
    void testUsernameNull() {
        MaxScore l = new MaxScore(null, 30);
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
    }

    @Test
    void testUsernameEmpty() {
        MaxScore l = new MaxScore("", 30);
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
    }

    @Test
    void testNoRunningServer() {
        MaxScore l = new MaxScore("username", 30);
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
        assertTrue(l.getErrors().contains("Couldn't connect to the server"));
    }
}
