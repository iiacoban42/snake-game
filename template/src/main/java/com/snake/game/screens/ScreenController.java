package com.snake.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.snake.game.screens.GameScreen;
import com.snake.game.screens.LoginScreen;
import com.snake.game.screens.Screen;

public class ScreenController extends Game {

    public SpriteBatch batch;

    public Screen loginScreen;
    public Screen gameScreen;

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Screen getLoginScreen() {
        return loginScreen;
    }

    public void setLoginScreen(Screen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public Screen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(Screen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void openScreen(Screen s) {
        setScreen(s);
        Gdx.input.setInputProcessor(s.getStage());
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        loginScreen = new LoginScreen(this);
        gameScreen = new GameScreen(this);


        openScreen(loginScreen);
    }

    @Override
    public void render() {
        super.render();
    }
}
