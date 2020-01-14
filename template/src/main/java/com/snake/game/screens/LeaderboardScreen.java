package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.requests.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LeaderboardScreen extends Screen {

    List<User> topFive;

    LeaderboardScreen(ScreenController sc) {
        super(sc);


        FreeTypeFontGenerator generator =
                new FreeTypeFontGenerator(Gdx.files.local("/src/main/resources/gamer.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;
        parameter.color = Color.CYAN;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;


        //TODO - REPLACE WITH API CALL
        stage = new Stage();
        User test = new User("test", 1);
        User test1 = new User("test2", 15);
        User one = new User("sadsd", 20);
        User two = new User("asdds", 50);
        User lol = new User("pussypower", 90);
        topFive = new ArrayList<>();
        topFive.add(test1);
        topFive.add(test);
        topFive.add(one);
        topFive.add(two);
        topFive.add(lol);
        //TODO - END TODO


        List<Label> labels = new ArrayList<>();
        for (User u : topFive) {
            Label toAdd = new Label(u.getUsername(), labelStyle);
            labels.add(toAdd);
            toAdd = new Label(u.getMaxScore() + "", labelStyle);
            labels.add(toAdd);
        }

        Table leaderboardTable = new Table();

        leaderboardTable.defaults().padLeft(300);

        ListIterator<Label> labelListIterator = labels.listIterator();

        while (labelListIterator.hasNext()) {
            leaderboardTable.add(labelListIterator.next());
            if (labelListIterator.hasNext()) {
                leaderboardTable.add(labelListIterator.next());
            }
            leaderboardTable.row();
        }

        leaderboardTable.setPosition(150, 300);



        FileHandle fileHandle = new FileHandle("src/main/resources/uiskin.json");
        Skin skin = new Skin(fileHandle);

        TextButton backButton = new TextButton("Back", skin);
        backButton.setSize(80, 35);
        backButton.setPosition(320 - 40, 100);

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sc.openScreen(ScreenController.ScreenName.loginScreen);
            }
        });

        stage.addActor(backButton);
        stage.addActor(leaderboardTable);
    }

    @Override
    public void create() {

    }

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }
}
