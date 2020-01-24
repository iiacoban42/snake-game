package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Score;
import com.snake.game.game.ScoreLabel;
import com.snake.game.game.Settings;
import com.snake.game.game.SoundSystem;
import com.snake.game.game.User;
import com.snake.game.game.states.GameStateName;
import com.snake.game.game.states.PauseGameState;

/**
 * The screen on which the playing board predominately takes place.
 */
public class GameScreen extends Screen {


    private final ShapeRenderer renderer;
    private final Game game;
    private final Skin skin;

    // GUI elements
    private final transient Group statGroup;
    private final transient Label usernameLabel;
    private final transient ScoreLabel scoreLabel;
    private final transient Label pauseLabel;

    private final transient Group overlayGroup;
    private final transient Label gamePausedLabel;
    private final transient Label gameOverLabel;
    private final transient TextButton resumeButton;
    private final transient TextButton restartButton;
    private final transient TextButton menuButton;

    private final transient TextButton muteButton;


    private final transient String usernameLabelFormat = "Welcome %s";

    /**
     * Create Game screen.
     *
     * @param sc Screen Controller
     */
    public GameScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();
        renderer = new ShapeRenderer();

        Board board = new Board(renderer);
        Score score = new Score();
        SoundSystem soundSystem = new SoundSystem();
        game = new Game(board, score, soundSystem);
        renderer.setAutoShapeType(true);

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        skin = new Skin(fileHandle);


        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = Font.get(14);

        scoreLabel = new ScoreLabel(score, stage);

        // statGroup
        usernameLabel = new Label("", labelStyle);
        usernameLabel.setPosition(0, 250);
        pauseLabel = new Label("Press Space to start/pause", labelStyle);
        pauseLabel.setPosition(0, 50);

        muteButton = new TextButton("Mute", skin);
        if (Settings.getInstance().isMuted()) {
            muteButton.setText("Unmute");
        }
        muteButton.setSize(100,40);


        // overlayGroup
        gamePausedLabel = new Label("Game paused", labelStyle);
        gamePausedLabel.setFontScale(2f);
        gamePausedLabel.setBounds(0, 200, 200, 40);
        gameOverLabel = new Label("Game over", labelStyle);
        gameOverLabel.setFontScale(2f);
        gameOverLabel.setBounds(0, 200, 200, 40);

        resumeButton = buildButton("Resume", 0, 120, 200, 40);
        restartButton = buildButton("Restart", 0, 60, 200, 40);
        menuButton = buildButton("Menu", 0, 0, 200, 40);


        statGroup = new Group();
        statGroup.addActor(usernameLabel);
        statGroup.addActor(pauseLabel);
        statGroup.addActor(muteButton);

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

    /**
     * Quick button builder for this screen.
     * @param text label text
     * @param x x coord
     * @param y y cood
     * @param width width
     * @param height height
     * @return new TextButton
     */
    private TextButton buildButton(String text, int x, int y, int width, int height) {
        TextButton btn = new TextButton(text, skin);
        btn.setBounds(x,y,width,height);
        return btn;
    }

    private void updatePositions() {
        statGroup.setPosition(400,100);
        overlayGroup.setPosition(
                game.getBoard().getBoardX() + (game.getBoard().getBoardWidth() - 200) * .5f,
                game.getBoard().getBoardY() + (game.getBoard().getBoardHeight() - 160) * .5f);
    }

    /**
     * Add all clicklisteners to buttons.
     */
    private void addListeners() {
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                resumeButtonClicked();
            }
        });

        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                restartButtonClicked();
            }
        });

        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuButtonClicked();
            }
        });

        muteButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                muteButtonClicked();
            }
        });
    }

    /**
     * Listener for resume button.
     */
    private void resumeButtonClicked() {
        game.enterState(GameStateName.active);
    }

    /**
     * Listener for restart button.
     */
    private void restartButtonClicked() {
        game.enterState(GameStateName.newGame);
    }

    /**
     * Listener for menu button.
     */
    private void menuButtonClicked() {
        sc.openScreen(ScreenController.ScreenName.startScreen);
    }

    /**
     * Listener for mute button.
     */
    private void muteButtonClicked() {
        Settings s = Settings.getInstance();
        if (s.isMuted()) {
            s.unmute();
            muteButton.setText("Mute");
        } else {
            s.mute();
            muteButton.setText("Unmute");
        }
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
        game.getState().keyPress();
        overlayGroup.setVisible(game.getState() instanceof PauseGameState);

        // Clear the screen
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Start new Renderer
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background design props
        renderer.setColor(.42f, .82f, .32f, 1);
        renderer.rect(0, 380, 640, 200);

        game.getBoard().draw(game);

        renderer.end();

        //scoreLabel.draw();
        usernameLabel.setText(String.format(usernameLabelFormat, User.getInstance().getUsername()));

        // Draw overlaying Actors of stage
        stage.draw();
        scoreLabel.draw();
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
        stage.getViewport().update(width, height);
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

    public Skin getSkin() {
        return skin;
    }
}
