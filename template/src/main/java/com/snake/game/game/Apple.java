package com.snake.game.game;

public class Apple {

    private int xcoord;
    private int ycoord;
    private double random;
    private double randomy;

    /**
     * Construct apple.
     * @param board .
     * @param snake .
     * @param random .
     */
    public Apple(Board board, Snake snake, double random, double randomy) {
        this.random = random;
        this.randomy = randomy;
        int xrand = (int) (random * board.gridWidth);
        int yrand = (int) (randomy * board.gridHeight);
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

    public double getRandomy() {
        return randomy;
    }

    public void setRandomy(double randomy) {
        this.randomy = randomy;
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
