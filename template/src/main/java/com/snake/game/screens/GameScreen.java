package com.snake.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snake.game.game.Board;
import com.snake.game.game.ScreenController;

public class GameScreen extends Screen {
    Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ShapeRenderer getR() {
        return r;
    }

    public void setR(ShapeRenderer r) {
        this.r = r;
    }

    public GameScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();


        board = new Board(r);
    }

    ShapeRenderer r = new ShapeRenderer();

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        board.updateDirection();
        board.timerHandler();


        r.begin(ShapeRenderer.ShapeType.Filled);
        r.setColor(.7f, .7f, .7f, 1);
        //r.rect(0,0,640,50);
        r.rect(0, 380, 640, 200);

        board.draw();

        r.end();

        stage.draw();

    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose(){

    }

}
