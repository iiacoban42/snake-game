package com.snake.game.game;

import com.badlogic.gdx.graphics.Color;

/**
 * An apple, also known as 'cookies' in other snake versions, is an object on the board that
 * the player should attempt to eat by moving the snake head towards it. Eating one increases
 * the score and the snake length
 */
public class Apple {

    private int xcoord;
    private int ycoord;

    /**
     * Construct apple.
     * @param xcoord .
     * @param ycoord .
     */
    public Apple(int xcoord, int ycoord) {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }

    public int getXcoord() {
        return xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }

    /**
     * Render board.
     * @param board to render.
     */
    public void draw(Board board) {

        board.getRend().setColor(Color.LIME);
        board.getRend().circle(
                board.getBoardX() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getBoardY() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile() / 2.0f);

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
     * @param xcoord the x-coordinate to test
     * @param ycoord the y-coordinate to test
     * @return returns true if the given location is suitable
     */
    private static boolean isProperSpawnLocation(Game game, int xcoord, int ycoord) {
        if (game.getSnake().collides(xcoord, ycoord)) {
            return false;
        }
        return true;
    }
}
