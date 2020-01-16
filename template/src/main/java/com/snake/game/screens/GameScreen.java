package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;
import com.snake.game.game.User;
import com.snake.game.states.ActiveGameState;
import com.snake.game.states.EmptyGameState;
import com.snake.game.states.FinishedGameState;
import com.snake.game.states.GameStateName;
import com.snake.game.states.PauseGameState;

/**
 * The screen on which the playing board predominately takes place.
 */
public class GameScreen extends Screen {

    // GUI elements
    private final ShapeRenderer renderer;
    private final Game game;
    private final Skin skin;

    private final transient Group statGroup;
    private final transient Label usernameLabel;
    private final transient Label scoreLabel;
    private final transient Label pauseLabel;

    private final transient Group overlayGroup;
    private final transient Label gamePausedLabel;
    private final transient Label gameOverLabel;
    private final transient TextButton resumeButton;
    private final transient TextButton scoresButton;
    private final transient TextButton restartButton;
    private final transient TextButton menuButton;

    private final transient TextButton settingsButton;


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

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        skin = new Skin(fileHandle);

        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();
        labelStyle.fontColor = Color.DARK_GRAY;

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = new BitmapFont();
        textButtonStyle.fontColor = Color.DARK_GRAY;


        // statGroup
        usernameLabel = new Label("", labelStyle);
        usernameLabel.setFontScale(1.3f);
        usernameLabel.setPosition(0, 250);
        scoreLabel = new Label("blabla", labelStyle);
        scoreLabel.setPosition(0, 200);
        pauseLabel = new Label("Press Space to start/pause", labelStyle);
        pauseLabel.setPosition(0, 50);

        settingsButton = new TextButton("settings", skin);
        settingsButton.setSize(100,40);


        // overlayGroup
        gamePausedLabel = new Label("Game paused", labelStyle);
        gamePausedLabel.setFontScale(2f);
        gamePausedLabel.setBounds(0, 200, 200, 40);
        gameOverLabel = new Label("Game over", labelStyle);
        gameOverLabel.setFontScale(2f);
        gameOverLabel.setBounds(0, 200, 200, 40);

        resumeButton = new TextButton("Resume", skin);
        resumeButton.setBounds(0,120,200,40);
        scoresButton = new TextButton("Scores", skin);
        scoresButton.setBounds(0,120,200,40);
        restartButton = new TextButton("Restart", skin);
        restartButton.setBounds(0,60,200,40);
        menuButton = new TextButton("Menu", skin);
        menuButton.setBounds(0,0,200,40);


        statGroup = new Group();
        statGroup.addActor(usernameLabel);
        statGroup.addActor(pauseLabel);
        statGroup.addActor(scoreLabel);
        statGroup.addActor(settingsButton);

        overlayGroup = new Group();
        overlayGroup.addActor(resumeButton);
        overlayGroup.addActor(restartButton);
        overlayGroup.addActor(menuButton);

        stage.addActor(overlayGroup);
        stage.addActor(statGroup);

        overlayGroup.setVisible(false);
        addListeners();
        updatePositions();
    }

    private void updatePositions() {
        statGroup.setPosition(400,100);
        overlayGroup.setPosition(
                game.getBoard().getBoardX() + (game.getBoard().getBoardWidth() - 200) * .5f,
                game.getBoard().getBoardY() + (game.getBoard().getBoardHeight() - 160) * .5f);
    }

    private void addListeners() {
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.enterState(GameStateName.active);
                overlayGroup.setVisible(false);
            }
        });

        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.enterState(GameStateName.newGame);
                overlayGroup.setVisible(false);
            }
        });

        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.loginScreen);
                overlayGroup.setVisible(false);
            }
        });
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)
                || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {

            if (game.getState() instanceof ActiveGameState) {
                game.enterState(GameStateName.paused);
                overlayGroup.setVisible(true);
            } else if (game.getState() instanceof EmptyGameState
                    || game.getState() instanceof PauseGameState) {
                game.enterState(GameStateName.active);
                overlayGroup.setVisible(false);
            } else if (game.getState() instanceof FinishedGameState) {
                game.enterState(GameStateName.newGame);
                overlayGroup.setVisible(false);
            }

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
