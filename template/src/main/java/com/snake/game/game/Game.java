package com.snake.game.game;

import com.snake.game.states.ActiveGame;
import com.snake.game.states.State;


public class Game {

    private State state;
    private Board board;

    public Game(){
        state = new ActiveGame(this);
    }

    public void updateBoardTimer(){
        board.timerHandler();
    }

    public void observe(){
        this.state.observe();
    }

    public void changeState(State state){
        this.state = state;
    }

    public Board getBoard(){
        return board;
    }

    public void setBoard(Board board){
        this.board = board;
    }



}
