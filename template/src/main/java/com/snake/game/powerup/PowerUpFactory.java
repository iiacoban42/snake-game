package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

/**
 * Creates new (randomized) power-ups.
 */
public class PowerUpFactory {

    private Game game;
    private PowerUp returned;

    /**
     * Constructor.
     * @param game game
     */
    public PowerUpFactory(Game game) {
        this.game = game;
    }

    /**
     * Method to get powerUp based on a number.
     * @param powerUp the power up.
     * @return specific powerUp.
     */
    public PowerUp getPowerUp(PowerUps powerUp) {
        int xcoord, ycoord;
        do {
        xcoord = (int) (game.getBoard().getGridWidth() * Math.random());
        ycoord = (int) (game.getBoard().getGridHeight() * Math.random());
        } while (game.getSnake().collides(xcoord, ycoord));

        returned = new MegaApple(game, xcoord, ycoord);

        switch (powerUp) {
            case SPEED_UP:
                returned = new SpeedUp(game, xcoord, ycoord);
                break;
            case MEGA_APPLE:
                returned = new MegaApple(game, xcoord, ycoord);
                break;
            case LENGTH:
                returned = new LengthPowerUp(game, xcoord, ycoord);
                break;
            case MORE_APPLES:
                returned = new MoreApples(game, xcoord, ycoord);
                break;
            case STOP_GROW:
                returned = new StopGrow(game, xcoord, ycoord);
                break;
            default:
                break;
        }
        return returned;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public PowerUp getReturned() {
        return returned;
    }

    public void setReturned(PowerUp returned) {
        this.returned = returned;
    }
}
