package com.snake.game.game;

import com.badlogic.gdx.graphics.Color;

/**
 * An apple, also known as 'cookies' in other snake versions, is an object on the board that
 * the player should attempt to eat by moving the snake head towards it. Eating one increases
 * the score and the snake length
 */
public class Apple implements Consumable {

    private final int posX;
    private final int posY;

    /**
     * Construct apple.
     *
     * @param posX x-coordinate of position
     * @param posY y-coordinate of position
     */
    public Apple(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }


    @Override
    public void consume(Game game, Snake snake) {
        if (!game.isStopGrowFlag()) {
            snake.addLength(3);
        }
        game.getScore().increment(10);
    }


    /**
     * Render apple on board of given Game.
     * @param game game.
     */
    @Override
    public void draw(Game game) {
        game.getBoard().getRend().setColor(Color.LIME);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (posX + .5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (posY + .5f) * game.getBoard().getTile(),
                game.getBoard().getTile() / 2.0f);

    }

    /**
     * Creates an apple which is guaranteed to be in a proper spawn location.
     * @param game the game on which the apple must spawn
     * @return a new randomized apple which applies to the isProperSpawnLocation rules
     */
    public static Apple spawnApplePersistent(Game game) {
        int randX;
        int randY;
        do {
            randX = (int) (game.getBoard().getGridWidth() * Math.random());
            randY = (int) (game.getBoard().getGridHeight() * Math.random());
        } while (!isProperSpawnLocation(game, randX, randY));
        return new Apple(randX, randY);
    }

    /**
     * Checks whether a location is suitable for an apple to spawn.
     * @param game the game that contains all possible obstacles
     * @param posX the x-coordinate to test
     * @param posY the y-coordinate to test
     * @return returns true if the given location is suitable
     */
    @SuppressWarnings("PMD")
    //UR anomaly : body is undefined. Stackoverflow report: bug in pmd.
    //https://stackoverflow.com/questions/21592497/java-for-each-loop-being-flagged-as-ur-anomaly-by-pmd
    private static boolean isProperSpawnLocation(Game game, int posX, int posY) {

        boolean answer = checkSnakeCollision(game, posX, posY);

        if (game.getApples() != null) {
            answer = checkApplesCollision(game, posX, posY);
            return answer;
        }

        answer = true;
        return answer;
    }

    @SuppressWarnings("PMD")
    //UR anomaly : body is undefined. Stackoverflow report: bug in pmd.
    //https://stackoverflow.com/questions/21592497/java-for-each-loop-being-flagged-as-ur-anomaly-by-pmd
    public static boolean checkApplesCollision(Game game, int posX, int posY){

        for (Apple apple : game.getApples()) {
            if (apple.posX == posX && apple.posY == posY) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("PMD")
    //UR anomaly : body is undefined. Stackoverflow report: bug in pmd.
    //https://stackoverflow.com/questions/21592497/java-for-each-loop-being-flagged-as-ur-anomaly-by-pmd
    public static boolean checkSnakeCollision(Game game, int posX, int posY){

        if (game.getSnake().collides(posX, posY)) {
            return false;
        }
        return true;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
