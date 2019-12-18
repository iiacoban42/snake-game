package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;
import com.snake.game.game.Timer;

public class SpeedUp extends PowerUp {

    private Timer<Runnable> timer;

    public SpeedUp(Board board, Snake snake, float random, float randomy, Timer<Runnable> timer){
        super.PowerUp(board, snake, random, randomy);
        this.timer = timer;
    }

    @Override
    public void draw(Board board) {
        board.getRend().circle(
                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());
//        board.getRend().ellipse(
//                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
//                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
//                board.getTile() / 2.0f,
//                2);
    }

    @Override
    public void handle(Snake snake) {
        System.out.println("COLLIDE!!!!!!!!!!");
        Long time = System.currentTimeMillis();
        //timer.setDuration(70);
        Timer<Runnable> gameUpdateTimer = new Timer<>(board::run, 30);
        board.setGameUpdateTimer(gameUpdateTimer);
        gameUpdateTimer.setActive(true);
        TimeHandler timeHandler = new TimeHandler(30000, this);
        timeHandler.start();
        //TODO thread
    }

//    @Override
//    public void run() {
//        Long time = System.currentTimeMillis();
//        Long t1 = 0L;
//        while (t1 - time < 3000) {
//            t1 = System.currentTimeMillis();
//        }
//       board.setGameUpdateTimer(gameUpdateTimer);
//        gameUpdateTimer.setActive(true);
//        System.out.println("DONE");
//    }
}
