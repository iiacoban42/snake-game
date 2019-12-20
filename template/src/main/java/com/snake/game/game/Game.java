package com.snake.game.game;

import com.snake.game.states.ActiveGame;
import com.snake.game.states.State;

/**
 * Class that represents the game that can be in 1 of 3 active states (active, paused, finished).
 * Houses the board, and each state class contains the logic of what to execute for the game
 */
public class Game {

    private transient State state;
    private Board board;
    private ScreenController sc;

    public Game(ScreenController sc) {
        state = new ActiveGame(this);
        this.sc = sc;
    }

    public void updateBoardTimer() {
        board.timerHandler();
    }

    public void observe() {
        this.state.observe();
    }

    public void changeState(State state) {
        this.state = state;
        this.state.enterState();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public State getState(){
        return this.state;
    }

    public ScreenController getSc() {
        return sc;
    }

    public void setSc(ScreenController sc) {
        this.sc = sc;
    }
}
