package com.snake.game.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.screens.ScreenController;
import com.snake.game.states.*;

import java.util.HashMap;

/**
 * Class that represents the game that can be in 1 of 3 active states (active, paused, finished).
 * Houses the board, and each state class contains the logic of what to execute for the game
 */
public class Game {


    private ScreenController sc;

    private Board board;
    private GameState state;

    private Score score;

    public Timer<Runnable> gameUpdateTimer;

    public void setGameUpdateTimer(Timer<Runnable> gameUpdateTimer) {
        this.gameUpdateTimer = gameUpdateTimer;
    }

    public enum StateName {
        empty, active, paused, finished
    }

    public Game(ScreenController sc, ShapeRenderer rend) {
        this.sc = sc;



        states.put(StateName.empty, new EmptyGameState(sc, this));
        states.put(StateName.active, new ActiveGameState(sc, this));
        states.put(StateName.paused, new PauseGameState(sc, this));
        states.put(StateName.finished, new FinishedGameState(sc, this));

        enterState(StateName.empty);


        board = new Board(this, rend);
        gameUpdateTimer = new Timer<>(board::run);
        gameUpdateTimer.setActive(false);

        score = new Score();
    }

    public void updateBoardTimer(){
        gameUpdateTimer.timerHandler(System.currentTimeMillis());
    }


    private final HashMap<StateName, GameState> states = new HashMap<>();

    /**
     * Enters a state.
     *
     * @param stateName the name of the state
     */
    public void enterState(StateName stateName) {
        GameState state = states.get(stateName);
        assert state != null;
        this.state = state;
        state.enter();
    }




    public Timer<Runnable> getGameUpdateTimer() {
        return gameUpdateTimer;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ScreenController getSc() {
        return sc;
    }

    public void setSc(ScreenController sc) {
        this.sc = sc;
    }

    public GameState getState(){
        return state;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
