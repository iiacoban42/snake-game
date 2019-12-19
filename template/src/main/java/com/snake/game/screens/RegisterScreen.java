package com.snake.game.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.ScreenController;
import com.snake.game.requests.Signup;

public class RegisterScreen extends Screen implements ApplicationListener {
    private transient TextField usernameTextField;
    private transient TextField passwordTextField;
    private transient TextButton registerButton;
    private transient SpriteBatch batch;
    private transient BitmapFont font;


    private transient Group group;

    public static boolean validUser(String text) {
        return text != null && !text.isEmpty();
    }

    public static boolean validPassword(String text) {
        return text != null && !text.isEmpty()
                && (text.length() >= 8) && (text.length() < 32);
    }

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
                        sc.openScreen(sc.gameScreen);
                    }
                }
            }
        });
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        // font.setColor(Color.RED);
    }

    @Override
    public void render() {

    }

}


