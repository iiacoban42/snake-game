package com.snake.game.game;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Settings {

    private static Settings instance;
    private Preferences prefs;

    private Settings() {
        this.prefs = Preferences.userRoot().node(this.getClass().getName());
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }

        return instance;
    }

    public boolean isMuted() {
        return prefs.getBoolean("muted", false);
    }

    public void mute() {
        prefs.putBoolean("muted", true);
    }

    public void unmute() {
        prefs.putBoolean("muted", false);
    }

    public void reset() {
        try {
            this.prefs.clear();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }
}
