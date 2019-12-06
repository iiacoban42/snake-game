package com.snake.game.game;

public class Apple {
    private final int x, y;

    public Apple(Board board, Snake snake) {
        int xRand = (int) (Math.random() * board.gridWidth);
        int yRand = (int) (Math.random() * board.gridHeight);
        while (snake.collides(xRand, yRand)) {
            xRand = (int) (Math.random() * board.gridWidth);
            yRand = (int) (Math.random() * board.gridHeight);
        }
        x = xRand;
        y = yRand;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void draw(Board board) {
        board.getRend().circle(
                board.getDx() + x * board.getTILE() + board.getTILE() / 2.0f,
                board.getDy() + y * board.getTILE() + board.getTILE() / 2.0f,
                board.getTILE() / 2.0f);
    }
}
