package com.snake.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font {
    /**
     * Generate BitmapFont.
     *
     * @param size of the font.
     * @param color for the font.
     * @return font
     */
    public static BitmapFont get(int size, Color color) {

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
                Gdx.files.local("/src/main/resources/OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter =
                new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = color;
        BitmapFont font = generator.generateFont(parameter);

        generator.dispose();

        return font;
    }

    public static BitmapFont get(int size) {
        return get(size, Color.DARK_GRAY);
    }

    public static BitmapFont get() {
        return get(14);
    }

}
