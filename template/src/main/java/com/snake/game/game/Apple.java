package com.snake.game.game;

public class Apple {
    private int xcoord;
    private int ycoord;
    private double random;

    /**
     * Construct apple.
     * @param board .
     * @param snake .
     * @param random .
     */
    public Apple(Board board, Snake snake, double random) {
        this.random = random;
        int xrand = (int) (random * board.gridWidth);
        int yrand = (int) (random * board.gridHeight);
        while (snake.collides(xrand, yrand)) {
            random = Math.random();
            xrand = (int) (random * board.gridWidth);
            yrand = (int) (random * board.gridHeight);
        }
        xcoord = xrand;
        ycoord = yrand;
    }

    public int getXcoord() {
        return xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public double getRandom() {
        return this.random;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }

    public void setRandom(double random) {
        this.random = random;
    }

    /**
     * Render board.
     * @param board to render.
     */
    public void draw(Board board) {
        board.getRend().circle(
                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile() / 2.0f);
    }
}
