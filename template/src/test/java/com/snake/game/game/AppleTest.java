package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AppleTest {

    @Test
    void testAppleConstructorAndGetters() {
        Apple appleTest = new Apple(5, 3);

        assertEquals(5, appleTest.getXcoord());
        assertEquals(3, appleTest.getYcoord());
    }

    @Test
    void testAppleDoesntCollide() {
        Snake snake = new Snake(1,2,2);
        Board board = new Board(null);
        board.setSnake(snake);

        for (int i = 0; i < 200; i++) {
            Apple apple = Apple.spawnApplePersistent(board);
            assertFalse(board.getSnake().collides(apple.getXcoord(), apple.getYcoord()));
        }
    }
}
