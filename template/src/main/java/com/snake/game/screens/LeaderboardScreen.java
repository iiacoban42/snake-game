package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.snake.game.requests.Leaderboard;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Class representing leaderboard screen.
 */
public class LeaderboardScreen extends Screen {

    private transient Table leaderboardTable;
    private transient Label.LabelStyle leaderboardStyle;

    /**
     * Constructor.
     * @param sc screen controller
     */
    LeaderboardScreen(ScreenController sc) {
        super(sc);

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
    public void pause() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }

    @Override
    public void resume() {

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
}
