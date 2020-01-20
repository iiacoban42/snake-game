package com.snake.game.game.powerup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowerUpFactoryTest extends InitializedGameTest {

    private transient PowerUpFactory powerUpFactory;

    /**
     * Setup method.
     */
    @Override
    public void afterCreate() {
        powerUpFactory = new PowerUpFactory(game);
    }

    @Test
    public void speedUpTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.SPEED_UP);
        Assertions.assertTrue(powerUp instanceof SpeedUp);
    }

    @Test
    public void megaAppleTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.MEGA_APPLE);
        Assertions.assertTrue(powerUp instanceof MegaApple);
    }

    @Test
    public void lengthPowerUpTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.LENGTH);
        Assertions.assertTrue(powerUp instanceof LengthPowerUp);
    }

    @Test
    public void moreApplesTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.MORE_APPLES);
        Assertions.assertTrue(powerUp instanceof MoreApples);
    }

    @Test
    public void stopGrowTest() {
        PowerUp powerUp = powerUpFactory.getPowerUp(PowerUpName.STOP_GROW);
        Assertions.assertTrue(powerUp instanceof StopGrow);
    }

    @Test
    public void defaultPowerup() {
        Assertions.assertThrows(AssertionError.class, () ->
            powerUpFactory.getPowerUp(PowerUpName.TEST_POWER_UP)
        );
    }


}
