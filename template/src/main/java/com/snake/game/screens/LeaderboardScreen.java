package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.requests.Leaderboard;
import com.snake.game.requests.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LeaderboardScreen extends Screen {

    private Table leaderboardTable;
    private Label.LabelStyle leaderboardStyle;

    LeaderboardScreen(ScreenController sc) {
        super(sc);

        leaderboardStyle = new Label.LabelStyle();
        leaderboardStyle.font = Font.get(24);


        stage = new Stage();

        leaderboardTable = new Table();
        leaderboardTable.defaults().padLeft(300);
        leaderboardTable.setPosition(150, 280);

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

    @Override
    public void show() {
        Leaderboard lbRequest = new Leaderboard();
        lbRequest.execute();
        List<Label> labels = new ArrayList<>();

        if (!lbRequest.hasErrors()) {

            JSONArray topFive = lbRequest.getResult().getBody().getArray();

            for (int i = 0; i < topFive.length(); i++) {
                JSONObject user = topFive.getJSONObject(i);
                String username = user.getString("username");
                int score = user.getInt("maxScore");

                Label toAdd = new Label(username, leaderboardStyle);
                labels.add(toAdd);
                toAdd = new Label(score + "", leaderboardStyle);
                labels.add(toAdd);
            }
        }

        ListIterator<Label> labelListIterator = labels.listIterator();

        leaderboardTable.clearChildren();

        while (labelListIterator.hasNext()) {
            leaderboardTable.add(labelListIterator.next());
            if (labelListIterator.hasNext()) {
                leaderboardTable.add(labelListIterator.next());
            }
            leaderboardTable.row();
        }
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
}
