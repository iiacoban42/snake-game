package com.snake.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snake.game.game.Board;
import com.snake.game.game.ScreenController;

public class GameScreen extends Screen {

    public GameScreen(ScreenController sc) {
        super(sc);
        stage = new Stage();


        board = new Board(r);
        gameUpdateTimer = new Timer<>(() ->
            board.run()
        );
        gameUpdateTimer.setActive(true);
    }

    Timer<Runnable> gameUpdateTimer;

    ShapeRenderer r = new ShapeRenderer();

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        board.updateDirection();
        gameUpdateTimer.timerHandler();


        r.begin(ShapeRenderer.ShapeType.Filled);
        r.setColor(.7f, .7f, .7f, 1);
        //r.rect(0,0,640,50);
        r.rect(0, 380, 640, 200);

        board.draw();

        r.end();

        stage.draw();

    }


    @Override
    public void resize(int width, int height) {

    }


    class Timer<T extends Runnable> {
        private long delay = 0;
        private double duration = 100.0;
        private boolean active = false;
        private T run;

        public Timer(T t) {
            run = t;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public void timerHandler() {
            if (!active) return;
            final long currentTime = System.currentTimeMillis();
            if (delay > currentTime) return;

            final long updateAmount = (long) ((currentTime - delay) / duration);
            final long tooManyUpdates = 10;
            if (updateAmount > tooManyUpdates)
                delay += duration * updateAmount;
            while (delay < currentTime) {
                {
                    run.run();


                }
                delay += duration;
            }

        }
    }


    Board board;


}
