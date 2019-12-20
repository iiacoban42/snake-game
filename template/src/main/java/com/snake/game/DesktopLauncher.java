package com.snake.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.snake.game.screens.ScreenController;

/**
 * Launches game app.
 */
public class DesktopLauncher {
    /**
     * Launch game app.
     * @param arg .
     */
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.forceExit = false;
        config.title = "Snake";
        new LwjglApplication(new ScreenController(), config);
    }
}
