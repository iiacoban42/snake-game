package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.requests.Signup;

/**
 * The screen on which the user may register a new account.
 */
public class RegisterScreen extends Screen {

    private final transient SpriteBatch batch;
    private final transient BitmapFont font;

    private final transient TextField usernameTextField;
    private final transient TextField passwordTextField;
    private final transient TextButton registerButton;
    private final transient TextButton backButton;
    private final transient Image logo;

    private final transient Group group;

    /**
     * Constructor for register screen.
     *
     * @param sc screen controller
     */
    @SuppressWarnings("PMD")
    //Understand why we can't call overridable method, but it can't be escaped here
    //Because of how libgdx structures classes.
    public RegisterScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();
        batch = new SpriteBatch();
        font = new BitmapFont();

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        Skin skin = new Skin(fileHandle);

        Texture logoIcon = new Texture(Gdx.files.internal("logo.png"));
        TextureRegion textureRegion = new TextureRegion(logoIcon, 256, 256);
        logo = new Image(textureRegion);

        usernameTextField = new TextField("", skin);
        usernameTextField.setMessageText("Username");
        usernameTextField.setMaxLength(32);
        usernameTextField.setSize(170, 35);

        passwordTextField = new TextField("", skin);
        passwordTextField.setMessageText("Password");
        passwordTextField.setMaxLength(32);
        passwordTextField.setPasswordMode(true);
        passwordTextField.setPasswordCharacter('*');
        passwordTextField.setSize(170, 35);

        registerButton = new TextButton("Register", skin);
        registerButton.setSize(80, 35);

        backButton = new TextButton("Back", skin);
        backButton.setSize(80, 35);

        group = new Group();
        group.addActor(logo);
        group.addActor(usernameTextField);
        group.addActor(passwordTextField);
        group.addActor(registerButton);
        group.addActor(backButton);
        stage.addActor(group);

        stage.setKeyboardFocus(usernameTextField);


        position(usernameTextField, passwordTextField, registerButton, backButton, logo);
        addListeners();
    }
    void position(TextField user, TextField password, TextButton left,
                  TextButton right, Image logo) {

        int pivotX = 400;
        int pivotY = 280;
        user.setPosition(pivotX, pivotY);
        password.setPosition(pivotX, pivotY - 45);
        logo.setPosition(pivotX - 325, pivotY - 180);
        right.setPosition(pivotX, pivotY - 90);
        left.setPosition(pivotX + 90, pivotY - 90);
    }

    void addListeners() {
        registerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();
                System.out.println(username);
                System.out.println(password);
                if (validUser(username) && validPassword(password)) {
                    Signup signup = new Signup(username, password);
                    signup.execute();
                    if (signup.hasErrors()) {
                        font.draw(batch, signup.getErrors().get(0), 200, 200);
                    } else {
                        font.draw(batch, signup.getResult().getBody(), 200, 200);
                        sc.openScreen(ScreenController.ScreenName.gameScreen);
                    }
                }
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.loginScreen);
            }
        });
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

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.85f, .85f, .85f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(.42f, .82f, .32f, 1);
        shapeRenderer.rect(0, 0,
                stage.getViewport().getScreenWidth(),
                stage.getViewport().getScreenHeight() / standardHeight * 50.0f);
        shapeRenderer.rect(0, stage.getViewport().getScreenHeight() / standardHeight * 380,
                stage.getViewport().getScreenWidth(),
                stage.getViewport().getScreenHeight() / standardHeight * 100.0f);
        shapeRenderer.end();

        stage.draw();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        group.setScale(standardWidth / width, standardHeight / height);
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
}


