package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.badlogic.gdx.audio.Sound;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


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
    void testTimerHandlerSKipped() {

        Sound sound = Mockito.mock(Sound.class);
        Mockito.when(sound.play(1.0f)).thenReturn(0L);
        Snake snake = new Snake(0, 0, 5, sound);
        Sound powerUpSound = Mockito.mock(Sound.class);
        Mockito.when(powerUpSound.play(1.0f)).thenReturn(0L);
        Sound eatingSound = Mockito.mock(Sound.class);
        Mockito.when(eatingSound.play(1.0f)).thenReturn(0L);
        Board board = new Board(null, snake, eatingSound, powerUpSound);

        Timer timer = new Timer<>(board::run);

        timer.setNextActionTimer(100);
        timer.setActive(true);
        timer.timerHandler(1210);
        assertEquals(timer.getNextActionTimer() > 100, true);

    }
}