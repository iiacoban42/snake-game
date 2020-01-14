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
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUps.SPEED_UP);
        assertTrue(powerUp instanceof SpeedUp);
    }

    @Test
    public void megaAppleTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUps.MEGA_APPLE);
        assertTrue(powerUp instanceof MegaApple);
    }

    @Test
    public void lengthPowerUpTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUps.LENGTH);
        assertTrue(powerUp instanceof LengthPowerUp);
    }

    @Test
    public void moreApplesTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUps.MORE_APPLES);
        assertTrue(powerUp instanceof MoreApples);
    }
}
