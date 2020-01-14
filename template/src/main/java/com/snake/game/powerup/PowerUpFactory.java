package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * Creates new (randomized) power-ups.
 */
public class PowerUpFactory {

    private Board board;
    private Snake snake;
    private PowerUp returned;

    /**
     * Constructor.
     * @param board board
     * @param snake snake
     */
    public PowerUpFactory(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;
        this.returned = new MegaApple(board, snake);
    }

    /**
     * Method to get powerUp based on a number.
     * @param powerUp the power up.
     * @return specific powerUp.
     */
    public PowerUp getPowerUp(PowerUps powerUp) {
        switch (powerUp) {
            case SPEED_UP:
                returned = new SpeedUp(board, snake,
                        (float) Math.random(), (float) Math.random());
                break;
            case MEGA_APPLE:
                returned = new MegaApple(board, snake,
                        (float) Math.random(), (float) Math.random());
                break;
            case LENGTH:
                returned = new LengthPowerUp(board, snake,
                        (float) Math.random(), (float) Math.random());
                break;
            case MORE_APPLES:
                returned = new MoreApples(board, snake,
                        (float) Math.random(), (float) Math.random());
                break;
            default:
                break;
        }
        return returned;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public PowerUp getReturned() {
        return returned;
    }

    public void setReturned(PowerUp returned) {
        this.returned = returned;
    }
}
