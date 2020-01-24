package com.snake.game.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;

/**
 * State when user paused the game.
 */
public class PauseGameState extends GameState {

    public PauseGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.getGameUpdateTimer().setActive(false);
        game.getSnake().setColor(Color.GRAY);
    }

    @Override
    public void draw(ShapeRenderer renderer) {

    }

    @Override
    public void keyPress() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)
                || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.enterState(GameStateName.active);
        }
    }


}
