package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;

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
        this.returned = new MegaApple(board, snake,
                (float) Math.random(), (float) Math.random());
    }

    /**
     * Method to get powerUp based on a number.
     * @param number number
     * @return specific powerUp.
     */
    public PowerUp getPowerUp(int number) {
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
            case 4:
                returned = new StopGrow(board, snake,
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
