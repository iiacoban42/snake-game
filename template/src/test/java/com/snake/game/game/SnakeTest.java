package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class SnakeTest {

    /**
     * Test Snake will correctly collides with input coordinates.
     * Good Weather
     */
    @Test
    void testSnakeCollides() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();


        assertEquals(game.getSnake().collides(0,0), true);
        assertEquals(game.getSnake().collides(1,1), false);


    }

    /**
     * Test Snake will correctly collides with incorrect input coordinates.
     * Bad Weather
     */
    @Test
    void testSnakeCollidesFalseCoordinates() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();


        assertEquals(game.getSnake().collides(-1,-1), false);
        assertEquals(game.getSnake().collides(100,100), false);


    }

    /**
     * Test Snake will correctly collides with the vertical wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideEastVerticalWall() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();

        for (int i = 0; i < 15; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        assertEquals(finalMove, true);


    }

    /**
     * Test Snake will correctly collides with the west vertical wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideWesttVerticalWall() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.UP);
        game.getSnake().getDirection().enqueue(Snake.Direction.LEFT);

        for (int i = 0; i < 5; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        assertEquals(finalMove, true);


    }

    /**
     * Test Snake will correctly collides with the north horizontal wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideNorthHorizontalWall() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.UP);

        for (int i = 0; i < 19; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        assertEquals(finalMove, true);

    }

    /**
     * Test Snake will correctly collides with the South horizontal wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideSouthHorizontalWall() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.DOWN);

        for (int i = 0; i < 19; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        assertEquals(finalMove, true);

    }

    /**
     * Test Snake will correctly collides with itself.
     * Good Weather
     */
    @Test
    void testSnakeCollidesWithItself() {

        Game game = new Game(Mockito.mock(ShapeRenderer.class));
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.UP);
        game.getSnake().getDirection().enqueue(Snake.Direction.LEFT);
        game.getSnake().getDirection().enqueue(Snake.Direction.DOWN);



        for (int i = 0; i < 3; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        assertEquals(finalMove, true);

    }












}
