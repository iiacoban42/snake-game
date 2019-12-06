package com.snake.game.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Board {

    boolean portalWalls = false;
    final int dx = 50;
    final int dy = 100;
    final int width = 320;
    final int height = 320;
    final int gridWidth = 20;
    final int gridHeight = 20;

    final int tile = 16;

    final ShapeRenderer rend;
    final Timer<Runnable> gameUpdateTimer;

    Snake snake;
    Apple apple;


    /**
     * Returns the setting whether the snake can go through walls.
     *
     * @return boolean
     */
    public boolean isPortalWalls() {
        return portalWalls;
    }

    public Timer<Runnable> getGameUpdateTimer() {
        return gameUpdateTimer;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getTile() {
        return tile;
    }

    public ShapeRenderer getRend() {
        return rend;
    }

    public void setPortalWalls(boolean portalWalls) {
        this.portalWalls = portalWalls;
    }

    /**
     * Game update.
     */
    public void run() {

        if (snake.move()) {
            snake.killSnake();
            gameUpdateTimer.setActive(false);
            return;
        }
        if (snake.collides(apple.getXcoord(), apple.getYcoord())) {
            snake.addLength(3);
            apple = new Apple(this, snake,Math.random());
        }

    }

    /**
     * Constructor.
     *
     * @param rend a ShapeRenderer to draw its graphics to
     */
    public Board(ShapeRenderer rend) {
        this.rend = rend;

        snake = new Snake(0, 0, 5);
        apple = new Apple(this, snake, Math.random());

        gameUpdateTimer = new Timer<>(this::run);
        gameUpdateTimer.setActive(true);
    }

    /**
     * Method to update timer.
     */
    public void timerHandler() {
        gameUpdateTimer.timerHandler(System.currentTimeMillis());
    }

    /**
     * Main draw method.
     */
    public void draw() {

        final float backgroundGrayScale = .85f;
        //final float snakeGrayScale = .85f;
        rend.setColor(backgroundGrayScale, backgroundGrayScale, backgroundGrayScale, 1);
        rend.rect(dx, dy, width, height);
        rend.set(ShapeRenderer.ShapeType.Line);
        rend.setColor(.0f, .0f, .0f, 1);
        rend.rect(dx, dy, width, height);

        rend.set(ShapeRenderer.ShapeType.Filled);
        rend.setColor(.0f, .0f, .0f, 1);
        snake.draw(this);
        apple.draw(this);
    }


    /**
     * Method to update snake direction.
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

        if (direction == Snake.Direction.SPACE) {
            snake.init(0, 0, 5);
            apple = new Apple(this, snake,Math.random());
            gameUpdateTimer.setActive(true);
        }
    }
}