package com.snake.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

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
     * @param screenName the name of the screen
     */
    public void openScreen(ScreenName screenName) {
        Screen screen = screens.get(screenName);
        setScreen(screen);
        Gdx.input.setInputProcessor(screen.getStage());
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        screens.put(ScreenName.loginScreen, new LoginScreen(this));
        screens.put(ScreenName.gameScreen, new GameScreen(this));

        openScreen(ScreenName.loginScreen);
    }

    enum ScreenName {
        loginScreen, registerScreen, gameScreen
    }
}
