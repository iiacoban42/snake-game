package com.snake.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

/**
 * The controller which handles screen switching and initialization process.
 */
public class ScreenController extends Game {

    private SpriteBatch batch;

    private final HashMap<ScreenName, Screen> screens = new HashMap<>();

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public HashMap<ScreenName, Screen> getScreens() {
        return screens;
    }

    /**
     * Opens a screen.
     *
     * @param screenName the name of the screen
     */
    public void openScreen(ScreenName screenName) {
        Screen screen = screens.get(screenName);
        assert screen != null;
        setScreen(screen);
        screen.open();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        screens.put(ScreenName.loginScreen, new LoginScreen(this));
        screens.put(ScreenName.registerScreen, new RegisterScreen(this));
        screens.put(ScreenName.gameScreen, new GameScreen(this));
        screens.put(ScreenName.gameOverScreen, new GameOverScreen(this));
        screens.put(ScreenName.startScreen, new StartScreen(this));
        screens.put(ScreenName.pauseMenu, new PauseMenu(this));


        openScreen(ScreenName.loginScreen);
    }

    public enum ScreenName {
        loginScreen, registerScreen, startScreen, gameScreen, gameOverScreen, pauseMenu
    }
}
