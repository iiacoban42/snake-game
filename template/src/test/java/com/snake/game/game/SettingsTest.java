package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SettingsTest {

    @BeforeEach
    public void resetAll() {
        Settings.getInstance().reset();
    }

    @Test
    public void testSingleton() {
        Settings s1 = Settings.getInstance();
        Settings s2 = Settings.getInstance();

        Assertions.assertSame(s1, s2);
    }

    @Test
    public void testIsMutedDefault() {
        Settings s = Settings.getInstance();

        assertEquals(false, s.isMuted());
    }

    @Test
    public void testMuteAndUnmute() {
        Settings s = Settings.getInstance();

        s.mute();
        assertEquals(true, s.isMuted());

        s.unmute();
        assertEquals(false, s.isMuted());
    }

    @Test
    public void testUnmuteTwice() {
        Settings s = Settings.getInstance();

        s.unmute();
        assertEquals(false, s.isMuted());

        s.unmute();
        assertEquals(false, s.isMuted());
    }

    @Test
    public void testMuteTwice() {
        Settings s = Settings.getInstance();

        s.mute();
        assertEquals(true, s.isMuted());

        s.mute();
        assertEquals(true, s.isMuted());
    }

}
