package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.badlogic.gdx.audio.Sound;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AppleTest {

    @Test
    void testAppleConstructorAndGetters() {
        Apple appleTest = new Apple(5, 3);

        assertEquals(5, appleTest.getXcoord());
        assertEquals(3, appleTest.getYcoord());
    }

    @Test
    void testAppleDoesntCollide() {
        Sound sound = Mockito.mock(Sound.class);
        Mockito.when(sound.play(1.0f)).thenReturn(0L);
        Snake snake = new Snake(1,2,2, sound);
        Sound powerUpSound = Mockito.mock(Sound.class);
        Mockito.when(powerUpSound.play(1.0f)).thenReturn(0L);
        Sound eatingSound = Mockito.mock(Sound.class);
        Mockito.when(eatingSound.play(1.0f)).thenReturn(0L);
        Board board = new Board(null, snake, eatingSound, powerUpSound);
        board.setSnake(snake);

        for (int i = 0; i < 200; i++) {
            Apple apple = Apple.spawnApplePersistent(board);
            assertFalse(board.getSnake().collides(apple.getXcoord(), apple.getYcoord()));
        }
    }
}
