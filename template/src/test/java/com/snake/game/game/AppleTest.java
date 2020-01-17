package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.powerup.PowerUpName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AppleTest {

    /**
     * Test game's score updates correctly when an apple is consumed.
     * And the isStopGrow is set to false
     * Good Weather Test
     */
    @Test
    void testAppleGrowAndConsumed() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        Apple apple = new Apple(1,1);

        assertEquals(game.getSnake().getLength(), 5);
        assertEquals(game.getScore().get(), 0);

        apple.consume(game, game.getSnake());

        assertEquals(game.getSnake().getLength(), 8);
        assertEquals(game.getScore().get(), 10);


    }

    /**
     * Test game's score updates correctly when an apple is consumed.
     * And the isStopGrow is set to true
     * Good Weather Test
     */
    @Test
    void testAppleNotGrowAndConsumed() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.setStopGrowFlag(true);
        Apple apple = new Apple(1,1);

        assertEquals(game.getSnake().getLength(), 5);
        assertEquals(game.getScore().get(), 0);

        apple.consume(game, game.getSnake());

        assertEquals(game.getSnake().getLength(), 5);
        assertEquals(game.getScore().get(), 10);

    }

    /**
     * Test game will spawn the apple in a location that doesn't collide with the snake.
     * Good Weather Test
     */
    @Test
    void testSpawnApple() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        Apple apple = Apple.spawnApplePersistent(game);

        assertEquals(game.getSnake().collides(apple.getPosX(), apple.getPosY()), false);

    }

}
