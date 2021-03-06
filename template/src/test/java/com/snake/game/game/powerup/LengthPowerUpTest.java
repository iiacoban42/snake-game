package com.snake.game.game.powerup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LengthPowerUpTest extends  InitializedGameTest {

    /**
     * Test that the snake's score will increase by 10 when it runs into an power up.
     * And that it's length will decrease
     * Good Weather
     */
    @Test
    void testRunSnakeLengthPowerUp() {
        game.spawnSprites();

        LengthPowerUp lengthPowerUp = new LengthPowerUp(1, 1);

        assertEquals(game.getScore().get(), 0);
        assertEquals(game.getSnake().getLength(), 5);

        lengthPowerUp.consume(game, game.getSnake());

        assertEquals(game.getSnake().getLength(), 2);
        assertEquals(game.getScore().get(), 10);

    }

    /**
     * Test that the snake's score will increase by 10 when it runs into an power up.
     * And that it's length will not decrease since it minimum length
     * Good Weather
     */
    @Test
    void testRunSnakeMinimumLength() {
        game.spawnSprites();
        game.getSnake().setLength(1);

        LengthPowerUp lengthPowerUp = new LengthPowerUp(1, 1);

        assertEquals(game.getScore().get(), 0);
        assertEquals(game.getSnake().getLength(), 1);

        lengthPowerUp.consume(game, game.getSnake());

        assertEquals(game.getSnake().getLength(), 1);
        assertEquals(game.getScore().get(), 10);

    }
}
