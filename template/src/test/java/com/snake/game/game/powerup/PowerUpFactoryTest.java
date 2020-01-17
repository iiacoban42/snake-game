package com.snake.game.game.powerup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerUpFactoryTest {

    private transient Game game;
    private transient Snake snake;
    private transient PowerUpFactory powerUpFactory;

    /**
     * Setup method.
     */
    @BeforeEach
    public void setUp() {
        game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        snake = Mockito.mock(Snake.class);
        powerUpFactory = new PowerUpFactory(game);
    }

    @Test
    public void speedUpTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.SPEED_UP);
        assertTrue(powerUp instanceof SpeedUp);
    }

    @Test
    public void megaAppleTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.MEGA_APPLE);
        assertTrue(powerUp instanceof MegaApple);
    }

    @Test
    public void lengthPowerUpTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.LENGTH);
        assertTrue(powerUp instanceof LengthPowerUp);
    }

    @Test
    public void moreApplesTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.MORE_APPLES);
        assertTrue(powerUp instanceof MoreApples);
    }

    @Test
    public void stopGrowTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.STOP_GROW);
        assertTrue(powerUp instanceof StopGrow);
    }

    @Test
    public void defaultPowerup() {
        try {
            powerUpFactory.getPowerUp(PowerUpName.TEST_POWER_UP);

        } catch (Error e) {

            assertEquals(e.toString(), "java.lang.AssertionError");

        }
    }


}
