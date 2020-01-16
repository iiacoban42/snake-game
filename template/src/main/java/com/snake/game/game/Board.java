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



    private ShapeRenderer rend;
    private final Game game;


    /**
     * Constructor.
     *
     * @param game game
     */
    public Board(Game game) {
        this.game = game;
    }


    /**
     * Draws the board using a ShapeRenderer.
     *
     * @param rend rend
     */
    @SuppressWarnings("PMD")
    //UR anomaly : body is undefined. Stackoverflow report: bug in pmd.
    //https://stackoverflow.com/questions/21592497/java-for-each-loop-being-flagged-as-ur-anomaly-by-pmd
    public void draw(ShapeRenderer rend) {
        this.rend = rend;
        final float backgroundGrayScale = .85f;

        rend.setColor(backgroundGrayScale, backgroundGrayScale, backgroundGrayScale, 1);
        rend.rect(boardX, boardY, boardWidth, boardHeight);
        rend.set(ShapeRenderer.ShapeType.Line);
        rend.setColor(.0f, .0f, .0f, 1);
        rend.rect(boardX, boardY, boardWidth, boardHeight);

        rend.set(ShapeRenderer.ShapeType.Filled);
        rend.setColor(.0f, .0f, .0f, 1);

        if (game.getSnake() != null) {
            game.getSnake().draw(this);
        }
        if (game.getPowerUp() != null) {
            game.getPowerUp().draw(game);
        }
        if (game.getApples() != null) {
            if (game.getApples().size() > 0) {
                for (Apple extraApple : game.getApples()) {
                    extraApple.draw(game);
                }
            }
        }

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

    public Game getGame() {
        return game;
    }

    public void setRend(ShapeRenderer rend) {
        this.rend = rend;
    }
}
