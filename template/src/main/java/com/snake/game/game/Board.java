package com.snake.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Board {
    boolean portalWalls = true;
    final int x = 50, y = 100;
    final int WIDTH = 320, HEIGHT = 320;
    final int GWIDTH = 20, GHEIGHT = 20;


    public boolean isPortalWalls() {
        return portalWalls;
    }

    public void setPortalWalls(boolean portalWalls) {
        this.portalWalls = portalWalls;
    }

    public void setRend(ShapeRenderer rend) {
        this.rend = rend;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getGWIDTH() {
        return GWIDTH;
    }

    public int getGHEIGHT() {
        return GHEIGHT;
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
        snake.move();
        if (snake.collides(apple.getX(), apple.getY())) {
            snake.addLength(3);
            apple = new Apple(this, snake);
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
        }
    }
}
