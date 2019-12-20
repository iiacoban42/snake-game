package com.snake.game.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * An abstract screen class.
 */
public abstract class Screen implements com.badlogic.gdx.Screen, ApplicationListener {

    public static final float standardWidth = 640f;
    public static final float standardHeight = 480f;

    protected Stage stage;

    protected final ScreenController sc;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ScreenController getSc() {
        return sc;
    }

    Screen(ScreenController sc) {
        this.sc = sc;
    }

    public Stage getStage() {
        return stage;
    }

    /**
     * Returns the validity to be a 'username' of the given string.
     * @param text the given string
     * @return returns true if it is the correct length and only contains alpha-numeral characters
     */
    public static boolean validUser(String text) {
        assert text != null;
        final int minLength = 1;
        final int maxLength = 32;
        return text.length() >= minLength
                && text.length() < maxLength
                && text.matches("[a-zA-Z0-9_ ]+");
    }

    /**
     * Returns the validity to be a 'password' of the given string.
     * @param text the given string
     * @return returns true if it is the correct length
     */
    public static boolean validPassword(String text) {
        assert text != null;
        final int minLength = 1;
        final int maxLength = 32;
        return text.length() >= minLength
                && text.length() < maxLength;
    }
}
