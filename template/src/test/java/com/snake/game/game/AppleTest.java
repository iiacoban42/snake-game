package com.snake.game.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppleTest {

    @Test
    void testAppleConstructor() {

        Snake snake = new Snake(1,2,2);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake,Math.random());

        assertEquals((appleTest.getX() > 0), true);
        assertEquals((appleTest.getY() > 0), true);

    }

    @Test
    void testGetX() {

        Snake snake = new Snake(1,2,2);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake, 5);

        assertEquals((appleTest.getX() > 0), true);

    }

    @Test
    void testGetY() {

        Snake snake = new Snake(1,2,2);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake, 5);

        assertEquals((appleTest.getY() > 0), true);

    }

    @Test
    void testConstructorSnakeCollide() {

        Snake snake = new Snake(100,100,1);
        //ShapeRenderer renderer = new ShapeRenderer();
        //renderer.setAutoShapeType(true);
        Board board = new Board(null);

        Apple appleTest = new Apple(board, snake, 5);

        assertEquals((appleTest.getY() > 0), true);

    }
}
