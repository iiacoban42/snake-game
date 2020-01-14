package com.snake.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.snake.game.screens.ScreenController;

/**
 * Launches game app.
 */
public class DesktopLauncher {

    private static final String NAME = "Shnek";

    /**
     * Launch game app.
     * @param arg .
     */
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.forceExit = false;
        config.title = NAME;
        new LwjglApplication(new ScreenController(), config);
    }
}
