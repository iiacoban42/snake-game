package com.snake.game.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.powerup.PowerUp;
import com.snake.game.powerup.PowerUpFactory;
import com.snake.game.powerup.PowerUps;

import java.util.ArrayList;

/**
 * The board is the field on which the game takes place. The snake and consumables take place
 * on the board within the given boundaries.
 */
public class Board {

    private static boolean PORTAL_WALLS = false;
    private static final int DX = 50;
    private static final int DY = 100;
    private static final int WIDTH = 320;
    private static final int HEIGHT = 320;
    private static final int GRID_WIDTH = 20;
    private static final int GRID_HEIGHT = 20;

    private static final int TILE = 16;

    private int extraApples = 0;

    private final ShapeRenderer rend;
    public Timer<Runnable> gameUpdateTimer;


    private Snake snake;
    private Apple apple;
    private ArrayList<Apple> moreApples;
    private Score score;

    private PowerUp powerUp;
    private boolean isUp;
    private PowerUpFactory powerUpFactory;

    /**
     * Constructor.
     *
     * @param rend a ShapeRenderer to draw its graphics to
     */
    public Board(ShapeRenderer rend) {
        this.rend = rend;

        snake = new Snake(0, 0, 5);
        apple = Apple.spawnApplePersistent(this);
        moreApples = new ArrayList<>();

        gameUpdateTimer = new Timer<>(this::run);
        gameUpdateTimer.setActive(true);

        isUp = false;
        powerUpFactory = new PowerUpFactory(this, this.snake);
        score = new Score();
    }

    /**
     * Optional constructor but you can pass snake to it.
     *
     * @param rend  shape renderer.
     * @param snake snake.
     */
    public Board(ShapeRenderer rend, Snake snake) {
        this.rend = rend;
        this.snake = snake;

        apple = Apple.spawnApplePersistent(this);
        moreApples = new ArrayList<>();
        score = new Score();

        gameUpdateTimer = new Timer<>(this::run);
        gameUpdateTimer.setActive(true);

        isUp = false;
        powerUpFactory = new PowerUpFactory(this, this.snake);
    }

    public int getExtraApples() {
        return extraApples;
    }

    public void setExtraApples(int extraApples) {
        this.extraApples = extraApples;
    }

    public ArrayList<Apple> getMoreApples() {
        return moreApples;
    }

    public void setMoreApples(ArrayList<Apple> moreApples) {
        this.moreApples = moreApples;
    }

    public boolean isUpp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    /**
     * Returns the setting whether the snake can go through walls.
     *
     * @return boolean
     */
    public boolean isPortalWalls() {
        return PORTAL_WALLS;
    }

    public Timer<Runnable> getGameUpdateTimer() {
        return gameUpdateTimer;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getDx() {
        return DX;
    }

    public int getDy() {
        return DY;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getGridWidth() {
        return GRID_WIDTH;
    }

    public int getGridHeight() {
        return GRID_HEIGHT;
    }

    public int getTile() {
        return TILE;
    }

    public ShapeRenderer getRend() {
        return rend;
    }

    public void setPortalWalls(boolean portalWalls) {
        this.PORTAL_WALLS = portalWalls;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public boolean isIsUp() {
        return isUp;
    }

    public void setIsUp(boolean up) {
        isUp = up;
    }

    public PowerUpFactory getPowerUpFactory() {
        return powerUpFactory;
    }

    public void setPowerUpFactory(PowerUpFactory powerUpFactory) {
        this.powerUpFactory = powerUpFactory;
    }

    /**
     * Game update.
     */
    public void run() {

        updatePowerUp(
                (float) Math.random(),
                PowerUps.values()[(int) ((float) Math.random() * PowerUps.values().length)]
        );

        if (snake.move()) {
            snake.killSnake();
            gameUpdateTimer.setActive(false);
            return;
        }

        if (snake.collides(apple.getXcoord(), apple.getYcoord())) {
            snake.addLength(3);
            apple = Apple.spawnApplePersistent(this);
            score.increment(10);
        }

        if (!moreApples.isEmpty()) {
            for (int i = 0; i < moreApples.size(); i++) {
                if (snake.collides(moreApples.get(i).getXcoord(), moreApples.get(i).getYcoord())) {
                    snake.addLength(3);
                    score.increment(10);
                    moreApples.remove(moreApples.get(i));
                }
            }
        }

        if (isUp && snake.collides(powerUp.getXcoord(), powerUp.getYcoord())) {
            isUp = false;
            powerUp.handle();
        }
    }

    /**
     * Method to update current powerUp. Chooses what powerUp to use (if any).
     */
    public void updatePowerUp(float random, PowerUps powerUp) {

        if (random > 0 && random <= 0.01 && !isUp) {
            isUp = true;
            this.powerUp = powerUpFactory.getPowerUp(powerUp);
        }
    }

    /**
     * Method to update timer.
     */
    public void timerHandler() {
        gameUpdateTimer.timerHandler(System.currentTimeMillis());
    }

    /**
     * Main draw method.
     */
    @SuppressWarnings("PMD")
    //UR anomaly : body is undefined. Stackoverflow report: bug in pmd.
    //https://stackoverflow.com/questions/21592497/java-for-each-loop-being-flagged-as-ur-anomaly-by-pmd
    public void draw() {

        final float backgroundGrayScale = .85f;
        //final float snakeGrayScale = .85f;
        rend.setColor(backgroundGrayScale, backgroundGrayScale, backgroundGrayScale, 1);
        rend.rect(DX, DY, WIDTH, HEIGHT);
        rend.set(ShapeRenderer.ShapeType.Line);
        rend.setColor(.0f, .0f, .0f, 1);
        rend.rect(DX, DY, WIDTH, HEIGHT);

        rend.set(ShapeRenderer.ShapeType.Filled);
        rend.setColor(.0f, .0f, .0f, 1);
        snake.draw(this);
        apple.draw(this);
        if (isUp) {
            powerUp.draw();
        }

        if (extraApples > 0) {
            for (Apple extraApple : moreApples) {
                extraApple.draw(this);
            }
        }
    }

    /**
     * Adds more apples to the board.
     *
     * @param number of apples to add.
     */
    public void addApples(int number) {
        for (int i = 0; i < number; i++) {
            moreApples.add(Apple.spawnApplePersistent(this));
        }
        extraApples = number;
    }


    /**
     * Method to update snake direction.
     *
     * @param direction direction of a snake
     */
    public void updateDirection(Snake.Direction direction) {
        if (direction == Snake.Direction.UP) {
            snake.getDirection().enqueue(Snake.Direction.UP);
        }
        if (direction == Snake.Direction.DOWN) {
            snake.getDirection().enqueue(Snake.Direction.DOWN);
        }
        if (direction == Snake.Direction.LEFT) {
            snake.getDirection().enqueue(Snake.Direction.LEFT);
        }
        if (direction == Snake.Direction.RIGHT) {
            snake.getDirection().enqueue(Snake.Direction.RIGHT);
        }

        if (direction == Snake.Direction.SPACE) {
            score.reset();
            snake.init(0, 0, 5);
            apple = Apple.spawnApplePersistent(this);
            gameUpdateTimer.setActive(true);
        }
    }

    public void setGameUpdateTimer(Timer<Runnable> gameUpdateTimer) {
        this.gameUpdateTimer = gameUpdateTimer;
        gameUpdateTimer.setActive(true);
    }
}
