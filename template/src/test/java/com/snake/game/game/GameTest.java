package com.snake.game.game;

import com.snake.game.game.powerup.InitializedGameTest;
import com.snake.game.game.powerup.MegaApple;
import com.snake.game.game.powerup.PowerUpName;
import com.snake.game.game.powerup.SpeedUp;
import com.snake.game.game.states.FinishedGameState;
import com.snake.game.game.states.GameState;
import com.snake.game.game.states.GameStateName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest extends InitializedGameTest {



    /**
     * Test that the game enters the correct State.
     * Good Weather Test
     */
    @Test
    void testEnterState() {
        GameState gameOver = new FinishedGameState(game);
        GameStateName gameStateName = GameStateName.gameOver;

        game.spawnSprites();
        game.enterState(gameStateName);


        Assertions.assertEquals(game.getState().getClass(), gameOver.getClass());

    }

    /**
     * Test that the game throws an AssertionError when we try to enter to a null state.
     * Bad Weather Test
     */
    @Test
    void testEnterNullState() {
        GameState gameOver = new FinishedGameState(game);
        GameStateName gameStateName = GameStateName.gameOver;

        game.spawnSprites();
        game.enterState(gameStateName);


        Assertions.assertEquals(game.getState().getClass(), gameOver.getClass());

        try {
            game.enterState(GameStateName.test);
        } catch (Error e) {
            Assertions.assertEquals(e.toString(), "java.lang.AssertionError");
        }

        Assertions.assertEquals(game.getState().getClass(), gameOver.getClass());
    }

    /**
     * Tests the game updates the powerUp to SpeedUp when the chance is lower than the threshold.
     * Good Weather Test
     */
    @Test
    void testUpdatePowerUp() {
        game.updatePowerUp(0, PowerUpName.SPEED_UP);

        Assertions.assertEquals(game.getPowerUp().getClass(), SpeedUp.class);

    }

    /**
     * Test the game updates the powerUp to SpeedUp when the chance is lower than the threshold.
     * But it doesn't update the powerUp to Length since the chance is not lower than threshold
     * Good Weather Test
     */
    @Test
    void testUpdatePowerUpTwice() {
        game.spawnSprites();
        PowerUpName powerUpName = PowerUpName.SPEED_UP;
        PowerUpName powerUpName2 = PowerUpName.LENGTH;

        game.updatePowerUp(0.001, powerUpName);

        Assertions.assertEquals(game.getPowerUp().getClass(), SpeedUp.class);

        game.updatePowerUp(0.1, powerUpName2);

        Assertions.assertEquals(game.getPowerUp().getClass(), SpeedUp.class);


    }

    /**
     * Test that the game correctly enqueues the Snake direction of Up.
     * Good Weather
     */
    @Test
    void testUpdateDirectionUp() {
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.UP;

        game.updateDirection(direction);

        Assertions.assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction);

    }

    /**
     * Test that the game correctly enqueues the Snake direction of Down.
     * Good Weather
     */
    @Test
    void testUpdateDirectionDown() {
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.DOWN;

        game.updateDirection(direction);

        Assertions.assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction);

    }

    /**
     * Test that the game correctly enqueues the Snake direction of Right.
     * Good Weather
     */
    @Test
    void testUpdateDirectionRight() {
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.RIGHT;

        game.updateDirection(direction);

        Assertions.assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction);

    }

    /**
     * Test that the game correctly enqueues the Snake direction of Right.
     * Good Weather
     */
    @Test
    void testUpdateDirectionLeft() {
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.DOWN;

        game.updateDirection(direction);

        Snake.Direction direction2 = Snake.Direction.LEFT;

        game.updateDirection(direction2);

        Assertions.assertEquals(game.getSnake().getDirection().getKeyQueue().getLast(), direction2);

    }

    /**
     * Test that the game correctly does not changes its direction.
     * since the snake will not be able to rotate 180 degrees in 1 turn
     * Bad Weather
     */
    @Test
    void testUpdateNonOrthogonalDirectionLeft() {
        game.spawnSprites();
        Snake.Direction direction = Snake.Direction.LEFT;

        game.updateDirection(direction);

        Assertions.assertEquals(
                snake.getDirection().getKeyQueue().getLast(), Snake.Direction.RIGHT);

    }

    /**
     * Test that the game adds 10 apples.
     * Good Weather
     */
    @Test
    void testAddTenApples() {
        game.spawnSprites();

        Assertions.assertEquals(game.getApples().size(), 1);

        game.addApples(10);

        Assertions.assertEquals(game.getApples().size(), 11);

    }

    /**
     * Test that the game adds 10 apples.
     * Bad Weather
     */
    @Test
    void testAddTooManyApples() {
        game.spawnSprites();

        Assertions.assertEquals(game.getApples().size(), 1);

        game.addApples(1000);

        Assertions.assertEquals(game.getApples().size(), 1);

    }


    /**
     * Test Spawn PowerUps.
     * Good Weather
     */
    @Test
    void testSpawnPowerUps() {
        game.spawnSprites();
        game.updatePowerUp(0, PowerUpName.MEGA_APPLE);

        Assertions.assertNotNull(game.getPowerUp());
    }

    /**
     * Test Spawn Apple when there are 0 apples on the board.
     * Good Weather
     */
    @Test
    void testAddAppleEmptyBoard() {
        game.spawnSprites();
        game.getApples().clear();

        Assertions.assertEquals(game.getApples().size(), 0);

        game.run();

        Assertions.assertEquals(game.getApples().size(), 1);
    }

    /**
     * Test that the game ends when the snake collides with the wall.
     * Good Weather
     */
    @Test
    void testRunSnakeIntoWall() {
        game.spawnSprites();
        MegaApple megaApple = new MegaApple(7, 5);
        game.setPowerUp(megaApple);
        for (int i = 0; i < 100; i++) {
            game.run();
        }

        Assertions.assertEquals(game.getState().getClass(), FinishedGameState.class);
    }

    /**
     * Test that the snake's score will increase by 10 when it runs into an apple.
     * Good Weather
     */
    @Test
    void testRunSnakeIntoApple() {
        game.spawnSprites();
        MegaApple megaApple = new MegaApple(7, 5);
        game.setPowerUp(megaApple);
        Apple apple = new Apple(7, 0);
        game.getApples().add(apple);
        Assertions.assertEquals(game.getScore().get(), 0);
        for (int i = 0; i < 10; i++) {
            game.run();
        }
        Assertions.assertEquals(game.getScore().get(), 10);
    }

    /**
     * Test that the snake's score will increase by 30 when it runs into an megaApple (powerUp).
     * Good Weather
     */
    @Test
    void testRunSnakeIntoPowerUp() {
        game.spawnSprites();
        MegaApple megaApple = new MegaApple(7, 0);
        game.setPowerUp(megaApple);
        game.getApples().clear();
        Apple apple = new Apple(4,4);
        game.getApples().add(apple);
        System.out.println(game.getSoundSystem());
        System.out.println(game.getSoundSystem().getPowerUpSound());
        Assertions.assertEquals(game.getScore().get(), 0);
        for (int i = 0; i < 10; i++) {
            game.run();
        }
        Assertions.assertEquals(game.getScore().get(), 30);
    }
}
