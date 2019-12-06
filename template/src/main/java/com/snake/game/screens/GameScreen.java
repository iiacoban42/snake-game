package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snake.game.game.Board;
import com.snake.game.game.ScreenController;
import com.snake.game.game.Snake;

public class GameScreen extends Screen {

    final Board board;
    final ShapeRenderer renderer;

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
    public GameScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        board = new Board(renderer);
    }


    @Override
    public void render(float delta) {

        // Handlers that rely on per-frame firing

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            board.updateDirection(Snake.Direction.UP);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) || Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            board.updateDirection(Snake.Direction.DOWN);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            board.updateDirection(Snake.Direction.LEFT);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            board.updateDirection(Snake.Direction.RIGHT);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            board.updateDirection(Snake.Direction.SPACE);
        }

        
        board.timerHandler();

        // Clear the screen
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Start new Renderer
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background design props
        renderer.setColor(.7f, .7f, .7f, 1);
        renderer.rect(0, 380, 640, 200);

        // Draw the board
        board.draw();

        // Finalize renderer
        renderer.end();

        // Draw overlaying Actors of stage
        //stage.draw();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }

}
