package com.snake.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Board {
    boolean portalWalls = true;
    final int dx = 50, dy = 100;
    final int width = 320, height = 320;
    final int gridWidth = 20, gridHeight = 20;

    Timer<Runnable> gameUpdateTimer;

    /**
     * Returns the setting whether the snake can go through walls
     * @return boolean
     */
    public boolean isPortalWalls() {
        return portalWalls;
    }

    /**
     * Returns the setting whether the snake can go through walls
     * @return x
     */
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

    public int getTILE() {
        return TILE;
    }

    public ShapeRenderer getRend() {
        return rend;
    }

    final int TILE = 16;

    ShapeRenderer rend;


    Snake snake;
    Apple apple;

    /**
     * Game update.
     */
    public void run() {

        if(snake.move()){
            snake.killSnake();
            gameUpdateTimer.setActive(false);
            return;
        }
        if (snake.collides(apple.getX(), apple.getY())) {
            snake.addLength(3);
            apple = new Apple(this, snake);
        }

        final int x = snake.getHead().getX();
        final int y = snake.getHead().getY();
        if (x < 0 || x >= gridWidth || y < 0 || y >= gridHeight){
            snake.killSnake();
            gameUpdateTimer.setActive(false);
        }
    }

    /**
     * Constructor
     * @param rend a ShapeRenderer to draw its graphics to
     */
    public Board(ShapeRenderer rend) {
        this.rend = rend;

        snake = new Snake(0, 0, 5);
        apple = new Apple(this, snake);

        gameUpdateTimer = new Timer<>(() -> run());
        gameUpdateTimer.setActive(true);
    }

    public void timerHandler(){
        gameUpdateTimer.timerHandler();
    }

    public void draw() {

        final float grayScale = .85f;
        rend.setColor(grayScale, grayScale, grayScale, 1);
        rend.rect(50, 100, 320, 320);
        rend.setAutoShapeType(true);
        rend.set(ShapeRenderer.ShapeType.Line);
        rend.setColor(.0f, .0f, .0f, 1);
        rend.rect(50, 100, 320, 320);


        rend.set(ShapeRenderer.ShapeType.Filled);
        rend.setColor(.0f, .0f, .0f, 1);
        snake.draw(this);
        apple.draw(this);
    }


    public void updateDirection() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            snake.getDirection().enqueue(Snake.Direction.UP);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            snake.getDirection().enqueue(Snake.Direction.DOWN);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            snake.getDirection().enqueue(Snake.Direction.LEFT);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            snake.getDirection().enqueue(Snake.Direction.RIGHT);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            snake.init(0, 0, 5);
            apple = new Apple(this, snake);
            gameUpdateTimer.setActive(true);
        }
    }
}
