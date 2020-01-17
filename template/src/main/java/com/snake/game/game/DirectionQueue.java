package com.snake.game.game;

import java.util.LinkedList;

/**
 * Class is used to execute consecutive moves from input.
 */
public class DirectionQueue {
    private LinkedList<Snake.Direction> keyQueue;

    public LinkedList<Snake.Direction> getKeyQueue() {
        return keyQueue;
    }

    public void setKeyQueue(LinkedList<Snake.Direction> keyQueue) {
        this.keyQueue = keyQueue;
    }

    public DirectionQueue(Snake.Direction startDirection) {
        keyQueue = new LinkedList<>();
        keyQueue.addLast(startDirection);
    }

    /**
     * Method to enqueue a direction.
     * @param direction snake direction
     */
    public void enqueue(Snake.Direction direction) {
        if (keyQueue.getLast().isOrthogonalTo(direction)) {
            keyQueue.addLast(direction);
        }
    }

    /**
     * Method to dequeue snake direction.
     */
    public void dequeue() {
        int minSize = 1;
        if (keyQueue.size() > minSize) {
            keyQueue.removeFirst();
        }

    }

    public Snake.Direction getDirection() {
        return keyQueue.getFirst();
    }

}
