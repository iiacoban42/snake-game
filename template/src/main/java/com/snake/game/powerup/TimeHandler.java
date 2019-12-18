package com.snake.game.powerup;

import com.snake.game.game.Timer;

/**
 * Thread to update game objects after certain amount of time has passed.
 */
public class TimeHandler extends Thread {

    public int time;
    public PowerUp powerUp;

    public TimeHandler(int time, PowerUp powerUp) {
        this.time = time;
        this.powerUp = powerUp;
    }

    /**
     * Record if n seconds have passed.
     */
    public void run() {
        Long time = System.currentTimeMillis();
        Long t1 = 0L;
        while (t1 - time < 3000) {
            t1 = System.currentTimeMillis();
        }
        Timer<Runnable> gameUpdateTimer = new Timer<>(powerUp.board::run);
        powerUp.board.setGameUpdateTimer(gameUpdateTimer);
        gameUpdateTimer.setActive(true);
        System.out.println("DONE");
    }
}
