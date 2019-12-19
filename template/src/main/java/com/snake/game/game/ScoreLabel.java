package com.snake.game.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Class to draw the current score and highscore to a given stage.
 */
public class ScoreLabel {

    private final transient Color fontColor = Color.DARK_GRAY;
    private final transient String format = "Score: %d\nHighscore: %d";
    private final transient int coordX = 400;
    private final transient int coordY = 300;

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
        this.style.fontColor = this.fontColor;

        this.label = new Label("", this.style);
        this.label.setPosition(this.coordX, this.coordY);

        this.stage.addActor(this.label);
    }

    /**
     * Draw this label to the stage.
     */
    public void draw() {
        this.label.setText(
            String.format(this.format, this.score.get(), User.getInstance().getMaxScore())
        );
    }

}
