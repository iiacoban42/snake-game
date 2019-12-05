package com.snake.game.game;


public class Timer<T extends Runnable> {
    private long delay = 0;
    private double duration = 100.0;
    private boolean active = false;
    private T run;

    public Timer(T t) {
        run = t;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void timerHandler() {
        if (!active) return;
        final long currentTime = System.currentTimeMillis();
        if (delay > currentTime) return;

        final long updateAmount = (long) ((currentTime - delay) / duration);
        final long tooManyUpdates = 10;
        if (updateAmount > tooManyUpdates)
            delay += duration * updateAmount;
        while (delay < currentTime) {
            {
                run.run();


            }
            delay += duration;
        }

    }
}
