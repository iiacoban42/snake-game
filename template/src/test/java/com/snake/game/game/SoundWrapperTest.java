package com.snake.game.game;

import com.badlogic.gdx.audio.Sound;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SoundWrapperTest {

    @Test
    void testPlayMuted() {
        Settings.getInstance().mute();

        Sound mockedSound = Mockito.mock(Sound.class);
        SoundWrapper sw = new SoundWrapper(mockedSound);

        sw.play();

        Mockito.verify(mockedSound, Mockito.never()).play();
    }

    @Test
    void testPlayUnmuted() {
        Settings.getInstance().unmute();

        Sound mockedSound = Mockito.mock(Sound.class);
        SoundWrapper sw = new SoundWrapper(mockedSound);

        sw.play();

        Mockito.verify(mockedSound, Mockito.times(1)).play();
    }

}
