package com.snake.game.states;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;
import com.snake.game.screens.ScreenController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ActiveGameTest {

    @Test
    void testRemainActive() {

        Game game = new Game(Mockito.mock(ScreenController.class));
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Sound sound = Mockito.mock(Sound.class);
        Mockito.when(sound.play(1.0f)).thenReturn(0L);
        Snake snake = new Snake(0, 0, 5, sound);
        Sound powerUpSound = Mockito.mock(Sound.class);
        Mockito.when(powerUpSound.play(1.0f)).thenReturn(0L);
        Sound eatingSound = Mockito.mock(Sound.class);
        Mockito.when(eatingSound.play(1.0f)).thenReturn(0L);
        Board board = new Board(shapeRenderer, snake, eatingSound, powerUpSound);
        game.setBoard(board);
        game.getBoard().getSnake().setLength(1);
        ActiveGame activeGame = new ActiveGame(game);

        activeGame.observe();

        assertEquals(activeGame.getClass().equals(ActiveGame.class), true);


    }

    @Test
    void testBecomeInactive() {

        Game game = new Game(Mockito.mock(ScreenController.class));
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);

        Sound sound = Mockito.mock(Sound.class);
        Mockito.when(sound.play(1.0f)).thenReturn(0L);
        Snake snake = new Snake(0, 0, 5, sound);
        Sound powerUpSound = Mockito.mock(Sound.class);
        Mockito.when(powerUpSound.play(1.0f)).thenReturn(0L);
        Sound eatingSound = Mockito.mock(Sound.class);
        Mockito.when(eatingSound.play(1.0f)).thenReturn(0L);
        Board board = new Board(shapeRenderer, snake, eatingSound, powerUpSound);
        game.setBoard(board);
        game.getBoard().getSnake().setLength(0);
        ActiveGame activeGame = new ActiveGame(game);

        activeGame.observe();

        assertEquals(game.getState().getClass().equals(ActiveGame.class), false);
        assertEquals(game.getState().getClass().equals(FinishedGame.class), true);



    }

}
