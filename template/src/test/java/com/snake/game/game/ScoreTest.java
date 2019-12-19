package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class ScoreTest {

    @Test
    void constructorTest() {
        Score score = new Score();
        assertEquals(0, score.get());
    }

    @Test
    void incrementByOneTest() {
        Score score = new Score();
        score.increment();
        assertEquals(1, score.get());
    }

    @Test
    void incrementByMoreTest() {
        Score score = new Score();
        score.increment(3);
        assertEquals(3, score.get());
    }

    @Test
    void resetTest() {
        Score score = new Score();
        score.increment();
        assertNotEquals(0, score.get());
        score.reset();
        assertEquals(0, score.get());
    }
}
