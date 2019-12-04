package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.SnakeGame;

public class MainMenuScreen implements Screen {


    SnakeGame game;
    Texture registerButton;
    Texture loginTexture;
    private Stage stage;

    private TextField textFieldUsername;


    public MainMenuScreen(SnakeGame game){
        this.game = game;
        //loginTexture = new Texture("login.png");

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        Skin skin = new Skin(fileHandle);
        TextButton loginButton = new TextButton("Login", skin);
        loginButton.setPosition(100, 100);
        loginButton.setSize(300, 40);

        loginButton.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                loginClicked();
            }
        });


        textFieldUsername = new TextField("", skin);
        textFieldUsername.setPosition(300, 250);
        textFieldUsername.setSize(300, 40);



        stage.addActor(textFieldUsername);
        stage.addActor(loginButton);
        //to switch screens do game.setScreen(new RegistrationScreen()) whatever
    }

    public void loginClicked(){
        String username = textFieldUsername.getText();
        System.out.println(username);
        //TODO make request to server (make it call separate class)
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 0 ,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act(delta);
        stage.draw();

//        game.batch.begin();
//        game.batch.draw(loginButton, 100, 100, 100, 100);
//
//        game.batch.end();


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
