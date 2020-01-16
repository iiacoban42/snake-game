package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.snake.game.game.*;
import com.snake.game.states.EmptyGameState;
import com.snake.game.states.GameStateName;

/**
 * The screen on which the playing board predominately takes place.
 */
public class GameScreen extends Screen {

    // GUI elements
    private final ShapeRenderer renderer;
    private final Game game;

    private final transient Label scoreLabel;
    private final transient Label usernameLabel;
    private final transient Label pauseLabel;
    private final transient String usernameLabelFormat = "Welcome %s";

    /**
     * Create Game screen.
     *
     * @param sc Screen Controller
     */
    public GameScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();
        game = new Game();
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();
        labelStyle.fontColor = Color.DARK_GRAY;

        scoreLabel = new Label("blabla", labelStyle);
        scoreLabel.setPosition(400, 300);
        scoreLabel.setFontScale(1.3f);

        usernameLabel = new Label("", labelStyle);
        usernameLabel.setPosition(400, 330);
        usernameLabel.setFontScale(1.3f);

        pauseLabel = new Label("Press Esc pause", labelStyle);
        pauseLabel.setPosition(400, 200);


        stage.addActor(pauseLabel);
        stage.addActor(usernameLabel);
        stage.addActor(scoreLabel);
    }

    @Override
    public void open() {
        super.open();
        usernameLabel.setText(String.format(usernameLabelFormat, User.getInstance().getUsername()));
        game.enterState(GameStateName.newGame);
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
        game.updateBoardTimer();

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)
                || Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            game.updateDirection(Snake.Direction.UP);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)
                || Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            game.updateDirection(Snake.Direction.DOWN);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)
                || Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            game.updateDirection(Snake.Direction.LEFT);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)
                || Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            game.updateDirection(Snake.Direction.RIGHT);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (game.getState() instanceof EmptyGameState) {
                game.enterState(GameStateName.active);
            } else {
                game.updateDirection(Snake.Direction.SPACE);
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.enterState(GameStateName.paused);
        }

        // Clear the screen
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Start new Renderer
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background design props
        renderer.setColor(.42f, .82f, .32f, 1);
        renderer.rect(0, 380, 640, 200);

        // Draw the board
        game.getBoard().draw(renderer);

        // Finalize renderer
        renderer.end();

        // Draw overlaying Actors of stage
        stage.draw();
//        scoreLabel.draw();
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

    public ShapeRenderer getRenderer() {
        return renderer;
    }

    public Game getGame() {
        return game;
    }
}
