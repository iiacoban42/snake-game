package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.snake.game.game.*;

public class GameOverScreen extends Screen {

    final Board board;
    final ShapeRenderer renderer;
    final transient String usernameLabelFormat = "Welcome %s";
    private Game game;

    public Board getBoard() {
        return board;
    }

    public ShapeRenderer getRenderer() {
        return renderer;
    }

    /**
     * Create Game screen.
     * @param sc Screen Controller
     */
    public GameOverScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();
        game = new Game(sc);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        board = new Board(renderer);
        game.setBoard(board);
    }


    @Override
    public void render(float delta) {

        // Handlers that rely on per-frame firing

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
           sc.openScreen(new GameScreen(sc));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
        }

        // Clear the screen
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Start new Renderer
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background design props
        renderer.setColor(.7f, .7f, .7f, 1);
        renderer.rect(0, 380, 640, 200);

        // Draw the board
        game.observe();

        // Finalize renderer
        renderer.end();

        // Draw overlaying Actors of stage
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }

}
