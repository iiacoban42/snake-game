package com.snake.game.game.powerup;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Apple;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Score;
import com.snake.game.game.Snake;
import com.snake.game.game.SoundSystem;
import com.snake.game.game.SoundWrapper;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;


public class InitializedGameTest {

    protected transient Game game;

    protected transient Board board;
    protected transient Snake snake;
    protected transient Score score;
    protected transient SoundSystem mockedSoundSystem;
    protected transient ShapeRenderer mockedRenderer;
    protected transient Apple apple;
    protected transient ArrayList<Apple> apples;

    /**
     * Creates a new game for each test.
     */
    @BeforeEach
    public void createGame() {
        mockedSoundSystem = Mockito.mock(SoundSystem.class);
        Mockito
                .when(mockedSoundSystem.getDeathSound())
                .thenReturn(Mockito.mock(SoundWrapper.class));
        Mockito
                .when(mockedSoundSystem.getEatingSound())
                .thenReturn(Mockito.mock(SoundWrapper.class));
        Mockito
                .when(mockedSoundSystem.getPowerUpSound())
                .thenReturn(Mockito.mock(SoundWrapper.class));
        mockedRenderer = Mockito.mock(ShapeRenderer.class);

        score = new Score();
        apple = new Apple(1, 1);
        apples = new ArrayList<>();
        board = new Board(mockedRenderer);
        snake = new Snake(board, 0,0,5);
        game = new Game(board, score, mockedSoundSystem);

        apples.add(apple);
        game.setApples(apples);
        game.setSnake(snake);
        game.setScore(score);

        afterCreate();
    }

    public void afterCreate() {

    }
}
