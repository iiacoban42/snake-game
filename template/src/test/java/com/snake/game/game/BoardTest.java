package com.snake.game.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(board.getTILE(), 16);
        assertEquals(board.isPortalWalls(), false);

    }

    @Test
    void testUpdateDirectionUp() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.UP);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(), Snake.Direction.UP);

    }

    @Test
    void testUpdateDirectionDOWN() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.DOWN);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(), Snake.Direction.DOWN);

    }

    @Test
    void testUpdateDirectionRIGHT() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.RIGHT);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(), Snake.Direction.RIGHT);

    }

    @Test
    void testUpdateDirectionLEFT() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.LEFT);

        assertEquals(board.getSnake().getDirection().getKeyQueue().getLast(), Snake.Direction.RIGHT);

    }

    @Test
    void testUpdateDirectionSPACE() {

        Board board = new Board(null);

        board.updateDirection(Snake.Direction.SPACE);

        assertEquals(board.getSnake().getLength(), 5);

    }

    @Test
    void testRunSnakeDed() {
        //Can't figure out how to make snake collide with itself here

    }

    @Test
    void testRunSnakeApple() {

        Board board = new Board(null);

        board.getApple().setX(5);
        board.getApple().setY(0);

        board.run();

        assertEquals(board.getSnake().getLength(), 8);

    }


}
