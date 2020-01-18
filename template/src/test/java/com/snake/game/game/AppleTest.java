package com.snake.game.game;

import com.snake.game.game.powerup.InitializedGameTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppleTest extends InitializedGameTest {

    /**
     * Test game's score updates correctly when an apple is consumed.
     * And the isStopGrow is set to false
     * Good Weather Test
     */
    @Test
    void testAppleGrowAndConsumed() {

        Assertions.assertEquals(snake.getLength(), 5);
        Assertions.assertEquals(score.get(), 0);

        apple.consume(game, snake);

        Assertions.assertEquals(snake.getLength(), 8);
        Assertions.assertEquals(score.get(), 10);
    }

    /**
     * Test game's score updates correctly when an apple is consumed.
     * And the isStopGrow is set to true
     * Good Weather Test
     */
    @Test
    void testAppleNotGrowAndConsumed() {
        game.setStopGrowFlag(true);

        Assertions.assertEquals(5, snake.getLength());
        Assertions.assertEquals(0,score.get());

        apple.consume(game, snake);

        Assertions.assertEquals(5, snake.getLength());
        Assertions.assertEquals(10, score.get());
    }

    /**
     * Test game will spawn the apple in a location that doesn't collide with the snake.
     * Good Weather Test
     */
    @Test
    void testSpawnApple() {
        Apple newApple = Apple.spawnApplePersistent(game);

        Assertions.assertFalse(snake.collides(apple.getPosX(), apple.getPosY()));
        Assertions.assertFalse(newApple.getPosX() == apple.getPosX()
                && newApple.getPosY() == apple.getPosY());
    }

}
