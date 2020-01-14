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
import com.snake.game.game.ScoreLabel;
import com.snake.game.game.Snake;
import com.snake.game.game.User;

/**
 * The screen on which the playing board predominately takes place.
 */
public class GameScreen extends Screen {

    private final Board board;
    private final ShapeRenderer renderer;
    private final transient ScoreLabel scoreLabel;
    private final transient Label usernameLabel;
    private final transient String usernameLabelFormat = "Welcome %s";
    private transient Game game;

    public Board getBoard() {
        return board;
    }

    public ShapeRenderer getRenderer() {
        return renderer;
    }

    /**
     * Create Game screen.
     *
     * @param sc Screen Controller
     */
    public GameScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();

        game = new Game(sc);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        board = new Board(renderer);
        scoreLabel = new ScoreLabel(board.getScore(), stage);


        Label.LabelStyle usernameLabelStyle = new Label.LabelStyle();
        usernameLabelStyle.font = new BitmapFont();
        usernameLabelStyle.fontColor = Color.DARK_GRAY;

        usernameLabel = new Label("", usernameLabelStyle);
        usernameLabel.setPosition(400, 330);
        usernameLabel.setFontScale(1.3f);
        stage.addActor(usernameLabel);
        game.setBoard(board);
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)
                || Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            board.updateDirection(Snake.Direction.UP);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)
                || Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            board.updateDirection(Snake.Direction.DOWN);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)
                || Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            board.updateDirection(Snake.Direction.LEFT);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)
                || Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            board.updateDirection(Snake.Direction.RIGHT);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            board.updateDirection(Snake.Direction.SPACE);
        }


        game.updateBoardTimer();

        // Clear the screen
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Start new Renderer
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background design props
        renderer.setColor(.42f, .82f, .32f, 1);
        renderer.rect(0, 380, 640, 200);

        // Draw the board
        game.observe();

        // Finalize renderer
        renderer.end();

        scoreLabel.draw();
        usernameLabel.setText(String.format(usernameLabelFormat, User.getInstance().getUsername()));

        // Draw overlaying Actors of stage
        stage.draw();
    }


    @Override
    public void create() {

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
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }

}
