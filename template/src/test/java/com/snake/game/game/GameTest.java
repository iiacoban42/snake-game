package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.powerup.MegaApple;
import com.snake.game.game.powerup.PowerUpName;
import com.snake.game.game.powerup.SpeedUp;
import com.snake.game.game.states.FinishedGameState;
import com.snake.game.game.states.GameState;
import com.snake.game.game.states.GameStateName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameTest {

    /**
     * Test that the game enters the correct State.
     * Good Weather Test
     */
    @Test
    void testEnterState() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        GameState gameOver = new FinishedGameState(game);
        GameStateName gameStateName = GameStateName.gameOver;

        game.spawnSprites();
        game.enterState(gameStateName);


        assertEquals(game.getState().getClass(), gameOver.getClass());

    }

    /**
     * Test that the game throws an AssertionError when we try to enter to a null state.
     * Bad Weather Test
     */
    @Test
    void testEnterNullState() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        GameState gameOver = new FinishedGameState(game);
        GameStateName gameStateName = GameStateName.gameOver;

        game.spawnSprites();
        game.enterState(gameStateName);


        assertEquals(game.getState().getClass(), gameOver.getClass());

        try {
            game.enterState(GameStateName.test);
        } catch (Error e) {
            assertEquals(true, true);
            assertEquals(e.toString(), "java.lang.AssertionError");
        }

        assertEquals(game.getState().getClass(), gameOver.getClass());
    }

    /**
     * Tests the game updates the powerUp to SpeedUp when the chance is lower than the threshold.
     * Good Weather Test
     */
    @Test
    void testUpdatePowerUp() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        PowerUpName powerUpName = PowerUpName.SPEED_UP;

        game.updatePowerUp(0.001, powerUpName);

        assertEquals(game.getPowerUp().getClass(), SpeedUp.class);

    }

    /**
     * Test the game updates the powerUp to SpeedUp when the chance is lower than the threshold.
     * But it doesn't update the powerUp to Length since the chance is not lower than threshold
     * Good Weather Test
     */
    @Test
    void testUpdatePowerUpTwice() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        PowerUpName powerUpName = PowerUpName.SPEED_UP;
        PowerUpName powerUpName2 = PowerUpName.LENGTH;

        game.updatePowerUp(0.001, powerUpName);

        assertEquals(game.getPowerUp().getClass(), SpeedUp.class);

        game.updatePowerUp(0.1, powerUpName2);

        assertEquals(game.getPowerUp().getClass(), SpeedUp.class);


    }

    /**
     * Test the game updates the powerUp to SpeedUp when the chance is lower than the threshold.
     * But it does not respond to the incorrect chance input and doesn't change to Speed_Up
     * Bad Weather
     */
    @Test
    void testUpdatePowerUpBadInput() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        PowerUpName powerUpName = PowerUpName.SPEED_UP;
        PowerUpName powerUpName2 = PowerUpName.LENGTH;

        game.updatePowerUp(0.001, powerUpName);

        assertEquals(game.getPowerUp().getClass(), SpeedUp.class);

        game.updatePowerUp(-1, powerUpName2);

        assertEquals(game.getPowerUp().getClass(), SpeedUp.class);

    }

    /**
     * Test that the game correctly enqueues the Snake direction of Up.
     * Good Weather
     */
    @Test
    void testUpdateDirectionUp() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.UP;

        game.updateDirection(direction);

        assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction);

    }

    /**
     * Test that the game correctly enqueues the Snake direction of Down.
     * Good Weather
     */
    @Test
    void testUpdateDirectionDown() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.DOWN;

        game.updateDirection(direction);

        assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction);

    }

    /**
     * Test that the game correctly enqueues the Snake direction of Right.
     * Good Weather
     */
    @Test
    void testUpdateDirectionRight() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.RIGHT;

        game.updateDirection(direction);

        assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction);

    }

    /**
     * Test that the game correctly enqueues the Snake direction of Right.
     * Good Weather
     */
    @Test
    void testUpdateDirectionLeft() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.DOWN;

        game.updateDirection(direction);

        Snake.Direction direction2 = Snake.Direction.LEFT;

        game.updateDirection(direction2);

        assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction2);

    }

    /**
     * Test that the game correctly does not changes its direction.
     * since the snake will not be able to rotate 180 degrees in 1 turn
     * Bad Weather
     */
    @Test
    void testUpdateNonOrthogonalDirectionLeft() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.LEFT;

        game.updateDirection(direction);

        assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), Snake.Direction.RIGHT);

    }

    /**
     * Test that the game adds 10 apples.
     * Good Weather
     */
    @Test
    void testAddTenApples() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        assertEquals(game.getApples().size(), 1);

        game.addApples(10);

        assertEquals(game.getApples().size(), 11);

    }

    @Test
    void testAddTooManyApples() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        assertEquals(game.getApples().size(), 1);

    }


    /**
     * Test Spawn PowerUps.
     * Good Weather
     */
    @Test
    void testSpawnPowerUps() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        game.run();


    }

    /**
     * Test Spawn Apple when there are 0 apples on the board.
     * Good Weather
     */
    @Test
    void testAddAppleEmptyBoard() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.getApples().clear();

        assertEquals(game.getApples().size(), 0);

        game.run();

        assertEquals(game.getApples().size(), 1);


    }

    /**
     * Test that the game ends when the snake collides with the wall.
     * Good Weather
     */
    @Test
    void testRunSnakeIntoWall() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        MegaApple megaApple = new MegaApple(7, 5);
        game.setPowerUp(megaApple);

        for (int i = 0; i < 100; i++) {
            game.run();
        }

        assertEquals(game.getState().getClass(), FinishedGameState.class);


    }

    /**
     * Test that the snake's score will increase by 10 when it runs into an apple.
     * Good Weather
     */
    @Test
    void testRunSnakeIntoApple() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        MegaApple megaApple = new MegaApple(7, 5);

        game.setPowerUp(megaApple);

        Apple apple = new Apple(7, 0);

        game.getApples().add(apple);

        assertEquals(game.getScore().get(), 0);


        for (int i = 0; i < 10; i++) {
            game.run();
        }

        assertEquals(game.getScore().get(), 10);

    }

    /**
     * Test that the snake's score will increase by 30 when it runs into an megaApple (powerUp).
     * Good Weather
     */
    @Test
    void testRunSnakeIntoPowerUp() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        MegaApple megaApple = new MegaApple(7, 0);
        game.setPowerUp(megaApple);


        game.getApples().clear();
        Apple apple = new Apple(4,4);

        game.getApples().add(apple);

        assertEquals(game.getScore().get(), 0);


        for (int i = 0; i < 10; i++) {
            game.run();
        }

        assertEquals(game.getScore().get(), 30);


    }




}
