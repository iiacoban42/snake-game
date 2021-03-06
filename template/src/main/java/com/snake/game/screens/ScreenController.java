package com.snake.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

/**
 * The controller which handles screen switching and initialization process.
 */
public class ScreenController extends com.badlogic.gdx.Game {

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

        screens.put(ScreenName.loginScreen, new MenuScreen(this));
        screens.put(ScreenName.gameScreen, new GameScreen(this));
        screens.put(ScreenName.startScreen, new StartScreen(this));
        screens.put(ScreenName.leaderboardScreen, new LeaderboardScreen(this));

        openScreen(ScreenName.loginScreen);
    }

    public enum ScreenName {
        loginScreen, startScreen, gameScreen, leaderboardScreen
    }
}
