package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.Board;
import com.snake.game.game.Game;

/**
 * The limbo screen when the player has lost the game.
 */
public class GameOverScreen extends Screen {

//    private final Board board;
    private final ShapeRenderer renderer;
    private final transient Label endgameLabel;
//    private transient Game game;
    private final transient TextButton quitButton;
    private final transient TextButton restartButton;
    private final transient TextButton exitButton;

//    public Board getBoard() {
//        return board;
//    }

    public ShapeRenderer getRenderer() {
        return renderer;
    }

    /**
     * Constructor for Game over screen.
     *
     * @param sc screen controller
     */
    @SuppressWarnings("PMD")
    //Understand why we can't call overridable method, but it can't be escaped here
    //Because of how libgdx structures classes.
    public GameOverScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
//        game = new Game(sc, renderer);
//        board = new Board(renderer);
//        game.setBoard(board);
//
        Label.LabelStyle endgameLabelStyle = new Label.LabelStyle();
        endgameLabelStyle.font = new BitmapFont();
        endgameLabelStyle.fontColor = Color.RED;

        endgameLabel = new Label("Game Over \n Score: ", endgameLabelStyle);
        endgameLabel.setPosition(300, 330);
        endgameLabel.setFontScale(1.3f);

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        Skin skin = new Skin(fileHandle);
        restartButton = new TextButton("Restart", skin);
        restartButton.setSize(80, 35);
        quitButton = new TextButton("Quit", skin);
        quitButton.setSize(80, 35);
        exitButton = new TextButton("Exit", skin);
        exitButton.setSize(80, 35);

        stage.addActor(endgameLabel);
        stage.addActor(restartButton);
        stage.addActor(quitButton);
        stage.addActor(exitButton);
        updatePosition();
        addListeners();
    }

    void updatePosition() {

        int pivotX = 250;
        int pivotY = 280;

        restartButton.setPosition(pivotX + 50, pivotY - 60);
        quitButton.setPosition(pivotX + 50, pivotY - 110);
        exitButton.setPosition(pivotX + 50, pivotY - 160);
    }

    void addListeners() {

        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.startScreen);

            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.loginScreen);

            }
        });

        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.gameScreen);
            }
        });

    }


    @Override
    public void show() {

    }

    @Override
    public void render() {

    }

    @Override
    public void render(float delta) {

        // Clear the screen
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Start new Renderer
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background design props
        renderer.setColor(.42f, .82f, .32f, 1);
        renderer.rect(0, 380, 640, 200);


        // Finalize renderer
        renderer.end();


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
