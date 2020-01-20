package com.snake.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundSystem {

    private Sound eatingSound;
    private Sound powerUpSound;
    private Sound deathSound;

    /**
     * Constructor.
     */
    public SoundSystem() {
        eatingSound = Gdx.audio.newSound(Gdx.files.internal("/resources/eatingSound.mp3"));
        powerUpSound = Gdx.audio.newSound(Gdx.files.internal("/resources/powerupSound.mp3"));
        deathSound = Gdx.audio.newSound(Gdx.files.internal("/resources/deathSound.mp3"));
    }

    public Sound getEatingSound() {
        return eatingSound;
    }

    public void setEatingSound(Sound eatingSound) {
        this.eatingSound = eatingSound;
    }

    public Sound getPowerUpSound() {
        return powerUpSound;
    }

    public void setPowerUpSound(Sound powerUpSound) {
        this.powerUpSound = powerUpSound;
    }

    public Sound getDeathSound() {
        return deathSound;
    }

    public void setDeathSound(Sound deathSound) {
        this.deathSound = deathSound;
    }
}
