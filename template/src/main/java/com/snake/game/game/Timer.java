package com.snake.game.game;


public class Timer<T extends Runnable> {

    private final double duration;
    private final T runnable;

    private long nextActionTimer = 0;
    private boolean active = false;

    public Timer(T runnable, double duration) {
        this.runnable = runnable;
        this.duration = duration;
    }

    public Timer(T runnable) {
        this(runnable, 100);
    }

    public long getNextActionTimer() {
        return nextActionTimer;
    }

    public void setNextActionTimer(long nextActionTimer) {
        this.nextActionTimer = nextActionTimer;
    }

    public double getDuration() {
        return duration;
    }

    public boolean isActive() {
        return active;
    }

    public T getRun() {
        return runnable;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method to handle current time.
     * @param currentTime current time
     */
    public void timerHandler(final long currentTime) {
        if (!active || nextActionTimer > currentTime) {
            return;
        }

        final long updateAmount = (long) ((currentTime - nextActionTimer) / duration);
        final long tooManyUpdates = 10;
        if (updateAmount > tooManyUpdates) {
            //System.err.println("WARNING: Skipping " + updateAmount + " ticks due to runtime lag");
            nextActionTimer += duration * updateAmount;
        }

        while (nextActionTimer < currentTime) {
            runnable.run();
            nextActionTimer += duration;
        }
    }
}