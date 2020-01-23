package com.snake.game.game;

import com.badlogic.gdx.audio.Sound;

public class SoundWrapper {
    private Sound sound;

    public SoundWrapper(Sound s) {
        sound = s;
    }

    public void play() {
        Settings s = Settings.getInstance();

        if (!s.isMuted()) {
            sound.play();
        }
    }

}
