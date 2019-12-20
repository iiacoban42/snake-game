package com.snake.game.states;

import com.snake.game.game.Game;

public class ActiveGame implements State {

    private Game game;

    public ActiveGame(Game game){
        this.game = game;
    }

    @Override
    public void observe() {
        game.getBoard().draw();
        if(game.getBoard().getSnake().getLength() == 0){
            game.changeState(new FinishedGame(game));
        }
    }

    @Override
    public void enterState() {

    }
}