package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.snake.game.game.Board;
import com.snake.game.game.Game;

/**
 * The limbo screen when the player has lost the game.
 */
public class GameOverScreen extends Screen {

    final Board board;
    final ShapeRenderer renderer;
    final transient Label endgameLabel;
    private transient Game game;

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

        Label.LabelStyle endgameLabelStyle = new Label.LabelStyle();
        endgameLabelStyle.font = new BitmapFont();
        endgameLabelStyle.fontColor = Color.RED;

        endgameLabel = new Label("", endgameLabelStyle);
        endgameLabel.setPosition(300, 330);
        endgameLabel.setFontScale(1.3f);
        stage.addActor(endgameLabel);
    }


    @Override
    public void show() {

    }

    @Override
    public void render() {

    }

    @Override
    public void render(float delta) {

        // Handlers that rely on per-frame firing

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            sc.openScreen(ScreenController.ScreenName.gameScreen);
        }

        // Clear the screen
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Start new Renderer
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background design props
        renderer.setColor(.7f, .7f, .7f, 1);
        renderer.rect(0, 380, 640, 200);


        // Finalize renderer
        renderer.end();

        endgameLabel.setText("Game is done, press r to restart");

        // Draw overlaying Actors of stage
        stage.draw();
    }


    @Override
    public void create() {

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
