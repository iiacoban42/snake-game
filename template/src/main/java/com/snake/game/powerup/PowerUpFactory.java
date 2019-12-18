package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;

public class PowerUpFactory {

    private Board board;
    private Snake snake;

    public PowerUpFactory(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;
    }

    public PowerUp getPowerUp (int number) {
        PowerUp returned = null;
        switch (number) {
            case 1:
                returned = new SpeedUp(board, snake,
                        (float) Math.random(), (float) Math.random());
                break;
            case 2:
                returned = new MegaApple(board, snake,
                        (float) Math.random(), (float) Math.random());
                break;
            case 3:
                returned = new LengthPowerUp(board, snake,
                        (float) Math.random(), (float) Math.random());
                break;
        }
        return returned;
    }

}
