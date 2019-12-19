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
import com.snake.game.game.User;
import com.snake.game.requests.Login;
import com.snake.game.requests.UserInfo;

public class LoginScreen extends Screen implements ApplicationListener {

    private TextField usernameTextField;
    private TextField passwordTextField;
    private TextButton loginButton;
    private TextButton registerButton;
    private SpriteBatch batch;
    private BitmapFont font;


    private Group group;

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
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

    /**
     * Constructor for login screen.
     * @param sc screen controller
     */
    @SuppressWarnings("PMD")
    //Understand why we can't call overridable method, but it can't be escaped here
    //Because of how libgdx structures classes.
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

        int pivotX = 400;
        int pivotY = 280;
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
                System.out.println(username);
                System.out.println(password);
                if (validUser(username) && validPassword(password)) {
                    Login login = new Login(username, password);
                    login.execute();
                    if (login.hasErrors()) {

                        font.draw(batch, login.getErrors().get(0), 200, 200);
                    } else {
                        // fetch more user info
                        UserInfo userInfo = new UserInfo(username);
                        userInfo.execute();
                        int maxScore = (int) userInfo
                                .getResult()
                                .getBody()
                                .getObject()
                                .get("maxScore");

                        // save current user
                        User.getInstance()
                                .setUsername(username)
                                .setMaxScore(maxScore);

                        sc.openScreen(sc.gameScreen);
                    }
                }
            }
        });
        registerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(sc.gameScreen);

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
