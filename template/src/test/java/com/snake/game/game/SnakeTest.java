package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;


public class SnakeTest {

    @Test
    void testCreateSnake() {

        Snake snake = new Snake(1,2,2);

        int snakeLength = snake.getLength();
        int snakeX = snake.getSnakeBody().getFirst().getPosX();
        int snakeY = snake.getSnakeBody().getFirst().getPosY();

        assertEquals(snakeLength, 2);
        assertEquals(snakeX, 1);
        assertEquals(snakeY, 2);

    }

    @Test
    void testGetSnake() {

        Snake snake = new Snake(1,2,2);
        LinkedList<Snake.BodyPart> snakeBody = snake.getSnakeBody();

        int snakeX = snakeBody.getFirst().getPosX();
        int snakeY = snakeBody.getFirst().getPosY();

        assertEquals(snakeX, 1);
        assertEquals(snakeY, 2);

    }

    @Test
    void testSetSnake() {

        Snake snake = new Snake(1,2,2);
        LinkedList<Snake.BodyPart> snakeBody = new LinkedList<>();

        snake.setSnakeBody(snakeBody);

        LinkedList<Snake.BodyPart> snakeBodyReturned = snake.getSnakeBody();

        assertEquals(snakeBodyReturned, snakeBody);


    }

    @Test
    void testKillSnake() {

        Snake snake = new Snake(1,2,2);
        snake.killSnake();

        assertEquals(snake.getSnakeBody().size(), 0);


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
        assertEquals(snake.getDirection().getDirection().isOrthogonalTo(Snake.Direction.LEFT),
                false);

    }








}
