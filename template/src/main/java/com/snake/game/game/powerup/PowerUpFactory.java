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
        int posX;
        int posY;
        do {
            posX = (int) (game.getBoard().getGridWidth() * Math.random());
            posY = (int) (game.getBoard().getGridHeight() * Math.random());
        } while (game.getSnake().collides(posX, posY));

        switch (powerUp) {
            case SPEED_UP:
                returned = new SpeedUp(posX, posY);
                break;
            case MEGA_APPLE:
                returned = new MegaApple(posX, posY);
                break;
            case LENGTH:
                returned = new LengthPowerUp(posX, posY);
                break;
            case MORE_APPLES:
                returned = new MoreApples(posX, posY);
                break;
            case STOP_GROW:
                returned = new StopGrow(posX, posY);
                break;
            default:
                assert false;
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
