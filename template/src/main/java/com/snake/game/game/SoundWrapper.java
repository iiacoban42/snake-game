package com.snake.game.game;

import com.badlogic.gdx.audio.Sound;

/**
 * A wrapper for playing sounds to check if application is muted.
 */
public class SoundWrapper {
    private Sound sound;

    /**
     * Create the wrapper.
     * @param s the sound to wrap
     */
    public SoundWrapper(Sound s) {
        sound = s;
    }

    /**
     * Play if application is not muted.
     */
    public void play() {
        Settings s = Settings.getInstance();

        if (!s.isMuted()) {
            sound.play();
        }
    }

    /**
     * Get the sound thats wrapped.
     * @return the original sound
     */
    public Sound getSound() {
        return sound;
    }

    /**
     * Replace the wrapped sound.
     * @param sound the new sound
     */
    public void setSound(Sound sound) {
        this.sound = sound;
    }

}
