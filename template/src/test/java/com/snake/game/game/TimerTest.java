package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class TimerTest {

    @Test
    void testBoardConstructor() {

        Timer timer = new Timer(null);

        assertEquals(timer.getDuration(), 100);
        assertEquals(timer.getNextActionTimer(), 0);
        assertEquals(timer.isActive(), false);


    }

    @Test
    void testSetActive() {

        Timer timer = new Timer(null);

        timer.setActive(true);
        assertEquals(timer.isActive(), true);



    }

    @Test
    void testSetNextActionTimer() {

        Timer timer = new Timer(null);

        timer.setNextActionTimer(1);
        assertEquals(timer.getNextActionTimer(), 1);


    }

    @Test
    void testTimerHandler() {

        Timer timer = new Timer(null);

        timer.setNextActionTimer(1);
        timer.timerHandler(0);
        // Assertion?
        assertEquals(1, timer.getNextActionTimer());

    }

    @Test
    void testTimerHandlerSkipped() {

        Game game = new Game(null);

        Timer timer = new Timer<>(game::run);

        timer.setNextActionTimer(100);
        timer.setActive(true);
        timer.timerHandler(1210);
        assertEquals(timer.getNextActionTimer() > 100, true);

    }
}