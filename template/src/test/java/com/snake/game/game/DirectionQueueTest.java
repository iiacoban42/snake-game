package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class DirectionQueueTest {
    @Test
    void testConstructor() {
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.LEFT);
        assertEquals(directionQueue.getDirection(), Snake.Direction.LEFT);
    }

    @Test
    void testEnqueueNonOrthogonal() {
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.LEFT);
        directionQueue.enqueue(Snake.Direction.RIGHT);
        assertEquals(directionQueue.getKeyQueue().getLast(), Snake.Direction.LEFT);

    }

    @Test
    void testEnqueueOrthogonal() {
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.LEFT);
        directionQueue.enqueue(Snake.Direction.DOWN);
        assertEquals(directionQueue.getKeyQueue().getLast(), Snake.Direction.DOWN);

    }


    @Test
    void testDequeue() {
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.DOWN);
        directionQueue.enqueue(Snake.Direction.LEFT);
        directionQueue.dequeue();
        assertEquals(directionQueue.getDirection(), Snake.Direction.LEFT);

    }

    @Test
    void testGetDirection() {
        DirectionQueue directionQueue = new DirectionQueue(Snake.Direction.DOWN);
        assertEquals(directionQueue.getDirection(), Snake.Direction.DOWN);

    }


}
