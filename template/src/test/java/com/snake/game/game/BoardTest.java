package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.powerup.MegaApple;
import com.snake.game.game.powerup.PowerUpName;
import com.snake.game.game.powerup.SpeedUp;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class BoardTest {

    @Test
    void testBoardDrawPowerUp() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        MegaApple megaApple = new MegaApple(7, 5);

        game.setPowerUp(megaApple);

        Apple apple = new Apple(7, 0);

        game.getApples().add(apple);

        game.getBoard().draw();


        assertTrue(game.getPowerUp() instanceof MegaApple);

    }

    @Test
    void testBoardWithNoApplesNorPowerUps() {
        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        game.getApples().clear();

        game.getBoard().draw();

        assertEquals(game.getApples().size(), 0);
    }

}
