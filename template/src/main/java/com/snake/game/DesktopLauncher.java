package com.snake.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.snake.game.screens.ScreenController;

/**
 * Launches game app.
 */
public class DesktopLauncher {

    private static final String NAME = "Shnaeque";

    /**
     * Launch game app.
     * @param arg .
     */
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.forceExit = true;
        config.title = NAME;
        new LwjglApplicationNoExitCode(new ScreenController(), config);
    }

    @SuppressWarnings({"PMD.DoNotCallSystemExit"})
    static class LwjglApplicationNoExitCode extends LwjglApplication {
        @Override
        public void exit() {
            try {
                super.exit();
            } catch (Exception e) {
                //Stop at any exceptions
                return;
            }
            System.exit(0);
        }

        public LwjglApplicationNoExitCode(ApplicationListener listener,
                                          LwjglApplicationConfiguration config) {
            super(listener, config);
        }
    }
}
