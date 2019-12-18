package com.snake.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.snake.game.game.ScreenController;

public class DesktopLauncher {
    /**
     * Test
     * Launch game app.
     * @param arg .
     */
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.forceExit = false;
        new LwjglApplication(new ScreenController(), config);
    }
}
