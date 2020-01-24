package com.snake.game.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

/**
 * State of an active game. The user is currently playing.
 */
public class ActiveGameState extends GameState {

    public ActiveGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.getGameUpdateTimer().setActive(true);
        game.getSnake().setColor(Color.PURPLE);
    }

    @Override
    public void draw(ShapeRenderer renderer) {

    }

    @Override
    public void keyPress() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)
                || Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            game.updateDirection(Snake.Direction.UP);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)
                || Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            game.updateDirection(Snake.Direction.DOWN);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)
                || Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            game.updateDirection(Snake.Direction.LEFT);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)
                || Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            game.updateDirection(Snake.Direction.RIGHT);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)
                || Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.enterState(GameStateName.paused);
        }
    }
}
