package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

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

    Screen(ScreenController sc) {
        this.sc = sc;
    }

    public Stage getStage() {
        return stage;
    }

    public static boolean validUser(String text) {
        return text != null && !text.isEmpty();
    }

    public static boolean validPassword(String text) {
        return text != null && !text.isEmpty()
                && (text.length() >= 8) && (text.length() < 32);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(.7f, .7f, .7f, 1);
        shapeRenderer.rect(0, 0, 640, 50);
        shapeRenderer.rect(0, 380, 640, 200);
        shapeRenderer.end();

        stage.draw();
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
}
