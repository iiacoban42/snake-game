package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.ScreenController;

public class LoginScreen extends Screen {

    private TextField usernameTextField;
    private TextField passwordTextField;
    private TextButton loginButton;
    private TextButton registerButton;

    private Group group;

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(TextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(TextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public TextButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(TextButton loginButton) {
        this.loginButton = loginButton;
    }

    public TextButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(TextButton registerButton) {
        this.registerButton = registerButton;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LoginScreen(ScreenController sc) {
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

        loginButton = new TextButton("Login", skin);
        loginButton.setSize(80, 35);

        registerButton = new TextButton("Register", skin);
        registerButton.setSize(80, 35);


        group = new Group();
        group.addActor(usernameTextField);
        group.addActor(passwordTextField);
        group.addActor(loginButton);
        group.addActor(registerButton);
        stage.addActor(group);

        stage.setKeyboardFocus(usernameTextField);


        updatePosition();
        addListeners();
    }

    void updatePosition() {

        int pivotX = 400, pivotY = 280;
        usernameTextField.setPosition(pivotX, pivotY);
        passwordTextField.setPosition(pivotX, pivotY - 45);

        loginButton.setPosition(pivotX, pivotY - 90);
        registerButton.setPosition(pivotX + 90, pivotY - 90);
    }

    void addListeners() {
        loginButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();

                System.out.println("Logging in: [Username: " + username + ", Password: " + password + "]");
                //TODO
            }
        });
        registerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //TODO
                sc.openScreen(sc.gameScreen);
            }
        });

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

    }
}
