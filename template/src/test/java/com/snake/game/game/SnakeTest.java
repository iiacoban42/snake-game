package com.snake.game.game;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class SnakeTest {

    @Test
    void testCreateSnake() {

        Snake snake = new Snake(1,2,2);

        int snakeLength = snake.getLength();
        int snakeX = snake.getSnake().getFirst().getX();
        int snakeY = snake.getSnake().getFirst().getY();

        assertEquals(snakeLength, 2);
        assertEquals(snakeX, 1);
        assertEquals(snakeY, 2);

    }

    @Test
    void testGetSnake() {

        Snake snake = new Snake(1,2,2);
        LinkedList<Snake.Body> snakeBody = snake.getSnake();

        int snakeX = snakeBody.getFirst().getX();
        int snakeY = snakeBody.getFirst().getY();

        assertEquals(snakeX, 1);
        assertEquals(snakeY, 2);

    }

    @Test
    void testSetSnake() {

        Snake snake = new Snake(1,2,2);
        LinkedList<Snake.Body> snakeBody = new LinkedList<>();

        snake.setSnake(snakeBody);

        LinkedList<Snake.Body> snakeBodyReturned = snake.getSnake();

        assertEquals(snakeBodyReturned, snakeBody);


    }

    @Test
    void testKillSnake() {

        Snake snake = new Snake(1,2,2);
        snake.killSnake();

        assertEquals(snake.getSnake().size(), 0);


    }

    @Test
    void testSetLength() {

        Snake snake = new Snake(1,2,2);
        assertEquals(snake.getLength(), 2);

        snake.setLength(3);

        assertEquals(snake.getLength(), 3);


    }

    @Test
    void testIncrementLength() {

        Snake snake = new Snake(1,2,2);
        assertEquals(snake.getLength(), 2);

        snake.addLength(3);

        assertEquals(snake.getLength(), 5);


    }



    @Test
    void testSetDirection() {

        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.LEFT);

        Snake snake = new Snake(1,2,2);
        assertEquals(snake.getDirection().getDirection(), Snake.Direction.RIGHT);

        snake.setDirection(directionQueue);


        assertEquals(snake.getDirection().getDirection(), Snake.Direction.LEFT);

    }

    @Test
    void testCollidesTrue() {

        Snake snake = new Snake(1,2,2);
        assertEquals(snake.collides(1,2), true);


    }

    @Test
    void testCollidesFalse() {

        Snake snake = new Snake(1,2,2);
        assertEquals(snake.collides(1,3), false);

    }

    @Test
    void testMoveFalse() {
        Snake snake = new Snake(1,2,0);
        assertEquals(snake.move(), false);

    }

    @Test
    void testMoveTrue() {
        Snake snake = new Snake(1,2,0);
        assertEquals(snake.move(), false);

    }

    @Test
    void testOrthogonalDirect() {
        Snake snake = new Snake(1,2,0);
        assertEquals(snake.getDirection().getDirection().isOrthogonalTo(Snake.Direction.UP), true);

    }

    @Test
    void testNonOrthogonalDirect() {
        Snake snake = new Snake(1,2,0);
        assertEquals(snake.getDirection().getDirection().isOrthogonalTo(Snake.Direction.LEFT), false);

    }








}
