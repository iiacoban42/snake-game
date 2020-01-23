package com.snake.game.game;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Singleton to manage settings in.
 */
public class Settings {

    private static Settings instance;
    private Preferences prefs;

    /**
     * Private constructor for this class.
     */
    private Settings() {
        this.prefs = Preferences.userRoot().node(this.getClass().getName());
    }

    /**
     * Get the single instance of this class.
     *
     * @return the single instance
     */
    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }

        return instance;
    }

    /**
     * See if game is muted.
     * @return whether or not the game is muted
     */
    public boolean isMuted() {
        return prefs.getBoolean("muted", false);
    }

    /**
     * Mute the game.
     */
    public void mute() {
        prefs.putBoolean("muted", true);
    }

    /**
     * Unmute the game.
     */
    public void unmute() {
        prefs.putBoolean("muted", false);
    }

    /**
     * Reset all settings.
     */
    public void reset() {
        try {
            this.prefs.clear();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve the preferences object used.
     * @return preferences object
     */
    public Preferences getPrefs() {
        return prefs;
    }

    /**
     * Replace the preferences object used.
     * @param prefs new prefs object
     */
    public void setPrefs(Preferences prefs) {
        this.prefs = prefs;
    }
}
