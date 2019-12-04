package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.game.ScreenController;

public class LoginScreen implements Screen {


    //Texture registerButton;
    //Texture loginTexture;

    private Stage stage;

    private TextField textFieldUsername;
    private TextButton loginButton;


    public LoginScreen(){
        //this.game = game;
        //loginTexture = new Texture("login.png");

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        Skin skin = new Skin(fileHandle);



        VerticalGroup verticalLayoutPane = new VerticalGroup();

        verticalLayoutPane.setFillParent(true);

        verticalLayoutPane.setColor(0.8f,0.8f,0.8f,1f);

        verticalLayoutPane.setHeight(300);
        verticalLayoutPane.setWidth(300);



        loginButton = new TextButton("Login", skin);
        loginButton.setSize(300, 40);

        loginButton.addListener(new ClickListener(){
            @Override
            public void clicked (InputEvent event, float x, float y) {
                loginClicked();
            }
        });


        textFieldUsername = new TextField("", skin);
        textFieldUsername.setSize(300, 40);

        verticalLayoutPane.addActor(loginButton);
        verticalLayoutPane.addActor(textFieldUsername);

        stage.addActor(verticalLayoutPane);

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
