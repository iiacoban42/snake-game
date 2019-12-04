package com.snake.game.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.screens.GameScreen;
import com.snake.game.screens.LoginScreen;

public class ScreenController extends Game {

    public SpriteBatch batch;

    private Screen loginScreen;
    private Screen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        loginScreen = new LoginScreen();
        gameScreen = new GameScreen();

        setScreen(loginScreen);
    }

    @Override
    public void render() {
        super.render();
    }
}
