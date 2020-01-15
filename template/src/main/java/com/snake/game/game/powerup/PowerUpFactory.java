package com.snake.game.game.powerup;

import com.snake.game.game.Game;

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
    public PowerUp getPowerUp(PowerUpName powerUp) {
        int xPos, yPos;
        do {
        xPos = (int) (game.getBoard().getGridWidth() * Math.random());
        yPos = (int) (game.getBoard().getGridHeight() * Math.random());
        } while (game.getSnake().collides(xPos, yPos));

        switch (powerUp) {
            case SPEED_UP:
                returned = new SpeedUp(xPos, yPos);
                break;
            case MEGA_APPLE:
                returned = new MegaApple(xPos, yPos);
                break;
            case LENGTH:
                returned = new LengthPowerUp(xPos, yPos);
                break;
            case MORE_APPLES:
                returned = new MoreApples(xPos, yPos);
                break;
            case STOP_GROW:
                returned = new StopGrow(xPos, yPos);
                break;
            default:
                returned = null;
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
