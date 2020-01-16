package com.snake.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class FinishedGameState extends GameState {

    public FinishedGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.gameUpdateTimer.setActive(false);
        game.getScore().reset();
        game.getSnake().setColor(Color.RED);
    }

    @Override
    public void draw(ShapeRenderer renderer) {

    }

    @Override
    public void keyPress() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)
                || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.enterState(GameStateName.newGame);
        }
    }
}
