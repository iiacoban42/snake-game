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
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.User;
import com.snake.game.requests.Login;
import com.snake.game.requests.UserInfo;

/**
 * The screen on which the user may login to their account using their username and password
 * and launch the game.
 */
public class LoginScreen extends Screen {

    private final transient SpriteBatch batch;
    private final transient BitmapFont font;

    private final transient TextField usernameTextField;
    private final transient TextField passwordTextField;
    private final transient TextButton loginButton;
    private final transient TextButton registerButton;
    private final transient TextButton playButton;
    private final transient Image logo;

    private final transient Group group;

    /**
     * Constructor for login screen.
     *
     * @param sc screen controller
     */
    @SuppressWarnings("PMD")
    //Understand why we can't call overridable method, but it can't be escaped here
    //Because of how libgdx structures classes.
    public LoginScreen(ScreenController sc) {
        super(sc);
        batch = new SpriteBatch();
        font = new BitmapFont();
        stage = new Stage();

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

        loginButton = new TextButton("Login", skin);
        loginButton.setSize(80, 35);

        registerButton = new TextButton("Register", skin);
        registerButton.setSize(80, 35);

        playButton = new TextButton("Play", skin);
        playButton.setSize(80, 35);


        group = new Group();
        group.addActor(logo);
        group.addActor(usernameTextField);
        group.addActor(passwordTextField);
        group.addActor(loginButton);
        group.addActor(registerButton);
        group.addActor(playButton);
        stage.addActor(group);

        stage.setKeyboardFocus(usernameTextField);

        super.position(usernameTextField, passwordTextField, registerButton, loginButton, logo);
        updatePosition();
        addListeners();
    }

    void updatePosition() {

        int pivotX = 400;
        int pivotY = 280;
        playButton.setPosition(pivotX + 45, pivotY - 150);
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
                        font.draw(batch, login.getResult().getBody(), 200, 200);
                        sc.openScreen(ScreenController.ScreenName.gameScreen);
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

                        sc.openScreen(ScreenController.ScreenName.startScreen);
                    }
                }
            }
        });
        registerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.registerScreen);

            }
        });

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.startScreen);

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
