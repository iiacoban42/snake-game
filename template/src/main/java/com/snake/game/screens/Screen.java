package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snake.game.game.ScreenController;

public abstract class Screen implements com.badlogic.gdx.Screen {

    protected Stage stage;
    protected ScreenController sc;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ScreenController getSc() {
        return sc;
    }

    public void setSc(ScreenController sc) {
        this.sc = sc;
    }

    Screen(ScreenController sc){
        this.sc = sc;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
