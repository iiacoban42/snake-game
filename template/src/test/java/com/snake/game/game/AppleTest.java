package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppleTest {

    @Test
    void testAppleConstructor() {

        Snake snake = new Snake(1,2,2);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake, Math.random(), Math.random());

        assertEquals((appleTest.getXcoord() > 0), true);
        assertEquals((appleTest.getYcoord() > 0), true);

    }

    @Test
    void testGetX() {

        Snake snake = new Snake(1,2,2);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake, 5, 3);

        assertEquals((appleTest.getXcoord() > 0), true);

    }

    @Test
    void testGetY() {

        Snake snake = new Snake(1,2,2);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake, 5, 3);

        assertEquals((appleTest.getYcoord() > 0), true);

    }

    @Test
    void testConstructorSnakeCollide() {

        Snake snake = new Snake(100,100,1);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake, 5, 3);

        assertEquals((appleTest.getYcoord() > 0), true);

    }
}
