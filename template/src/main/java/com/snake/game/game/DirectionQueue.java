package com.snake.game.game;

import java.util.LinkedList;

public class DirectionQueue {
    LinkedList<Snake.Direction> keyQueue;
    public DirectionQueue(Snake.Direction startDirection){
        keyQueue = new LinkedList<>();
        keyQueue.addLast(startDirection);
    }

    public void enqueue(Snake.Direction direction){
        if(keyQueue.getLast().isOrthogonalTo(direction))
            keyQueue.addLast(direction);
    }
    public void dequeue(){
        if(keyQueue.size() > 1)
            keyQueue.removeFirst();

    }
    public Snake.Direction getDirection(){
        return keyQueue.getFirst();
    }
}
