package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.powerup.MegaApple;
import com.snake.game.game.states.FinishedGameState;
import com.snake.game.game.states.GameStateName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IntegrationTest {

    /**
     * Test that the snake can maneuver and consume an apple for 10 points.
     * Integration Test
     */
    @Test
    void testManeuveringSnakeIntoApple() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        Apple apple = new Apple(4,4);

        // Add apple at custom position
        game.getApples().add(apple);


        // Change Direction
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.UP);
        game.getSnake().setDirection(directionQueue);

        for (int i = 0; i < 10; i++) {
            game.run();
        }

        assertEquals(game.getScore().get(), 10);
        assertEquals(game.getApples().size(), 1);
    }

    /**
     * Test that the snake can maneuver and consume an apple for 10 points.
     * And then it can run into a wall a die thus ending the game
     * Integration Test
     */
    @Test
    void testManeuveringSnakeIntoAppleAndDying() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.enterState(GameStateName.newGame);
        game.enterState(GameStateName.active);

        Apple apple = new Apple(4,4);

        // Add apple at custom position
        game.getApples().add(apple);


        // Change Direction
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.UP);
        game.getSnake().setDirection(directionQueue);

        for (int i = 0; i < 10; i++) {
            game.run();
        }

        assertEquals(game.getScore().get(), 10);

        // Keep the snake going it in the same direction and running it into the wall
        // Thus ending the game
        for (int i = 0; i < 10; i++) {
            game.run();
        }

        assertTrue(game.getState() instanceof FinishedGameState);

    }

    /**
     * Test that the snake can maneuver itself and die.
     * Integration Test
     */
    @Test
    void testManeuveringSnakeIntoItself() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.enterState(GameStateName.newGame);
        game.enterState(GameStateName.active);


        // Change Direction
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.UP);
        directionQueue.enqueue(Snake.Direction.LEFT);
        directionQueue.enqueue(Snake.Direction.DOWN);
        directionQueue.enqueue(Snake.Direction.RIGHT);
        game.getSnake().setDirection(directionQueue);

        // Run the snake into itself
        for (int i = 0; i < 10; i++) {
            game.run();
        }

        assertTrue(game.getState() instanceof FinishedGameState);

    }

    /**
     * Test that the snake can maneuver itself into a mega apple and gain 30 points.
     * Integration Test
     */
    @Test
    void testManeuveringSnakeIntoMegaApple() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.enterState(GameStateName.newGame);
        game.enterState(GameStateName.active);

        game.getApples().clear();
        game.getApples().add(new Apple(9,9));

        MegaApple megaApple = new MegaApple(7, 5);
        game.setPowerUp(megaApple);

        game.run();
        game.run();
        game.run();

        // Change Direction
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.UP);
        game.getSnake().setDirection(directionQueue);

        // Run the snake into MegaApple Power Up
        for (int i = 0; i < 16; i++) {
            game.run();
        }

        assertEquals(game.getScore().get(), 30);

    }



}
