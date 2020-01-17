package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.powerup.PowerUpName;
import com.snake.game.game.powerup.SpeedUp;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class BoardTest {

    @Test
    void testBoardConstructor() {

    }

    //
    ////    @Test
    ////    void testUpdateDirectionUp() {
    ////
    ////        Board board = new Board(null);
    ////
    ////        board.updateDirection(Snake.Direction.UP);
    ////
    ////        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(),
    ////  Snake.Direction.UP);
    ////
    ////    }
    ////
    ////    @Test
    ////    void testUpdateDirectionDown() {
    ////
    ////        Board board = new Board(null);
    ////
    ////        board.updateDirection(Snake.Direction.DOWN);
    ////
    ////        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(),
    //// Snake.Direction.DOWN);
    ////
    ////    }
    ////
    ////    @Test
    ////    void testUpdateDirectionRight() {
    ////
    ////        Board board = new Board(null);
    ////
    ////        board.updateDirection(Snake.Direction.RIGHT);
    ////
    ////        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(),
    ////                Snake.Direction.RIGHT);
    ////
    ////    }
    ////
    ////    @Test
    ////    void testUpdateDirectionLeft() {
    ////
    ////        Board board = new Board(null);
    ////
    ////        board.updateDirection(Snake.Direction.LEFT);
    ////
    ////        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(),
    ////                Snake.Direction.RIGHT);
    ////
    ////    }
    ////
    ////    @Test
    ////    void testUpdateDirectionSpace() {
    ////
    ////        Board board = new Board(null);
    ////
    ////        board.updateDirection(Snake.Direction.SPACE);
    ////
    ////        assertEquals(5, board.getSnake().getLength());
    ////
    ////    }
    ////
    ////    @Test
    ////    void testRunSnakeDead() {
    ////        //Can't figure out how to make snake collide with itself here
    ////
    ////    }
    //
    //
    //    @Test
    //    void updatePowerUpWrongRandomTest() {
    //        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
    //        Board board = new Board(shapeRenderer);
    //        board.updatePowerUp((float) 0.15, PowerUpName.SPEED_UP);
    //        assertEquals(false, board.isIsUp());
    //    }
    //
    //    @Test
    //    void updatePowerUpWrongRandomTwoTest() {
    //        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
    //        Board board = new Board(shapeRenderer);
    //        board.updatePowerUp((float) -1, PowerUpName.SPEED_UP);
    //        assertEquals(false, board.isIsUp());
    //    }
    //
    //    @Test
    //    void updatePowerUpCorrectTest() {
    //        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
    //        Board board = new Board(shapeRenderer);
    //        board.updatePowerUp((float) 0.01, PowerUpName.SPEED_UP);
    //        assertEquals(true, board.isIsUp());
    //    }
    //
    //    @Test
    //    void updatePowerUpAlreadyThereTest() {
    //        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
    //        Board board = new Board(shapeRenderer);
    //        board.setIsUp(true);
    //        board.updatePowerUp((float) 0.01, PowerUpName.SPEED_UP);
    //        assertEquals(true, board.isIsUp());
    //    }
    //
    //    @Test
    //    void addApples() {
    //        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
    //        Board board = new Board(shapeRenderer);
    //        board.setIsUp(true);
    //        board.addApples(3);
    //        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
    //        assertEquals(4, apples.size());
    //    }
    //
    //    @Test
    //    void addApplesNoExtra() {
    //        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
    //        Board board = new Board(shapeRenderer);
    //        board.setIsUp(true);
    //        board.addApples(0);
    //        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
    //        assertEquals(1, apples.size());
    //    }
    //
    //
    //    @Test
    //    void runPowerUpTest() {
    //        SpeedUp speedUp = Mockito.mock(SpeedUp.class);
    //        ShapeRenderer shapeRenderer = Mockito.mock(ShapeRenderer.class);
    //        Snake snake = Mockito.mock(Snake.class);
    //        Board board = new Board(shapeRenderer, snake);
    //        board.setPowerUp(speedUp);
    //        board.setIsUp(true);
    //        Mockito.when(speedUp.getXcoord()).thenReturn(5);
    //        Mockito.when(speedUp.getYcoord()).thenReturn(5);
    //        Mockito.when(snake.collides(5, 5)).thenReturn(true);
    //        board.run();
    //        assertEquals(false,board.isIsUp());
    //    }
    //
    //    @Test
    //    void snakeEatsExtraApple() {
    //
    //        Board board = new Board(null);
    //
    //        board.addApples(1);
    //        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
    //        apples.get(0).setXcoord(4);
    //        apples.get(0).setYcoord(2);
    //        apples.get(1).setXcoord(5);
    //        apples.get(1).setYcoord(0);
    //        board.run();
    //
    //        assertEquals(8, board.getSnake().getLength());
    //    }
    //
    //    @Test
    //    void snakeDoesntEatExtraApple() {
    //
    //        Board board = new Board(null);
    //
    //        board.addApples(1);
    //        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
    //        apples.get(0).setXcoord(5);
    //        apples.get(0).setYcoord(1);
    //        apples.get(1).setXcoord(3);
    //        apples.get(1).setYcoord(1);
    //        board.run();
    //
    //        assertEquals(5, board.getSnake().getLength());
    //    }
    //
    //    @Test
    //    void snakeDoesntGrow() {
    //
    //        Board board = new Board(null);
    //
    //        board.addApples(1);
    //        ArrayList<Apple> apples = new ArrayList<>(board.getApples());
    //        board.setStopGrowFlag(true);
    //        apples.get(0).setXcoord(5);
    //        apples.get(0).setYcoord(0);
    //        apples.get(1).setXcoord(3);
    //        apples.get(1).setYcoord(0);
    //        board.run();
    //
    //        assertEquals(5, board.getSnake().getLength());
    //        assertEquals(true, board.isStopGrowFlag());
    //        board.setStopGrowFlag(false);
    //        assertEquals(false, board.isStopGrowFlag());
    //    }
}
