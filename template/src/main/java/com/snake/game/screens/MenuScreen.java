package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.User;
import com.snake.game.requests.Login;
import com.snake.game.requests.Signup;
import com.snake.game.requests.UserInfo;

/**
 * The screen on which the user may login to their account using their username and password
 * and launch the game.
 */
public class MenuScreen extends Screen {

    private final transient SpriteBatch batch;
    private final transient BitmapFont font;

    private final transient Group textFieldsGroup;
    private final transient TextField usernameTextField;
    private final transient TextField passwordTextField;
    private final transient Label statusLabel;

    private final transient Group loginGroup;
    private final transient TextButton loginButton;
    private final transient TextButton registerButton;

    private final transient Group registerGroup;
    private final transient TextButton createButton;
    private final transient TextButton backButton;

    private final transient Group playGroup;
    private final transient TextButton playButton;

    private final transient Image logo;



    /**
     * Constructor for login screen.
     *
     * @param sc screen controller
     */
    @SuppressWarnings("PMD")
    //Understand why we can't call overridable method, but it can't be escaped here
    //Because of how libgdx structures classes.
    public MenuScreen(ScreenController sc) {
        super(sc);
        batch = new SpriteBatch();
        batch.begin();
        font = new BitmapFont();
        stage = new Stage();

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");

        Skin skin = new Skin(fileHandle);
        // Logo
        Texture logoIcon = new Texture(Gdx.files.internal("logo.png"));
        TextureRegion textureRegion = new TextureRegion(logoIcon, 256, 256);
        logo = new Image(textureRegion);

        // Text fields group
        usernameTextField = new TextField("", skin);
        usernameTextField.setMessageText("Username");
        usernameTextField.setMaxLength(32);
        usernameTextField.setBounds(0,135,170, 35);

        passwordTextField = new TextField("", skin);
        passwordTextField.setMessageText("Password");
        passwordTextField.setMaxLength(32);
        passwordTextField.setPasswordMode(true);
        passwordTextField.setPasswordCharacter('*');
        passwordTextField.setBounds(0,90,170, 35);
        
        statusLabel = new Label("Currently offline", skin);
        statusLabel.setWrap(true);
        statusLabel.setColor(Color.RED);
        statusLabel.setBounds(0,5,170,35);

        // Login group
        loginButton = new TextButton("Login", skin);
        loginButton.setBounds(0,0,80, 35);

        registerButton = new TextButton("Register", skin);
        registerButton.setBounds(90,0,80, 35);

        // Register group
        createButton = new TextButton("Create", skin);
        createButton.setBounds(0,0,80, 35);

        backButton = new TextButton("Back", skin);
        backButton.setBounds(90,0,80, 35);

        // Play group
        playButton = new TextButton("Play", skin);
        playButton.setBounds(0,45,170, 35);


        textFieldsGroup = new Group();
        textFieldsGroup.addActor(usernameTextField);
        textFieldsGroup.addActor(passwordTextField);
        textFieldsGroup.addActor(statusLabel);

        loginGroup = new Group();
        loginGroup.addActor(loginButton);
        loginGroup.addActor(registerButton);

        registerGroup = new Group();
        registerGroup.addActor(createButton);
        registerGroup.addActor(backButton);

        playGroup = new Group();
        playGroup.addActor(playButton);


        stage.addActor(logo);
        stage.addActor(textFieldsGroup);
        stage.addActor(loginGroup);
        stage.addActor(registerGroup);
        stage.addActor(playGroup);

        stage.setKeyboardFocus(usernameTextField);

        registerGroup.setVisible(false);
        updatePosition();
        addListeners();
    }

    void updatePosition() {
        logo.setPosition(50,100);
        textFieldsGroup.setPosition(400, 180);
        loginGroup.setPosition(400,220);
        registerGroup.setPosition(400,220);
        playGroup.setPosition(400,100);
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
                        statusLabel.setText(login.getErrors().get(0));
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
                registerGroup.setVisible(true);
                loginGroup.setVisible(false);
                playGroup.setVisible(false);
                statusLabel.setText("Register new account");
                statusLabel.setColor(Color.DARK_GRAY);
            }
        });

        createButton.addListener(new ClickListener() {
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
                        statusLabel.setText(signup.getErrors().get(0));
                        statusLabel.setColor(Color.RED);
                    } else {
                        registerGroup.setVisible(false);
                        loginGroup.setVisible(true);
                        playGroup.setVisible(true);

                        statusLabel.setText("Registered successfully");
                        statusLabel.setColor(Color.DARK_GRAY);
                    }
                }
            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                registerGroup.setVisible(false);
                loginGroup.setVisible(true);
                playGroup.setVisible(true);
                if (User.getInstance().isLoggedIn()) {
                    statusLabel.setText("Play as: " + "");
                    statusLabel.setColor(Color.DARK_GRAY);
                } else {
                    statusLabel.setText("");
                    statusLabel.setColor(Color.RED);
                }
            }
        });

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User.getInstance().logout();
                sc.openScreen(ScreenController.ScreenName.startScreen);

            }
        });
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        updatePosition();

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
    public void show() {

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
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
