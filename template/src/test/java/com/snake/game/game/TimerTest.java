package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class TimerTest {

    @Test
    void testTimerConstructor() {

        Timer timer = new Timer(Mockito.mock(Runnable.class));

        assertEquals(timer.getDuration(), 100);
        assertEquals(timer.getNextActionTimer(), 0);
        assertEquals(timer.isActive(), false);

    }

    @Test
    void testSetActive() {

        Timer timer = new Timer(Mockito.mock(Runnable.class));

        timer.setActive(true);
        assertEquals(timer.isActive(), true);

    }

    @Test
    void testSetNextActionTimer() {

        Timer timer = new Timer(Mockito.mock(Runnable.class));

        timer.setNextActionTimer(1);
        assertEquals(timer.getNextActionTimer(), 1);

    }

    /**
     * Test that the timer due to the timer being inactive.
     * Good Weather
     */
    @Test
    void testTimerHandlerInactive() {

        Timer timer = new Timer(Mockito.mock(Runnable.class));

        timer.setActive(false);
        timer.setNextActionTimer(10);
        timer.timerHandler(20);
        assertEquals(timer.getNextActionTimer(), 10);

    }

    /**
     * Test that the timer will return due to NextActionTimer > currentTime.
     * Good Weather
     */
    @Test
    void testTimerHandlerReturn() {

        Timer timer = new Timer(Mockito.mock(Runnable.class));

        timer.setActive(true);
        timer.setNextActionTimer(100);
        timer.timerHandler(10);
        assertEquals(timer.getNextActionTimer(), 100);

    }

    /**
     * Test that the timer will update the NextActionTimer.
     * Due to detecting tooManyUpdates
     * Good Weather Test
     */
    @Test
    void testTooManyUpdates() {


        Timer timer = new Timer(Mockito.mock(Runnable.class));

        timer.setActive(true);
        timer.setNextActionTimer(200);
        timer.timerHandler(10000);
        // 98 *100 + 200 baseline
        assertEquals(timer.getNextActionTimer(), 10000);

    }

    /**
     * Test that the timer will run the runnable and update the nextActionTimer.
     * Good Weather Test
     */
    @Test
    void testGameRan() {

        Timer timer = new Timer(Mockito.mock(Runnable.class));

        timer.setActive(true);
        timer.setNextActionTimer(100);
        timer.timerHandler(200);
        // 100 + 100 baseline
        assertEquals(timer.getNextActionTimer(), 200);

    }
}