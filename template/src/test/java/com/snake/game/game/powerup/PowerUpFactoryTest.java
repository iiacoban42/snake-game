package com.snake.game.game.powerup;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        game = Mockito.mock(Game.class);
        snake = Mockito.mock(Snake.class);
        powerUpFactory = new PowerUpFactory(game);
    }


}
