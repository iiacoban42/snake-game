package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
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

    private final transient Group group;

    /**
     * Constructor for register screen.
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

        group = new Group();
        group.addActor(usernameTextField);
        group.addActor(passwordTextField);
        group.addActor(registerButton);
        stage.addActor(group);

        stage.setKeyboardFocus(usernameTextField);


        updatePosition();
        addListeners();
    }

    void updatePosition() {

        int pivotX = 400;
        int pivotY = 280;
        usernameTextField.setPosition(pivotX, pivotY);
        passwordTextField.setPosition(pivotX, pivotY - 45);
        registerButton.setPosition(pivotX, pivotY - 90);
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
    }

    @Override
    public void show() {

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
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(.7f, .7f, .7f, 1);
        shapeRenderer.rect(0, 0, 640, 50);
        shapeRenderer.rect(0, 380, 640, 200);
        shapeRenderer.end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        group.setScale(standardWidth / width, standardHeight / height);
    }
}


