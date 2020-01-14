package com.snake.game.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Class to draw the current score and highscore to a given stage.
 */
public class ScoreLabel {

    private static final Color FONT_COLOR = Color.DARK_GRAY;
    private static final String FORMAT = "Score: %d\nHighscore: %d";
    private static final int COORD_X = 400;
    private static final int COORD_Y = 300;

    private transient Stage stage;
    private transient Label label;
    private transient Label.LabelStyle style;
    private transient Score score;

    /**
     * Constructor to setup this label.
     * @param score The Score object to get the current score from
     * @param stage The stage to draw to
     */
    public ScoreLabel(Score score, Stage stage) {
        this.score = score;
        this.stage = stage;

        this.style = new Label.LabelStyle();
        this.style.font = new BitmapFont();
        this.style.fontColor = this.FONT_COLOR;

        this.label = new Label("", this.style);
        this.label.setPosition(this.COORD_X, this.COORD_Y);

        this.stage.addActor(this.label);
    }

    /**
     * Draw this label to the stage.
     */
    public void draw() {
        this.label.setText(
            String.format(this.FORMAT, this.score.get(), User.getInstance().getMaxScore())
        );
    }

}
