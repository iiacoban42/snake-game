package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * The screen contains the start menu.
 */
public class StartScreen extends Screen {

    private final transient SpriteBatch batch;
    private final transient BitmapFont font;

    private final transient TextButton playButton;
    private final transient TextButton quitButton;
    private final transient TextButton settingsButton;

    private final transient Image logo;

    private final transient Group group;

    /**
     * Constructor for start screen.
     *
     * @param sc screen controller
     */
    @SuppressWarnings("PMD")
    //Understand why we can't call overridable method, but it can't be escaped here
    //Because of how libgdx structures classes.
    public StartScreen(ScreenController sc) {
        super(sc);
        batch = new SpriteBatch();
        font = new BitmapFont();
        stage = new Stage();

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        Skin skin = new Skin(fileHandle);

        Texture logoIcon = new Texture(Gdx.files.internal("logo.png"));
        TextureRegion textureRegion = new TextureRegion(logoIcon, 256, 256);
        logo = new Image(textureRegion);


        playButton = new TextButton("Start", skin);
        playButton.setSize(80, 35);
        settingsButton = new TextButton("Settings", skin);
        settingsButton.setSize(80, 35);
        quitButton = new TextButton("Quit", skin);
        quitButton.setSize(80, 35);

        group = new Group();
        group.addActor(logo);
        group.addActor(playButton);
        group.addActor(settingsButton);
        group.addActor(quitButton);
        stage.addActor(group);

        updatePosition();
        addListeners();
    }

    void updatePosition() {

        int pivotX = 400;
        int pivotY = 280;

        logo.setPosition(pivotX - 325, pivotY - 180);
        playButton.setPosition(pivotX + 50, pivotY - 10);
        settingsButton.setPosition(pivotX + 50, pivotY - 60);
        quitButton.setPosition(pivotX + 50, pivotY - 110);
    }

    void addListeners() {
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.gameScreen);

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
        // font.setColor(Color.RED);
    }

    @Override
    public void render() {

    }

}
