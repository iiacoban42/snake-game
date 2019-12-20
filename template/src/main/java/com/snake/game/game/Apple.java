package com.snake.game.game;

import com.badlogic.gdx.graphics.Color;

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
                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile() / 2.0f);

    }

    /**
     * Creates an apple which is guaranteed to be in a proper spawn location.
     * @param board the board on which the apple must spawn
     * @return a new randomized apple which applies to the isProperSpawnLocation rules
     */
    public static Apple spawnApplePersistent(Board board) {
        int randx;
        int randy;
        do {
            randx = (int) (board.getGridWidth() * Math.random());
            randy = (int) (board.getGridHeight() * Math.random());
        } while (!isProperSpawnLocation(board, randx, randy));
        return new Apple(randx, randy);
    }

    /**
     * Checks whether a location is suitable for an apple to spawn.
     * @param board the board that contains all possible obstacles
     * @param xcoord the x-coordinate to test
     * @param ycoord the y-coordinate to test
     * @return returns true if the given location is suitable
     */
    private static boolean isProperSpawnLocation(Board board, int xcoord, int ycoord) {
        if (board.getSnake().collides(xcoord, ycoord)) {
            return false;
        }
        return true;
    }
}
