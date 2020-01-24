package com.snake.game.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;

/**
 * The game has ended. Either because the snake died or the user exited. *
 */
public class FinishedGameState extends GameState {

    public FinishedGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.gameUpdateTimer.setActive(false);
        game.getScore().save();
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
