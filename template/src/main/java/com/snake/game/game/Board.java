package com.snake.game.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.powerup.PowerUp;
import com.snake.game.powerup.PowerUpFactory;
import com.snake.game.powerup.PowerUps;

import java.util.ArrayList;

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

    private boolean PORTAL_WALLS = false;
    private boolean stopGrowFlag;

    private final ShapeRenderer rend;
    private final Game game;

    private Snake snake;
    private ArrayList<Apple> apples;

    private PowerUp powerUp;
    private PowerUpFactory powerUpFactory;

    /**
     * Constructor.
     */
    public Board(Game game, ShapeRenderer rend) {
        this.game = game;
        this.rend = rend;

        stopGrowFlag = false;
    }

    public void spawnSprites(){
        snake = new Snake(0, 0, 5);

        Apple apple = Apple.spawnApplePersistent(this);
        apples = new ArrayList<>();
        apples.add(apple);

        powerUpFactory = new PowerUpFactory(this, snake);
    }

    public void draw(){
        final float backgroundGrayScale = .85f;

        rend.setColor(backgroundGrayScale, backgroundGrayScale, backgroundGrayScale, 1);
        rend.rect(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);
        rend.set(ShapeRenderer.ShapeType.Line);
        rend.setColor(.0f, .0f, .0f, 1);
        rend.rect(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);

        rend.set(ShapeRenderer.ShapeType.Filled);
        rend.setColor(.0f, .0f, .0f, 1);

        if(snake != null){
            snake.draw(this);
        }
        if (powerUp != null) {
            powerUp.draw();
        }
        if(apples != null){
            if (apples.size() > 0) {
                for (Apple extraApple : apples) {
                    extraApple.draw(this);
                }
            }
        }

    }

    /**
     * Game update.
     */
    @SuppressWarnings("PMD")
    //there must be at least one apple in the list we must not remove (line 229)
    public void run() {

        updatePowerUp(
                (float) Math.random(),
                PowerUps.values()[(int) ((float) Math.random() * PowerUps.values().length)]
        );

        if (snake.move()) {
            snake.killSnake();
            game.enterState(Game.StateName.finished);
            return;
        }

        if (snake.collides(apples.get(0).getXcoord(), apples.get(0).getYcoord())) {
            if (!stopGrowFlag) {
                snake.addLength(3);
            }
            apples.set(0, Apple.spawnApplePersistent(this));
            game.getScore().increment(10);
        }

        if (apples.size() > 1) {
            for (int i = 0; i < apples.size(); i++) {
                if (snake.collides(apples.get(i).getXcoord(), apples.get(i).getYcoord())) {
                    if (!stopGrowFlag) {
                        snake.addLength(3);
                    }
                    game.getScore().increment(10);
                    apples.remove(apples.get(i));
                }
            }
        }

        if (powerUp != null && snake.collides(powerUp.getXcoord(), powerUp.getYcoord())) {
            powerUp.handle();
            powerUp = null;
        }
    }

    /**
     * Method to update current powerUp. Chooses what powerUp to use (if any).
     */
    public void updatePowerUp(float random, PowerUps powerUp) {

        if (random > 0 && random <= 0.01 && powerUp == null) {
            this.powerUp = powerUpFactory.getPowerUp(powerUp);
        }
    }

    /**
     * Adds more apples to the board.
     *
     * @param number of apples to add.
     */
    public void addApples(int number) {
        for (int i = 0; i < number; i++) {
            apples.add(Apple.spawnApplePersistent(this));
        }

    }


    /**
     * Method to update snake direction.
     *
     * @param direction direction of a snake
     */
    public void updateDirection(Snake.Direction direction) {
        if (direction == Snake.Direction.UP) {
            snake.getDirection().enqueue(Snake.Direction.UP);
        }
        if (direction == Snake.Direction.DOWN) {
            snake.getDirection().enqueue(Snake.Direction.DOWN);
        }
        if (direction == Snake.Direction.LEFT) {
            snake.getDirection().enqueue(Snake.Direction.LEFT);
        }
        if (direction == Snake.Direction.RIGHT) {
            snake.getDirection().enqueue(Snake.Direction.RIGHT);
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

    public boolean isStopGrowFlag() {
        return stopGrowFlag;
    }

    public void setStopGrowFlag(boolean stopGrowFlag) {
        this.stopGrowFlag = stopGrowFlag;
    }

    public ShapeRenderer getRend() {
        return rend;
    }

    public Game getGame() {
        return game;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public ArrayList<Apple> getApples() {
        return apples;
    }

    public void setApples(ArrayList<Apple> apples) {
        this.apples = apples;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public PowerUpFactory getPowerUpFactory() {
        return powerUpFactory;
    }

    public void setPowerUpFactory(PowerUpFactory powerUpFactory) {
        this.powerUpFactory = powerUpFactory;
    }
}
