package com.snake.game.game;


public class Timer<T extends Runnable> {
    private long delay = 0;
    private double duration = 100.0;
    private boolean active = false;
    private T run;

    public Timer(T t) {
        run = t;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public boolean isActive() {
        return active;
    }

    public T getRun() {
        return run;
    }

    public void setRun(T run) {
        this.run = run;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void timerHandler() {
        if (!active) {
            return;
        }
        final long currentTime = System.currentTimeMillis();
        if (delay > currentTime) {
            return;
        }

        final long updateAmount = (long) ((currentTime - delay) / duration);
        final long tooManyUpdates = 10;
        if (updateAmount > tooManyUpdates) {
            delay += duration * updateAmount;
        }
        while (delay < currentTime) {
            {
                run.run();
            }
            delay += duration;
        }

    }
}
