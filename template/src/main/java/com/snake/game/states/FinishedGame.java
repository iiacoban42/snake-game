package com.snake.game.states;

import com.snake.game.game.Game;

public class FinishedGame implements State {

    private Game game;

    public FinishedGame(Game game){
        this.game = game;
    }

    @Override
    public void observe() {
        System.out.println("LUL ur ded");
    }

    @Override
    public void enterState() {

    }
}