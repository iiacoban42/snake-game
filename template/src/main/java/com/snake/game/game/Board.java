package com.snake.game.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * The board is the field on which the game takes place. The snake and consumables take place
 * on the board within the given boundaries.
 */
public class Board {

    private final int TILE = 16;
    private final int GRID_WIDTH = 20;
    private final int GRID_HEIGHT = 20;

    private final int BOARD_X = 50;
    private final int BOARD_Y = 100;
    private final int BOARD_WIDTH = GRID_WIDTH*TILE;
    private final int BOARD_HEIGHT = GRID_HEIGHT*TILE;



    private ShapeRenderer rend;
    private final Game game;


    /**
     * Constructor.
     */
    public Board(Game game) {
        this.game = game;
//        this.rend = rend;
    }



    public void draw(ShapeRenderer rend){
        this.rend = rend;
        final float backgroundGrayScale = .85f;

        rend.setColor(backgroundGrayScale, backgroundGrayScale, backgroundGrayScale, 1);
        rend.rect(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);
        rend.set(ShapeRenderer.ShapeType.Line);
        rend.setColor(.0f, .0f, .0f, 1);
        rend.rect(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);

        rend.set(ShapeRenderer.ShapeType.Filled);
        rend.setColor(.0f, .0f, .0f, 1);

        if(game.getSnake() != null){
            game.getSnake().draw(this);
        }
        if (game.getPowerUp() != null) {
            game.getPowerUp().draw(game);
        }
        if(game.getApples() != null){
            if (game.getApples().size() > 0) {
                for (Apple extraApple : game.getApples()) {
                    extraApple.draw(game);
                }
            }
        }

    }
    public int getTile() {
        return TILE;
    }

    public int getGridWidth() {
        return GRID_WIDTH;
    }

    public int getGridHeight() {
        return GRID_HEIGHT;
    }

    public int getBoardX() {
        return BOARD_X;
    }

    public int getBoardY() {
        return BOARD_Y;
    }

    public int getBoardWidth() {
        return BOARD_WIDTH;
    }

    public int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    public ShapeRenderer getRend() {
        return rend;
    }

    public Game getGame() {
        return game;
    }

}
