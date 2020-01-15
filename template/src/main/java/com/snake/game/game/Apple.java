package com.snake.game.game;

import com.badlogic.gdx.graphics.Color;

/**
 * An apple, also known as 'cookies' in other snake versions, is an object on the board that
 * the player should attempt to eat by moving the snake head towards it. Eating one increases
 * the score and the snake length
 */
public class Apple implements Consumable {

    private final int xPos;
    private final int yPos;

    /**
     * Construct apple.
     *
     * @param xPos x-coordinate of position
     * @param yPos y-coordinate of position
     */
    public Apple(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }


    @Override
    public void consume(Game game, Snake snake) {
        if (!game.isStopGrowFlag()) {
            snake.addLength(3);
        }
        game.getScore().increment(10);
    }


    /**
     * Render apple on board of given Game.
     * @param game game.
     */
    @Override
    public void draw(Game game) {
        game.getBoard().getRend().setColor(Color.LIME);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xPos + .5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (yPos + .5f) * game.getBoard().getTile(),
                game.getBoard().getTile() / 2.0f);

    }

    /**
     * Creates an apple which is guaranteed to be in a proper spawn location.
     * @param game the game on which the apple must spawn
     * @return a new randomized apple which applies to the isProperSpawnLocation rules
     */
    public static Apple spawnApplePersistent(Game game) {
        int randx;
        int randy;
        do {
            randx = (int) (game.getBoard().getGridWidth() * Math.random());
            randy = (int) (game.getBoard().getGridHeight() * Math.random());
        } while (!isProperSpawnLocation(game, randx, randy));
        return new Apple(randx, randy);
    }

    /**
     * Checks whether a location is suitable for an apple to spawn.
     * @param game the game that contains all possible obstacles
     * @param xPos the x-coordinate to test
     * @param yPos the y-coordinate to test
     * @return returns true if the given location is suitable
     */
    private static boolean isProperSpawnLocation(Game game, int xPos, int yPos) {
        if (game.getSnake().collides(xPos, yPos)) {
            return false;
        }
        return true;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

}
