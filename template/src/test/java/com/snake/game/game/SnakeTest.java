package com.snake.game.game;

import com.snake.game.game.powerup.InitializedGameTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SnakeTest extends InitializedGameTest {

    /**
     * Test Snake will correctly collides with input coordinates.
     * Good Weather
     */
    @Test
    void testSnakeCollides() {
        game.spawnSprites();


        Assertions.assertTrue(game.getSnake().collides(0,0));
        Assertions.assertFalse(game.getSnake().collides(1,1));


    }

    /**
     * Test Snake will correctly collides with incorrect input coordinates.
     * Bad Weather
     */
    @Test
    void testSnakeCollidesFalseCoordinates() {
        game.spawnSprites();


        Assertions.assertFalse(game.getSnake().collides(-1,-1));
        Assertions.assertFalse(game.getSnake().collides(100,100));


    }

    /**
     * Test Snake will correctly collides with the vertical wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideEastVerticalWall() {
        game.spawnSprites();

        for (int i = 0; i < 15; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        Assertions.assertTrue(finalMove);


    }

    /**
     * Test Snake will correctly collides with the west vertical wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideWesttVerticalWall() {
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.UP);
        game.getSnake().getDirection().enqueue(Snake.Direction.LEFT);

        for (int i = 0; i < 5; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        Assertions.assertTrue(finalMove);


    }

    /**
     * Test Snake will correctly collides with the north horizontal wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideNorthHorizontalWall() {
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.UP);

        for (int i = 0; i < 19; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        Assertions.assertTrue(finalMove);

    }

    /**
     * Test Snake will correctly collides with the South horizontal wall.
     * Good Weather
     */
    @Test
    void testSnakeCollideSouthHorizontalWall() {
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.DOWN);

        for (int i = 0; i < 19; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        Assertions.assertTrue(finalMove);

    }

    /**
     * Test Snake will correctly collides with itself.
     * Good Weather
     */
    @Test
    void testSnakeCollidesWithItself() {
        game.spawnSprites();
        game.getSnake().getDirection().enqueue(Snake.Direction.UP);
        game.getSnake().getDirection().enqueue(Snake.Direction.LEFT);
        game.getSnake().getDirection().enqueue(Snake.Direction.DOWN);



        for (int i = 0; i < 3; i++) {

            game.getSnake().move(game.getBoard());
        }

        boolean finalMove = game.getSnake().move(game.getBoard());

        Assertions.assertTrue(finalMove);

    }

}
