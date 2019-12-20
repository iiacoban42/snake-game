package com.snake.game.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

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

    public static boolean validUser(String text) {
        return text != null && !text.isEmpty();
    }

    public static boolean validPassword(String text) {
        return text.length() >= 8 && text.length() < 32;
    }
}
