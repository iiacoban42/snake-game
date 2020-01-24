package com.snake.game.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * The board is the field on which the game takes place. The snake and consumables take place
 * on the board within the given boundaries.
 */
public class Board {

    private final int tile = 16;
    private final int gridWidth = 20;
    private final int gridHeight = 20;

    private final int boardX = 50;
    private final int boardY = 100;
    private final int boardWidth = gridWidth * tile;
    private final int boardHeight = gridHeight * tile;

    private final ShapeRenderer rend;

    /**
     * Constructor.
     *
     * @param rend the renderer to use
     */
    public Board(ShapeRenderer rend) {
        this.rend = rend;
    }

    /**
     * Draws the board using a ShapeRenderer.
     *
     * @param game the game to draw on the board
     */
    @SuppressWarnings("PMD")
    //UR anomaly : body is undefined. Stackoverflow report: bug in pmd.
    //https://stackoverflow.com/questions/21592497/java-for-each-loop-being-flagged-as-ur-anomaly-by-pmd
    public void draw(Game game) {
        final float backgroundGrayScale = .85f;

        rend.setColor(backgroundGrayScale, backgroundGrayScale, backgroundGrayScale, 1);
        rend.rect(boardX, boardY, boardWidth, boardHeight);
        rend.set(ShapeRenderer.ShapeType.Line);
        rend.setColor(.0f, .0f, .0f, 1);
        rend.rect(boardX, boardY, boardWidth, boardHeight);

        rend.set(ShapeRenderer.ShapeType.Filled);
        rend.setColor(.0f, .0f, .0f, 1);


        game.getSnake().draw(this);

        if (game.getPowerUp() != null) {
            game.getPowerUp().draw(game);
        }
        if (game.getApples().size() > 0) {
            for (Apple extraApple : game.getApples()) {
                extraApple.draw(game);
            }
        }
    }

    /**
     * Check if position x,y is out of the board.
     * @param x X coord
     * @param y Y coord
     * @return whether it's out of the boundaries
     */
    public boolean isOutOfBorders(int x, int y) {
        return x < 0
                || x >= this.getGridWidth()
                || y < 0
                || y >= this.getGridHeight();
    }

    public int getTile() {
        return tile;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getBoardX() {
        return boardX;
    }

    public int getBoardY() {
        return boardY;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public ShapeRenderer getRend() {
        return rend;
    }
}
