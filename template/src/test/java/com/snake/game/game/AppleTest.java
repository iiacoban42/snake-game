package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AppleTest {

    @Test
    void testAppleConstructorAndGetters() {
        Apple appleTest = new Apple(5, 3);

        assertEquals(5, appleTest.getPosX());
        assertEquals(3, appleTest.getPosY());
    }

    @Test
    void testAppleDoesntCollide() {
        Snake snake = new Snake(1,2,2);
        Game game = new Game(null);
        game.setSnake(snake);

        for (int i = 0; i < 200; i++) {
            Apple apple = Apple.spawnApplePersistent(game);
            assertFalse(game.getSnake().collides(apple.getPosX(), apple.getPosX()));
        }
    }
}
