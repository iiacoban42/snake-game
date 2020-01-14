package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.powerup.SpeedUp;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class BoardTest {

    @Test
    void testBoardConstructor() {

        Board board = new Board(null);

        assertEquals(board.getGridHeight(), 20);
        assertEquals(board.getGridWidth(), 20);
        assertEquals(board.getDx(), 50);
        assertEquals(board.getDy(), 100);
        assertEquals(board.getHeight(), 320);
        assertEquals(board.getWidth(), 320);
        assertEquals(board.getTile(), 16);
        assertEquals(board.isPortalWalls(), false);

    }

    @Test
    void testUpdateDirectionUp() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.UP);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(), Snake.Direction.UP);

    }

    @Test
    void testUpdateDirectionDown() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.DOWN);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(), Snake.Direction.DOWN);

    }

    @Test
    void testUpdateDirectionRight() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.RIGHT);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(),
                Snake.Direction.RIGHT);

    }

    @Test
    void testUpdateDirectionLeft() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.LEFT);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(),
                Snake.Direction.RIGHT);

    }

    @Test
    void testUpdateDirectionSpace() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.SPACE);

        assertEquals(board.getSnake().getLength(), 5);

    }

    @Test
    void testRunSnakeDed() {
        //Can't figure out how to make snake collide with itself here

    }


    @Test
    void updatePowerUpWrongRandomTest() {
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Board board = new Board(shapeRenderer);
        board.updatePowerUp((float) 0.15, 1);
        assertEquals(board.isIsUp(), false);
    }

    @Test
    void updatePowerUpWrongRandomTwoTest() {
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Board board = new Board(shapeRenderer);
        board.updatePowerUp((float) -1, 1);
        assertEquals(board.isIsUp(), false);
    }

    @Test
    void updatePowerUpCorrectTest() {
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Board board = new Board(shapeRenderer);
        board.updatePowerUp((float) 0.01, 1);
        assertEquals(board.isIsUp(), true);
    }

    @Test
    void updatePowerUpAlreadyThereTest() {
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Board board = new Board(shapeRenderer);
        board.setIsUp(true);
        board.updatePowerUp((float) 0.01, 1);
        assertEquals(board.isIsUp(), true);
    }

    @Test
    void addApples() {
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Board board = new Board(shapeRenderer);
        board.setIsUp(true);
        board.addApples(3);
        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
        assertEquals(apples.size(), 4);
    }

    @Test
    void addApplesNoExtra() {
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Board board = new Board(shapeRenderer);
        board.setIsUp(true);
        board.addApples(0);
        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
        assertEquals(apples.size(), 1);
    }


    @Test
    void runPowerUpTest() {
        SpeedUp speedUp = Mockito.mock(SpeedUp.class);
        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
        Snake snake = Mockito.mock(Snake.class);
        Board board = new Board(shapeRenderer, snake);
        board.setPowerUp(speedUp);
        board.setIsUp(true);
        Mockito.when(speedUp.getXcoord()).thenReturn(5);
        Mockito.when(speedUp.getYcoord()).thenReturn(5);
        Mockito.when(snake.collides(5, 5)).thenReturn(true);
        board.run();
        assertEquals(board.isIsUp(), false);
    }

    @Test
    void snakeEatsExtraApple() {

        Board board = new Board(null);

        board.addApples(1);
        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
        apples.get(0).setXcoord(4);
        apples.get(0).setYcoord(2);
        apples.get(1).setXcoord(5);
        apples.get(1).setYcoord(0);
        board.run();

        assertEquals(board.getSnake().getLength(), 8);

    }

    @Test
    void snakeDoesntEatExtraApple() {

        Board board = new Board(null);

        board.addApples(1);
        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
        apples.get(0).setXcoord(5);
        apples.get(0).setYcoord(1);
        apples.get(1).setXcoord(3);
        apples.get(1).setYcoord(1);
        board.run();

        assertEquals(board.getSnake().getLength(), 5);

    }
}
