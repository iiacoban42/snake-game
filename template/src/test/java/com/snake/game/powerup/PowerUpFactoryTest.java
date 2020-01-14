package com.snake.game.powerup;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerUpFactoryTest {

    transient Board board;
    transient Snake snake;
    transient PowerUpFactory powerUpFactory;

    /**
     * Setup method.
     */
    @BeforeEach
    public void setUp() {
        board = Mockito.mock(Board.class);
        snake = Mockito.mock(Snake.class);
        powerUpFactory = new PowerUpFactory(board, snake);
    }


    @Test
    public void speedUpTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(1);
        assertTrue(powerUp instanceof SpeedUp);
    }

    @Test
    public void megaAppleTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(2);
        assertTrue(powerUp instanceof MegaApple);
    }

    @Test
    public void lengthPowerUpTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(3);
        assertTrue(powerUp instanceof LengthPowerUp);
    }

    @Test
    public void moreApplesTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(4);
        assertTrue(powerUp instanceof MoreApples);
    }

    @Test
    public void stopGrowTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(5);
        assertTrue(powerUp instanceof StopGrow);
    }

    @Test
    public void defaultTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(100);
        assertTrue(powerUp instanceof MegaApple);
    }
}
