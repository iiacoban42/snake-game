package com.snake.game.game;

public class Apple {
    private final int x, y;

    public Apple(Board board, Snake snake) {
        int xRand = (int) (Math.random() * board.GWIDTH);
        int yRand = (int) (Math.random() * board.GHEIGHT);
        while (snake.collides(xRand, yRand)) {
            xRand = (int) (Math.random() * board.GWIDTH);
            yRand = (int) (Math.random() * board.GHEIGHT);
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
                board.getX() + x * board.getTILE() + board.getTILE() / 2.0f,
                board.getY() + y * board.getTILE() + board.getTILE() / 2.0f,
                board.getTILE() / 2.0f);
    }
}
