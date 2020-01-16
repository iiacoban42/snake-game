package com.snake.game.screens;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.Game;
import com.snake.game.states.GameStateName;

public class PauseMenu extends Screen {

    private static final String LABEL_PATTERN = "Score: %d";

    private final transient SpriteBatch batch;
    private final transient BitmapFont font;
    private final transient Label scoreLabel;
    private final transient TextButton resumeButton;
    private final transient TextButton quitButton;
    private final transient TextButton restartButton;
    private final transient TextButton exitButton;

    private final transient Group group;

    private final Game game;

    /**
     * Constructor for pause menu.
     *
     * @param sc screen controller
     */
    @SuppressWarnings("PMD")
    //Understand why we can't call overridable method, but it can't be escaped here
    //Because of how libgdx structures classes.
    public PauseMenu(ScreenController sc, Game game) {
        super(sc);
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
        stage = new Stage();

        Label.LabelStyle scoreLabelStyle = new Label.LabelStyle();
        scoreLabelStyle.font = new BitmapFont();
        scoreLabelStyle.fontColor = Color.BLUE;

        scoreLabel = new Label("", scoreLabelStyle);
        scoreLabel.setPosition(300, 330);
        scoreLabel.setFontScale(1.3f);
        scoreLabel.setText("");

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        Skin skin = new Skin(fileHandle);
        resumeButton = new TextButton("Resume", skin);
        resumeButton.setSize(80, 35);
        restartButton = new TextButton("Restart", skin);
        restartButton.setSize(80, 35);
        quitButton = new TextButton("Quit", skin);
        quitButton.setSize(80, 35);
        exitButton = new TextButton("Exit", skin);
        exitButton.setSize(80, 35);

        group = new Group();
        group.addActor(scoreLabel);
        group.addActor(resumeButton);
        group.addActor(restartButton);
        group.addActor(quitButton);
        group.addActor(exitButton);
        stage.addActor(group);

        updatePosition();
        addListeners();
    }
    void updatePosition() {

        int pivotX = 250;
        int pivotY = 280;

        resumeButton.setPosition(pivotX + 50, pivotY - 10);
        restartButton.setPosition(pivotX + 50, pivotY - 60);
        quitButton.setPosition(pivotX + 50, pivotY - 110);
        exitButton.setPosition(pivotX + 50, pivotY - 160);

    }

    void addListeners() {


        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.gameScreen);
                game.enterState(GameStateName.active);
            }
        });

        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.gameScreen);
                game.enterState(GameStateName.empty);
            }
        });

        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.startScreen);
                game.enterState(GameStateName.empty);
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.loginScreen);
                game.enterState(GameStateName.empty);
            }
        });


    }

    @Override
    public void resize(int width, int height) {
        group.setScale(standardWidth / width, standardHeight / height);
        updatePosition();
    }


    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void create() {

    }

    @Override
    public void render() {

    }

    @Override
    public void show() {
        this.scoreLabel.setText(String.format(LABEL_PATTERN, this.game.getScore().get()));
    }

    public Game getGame() {
        return game;
    }
}
