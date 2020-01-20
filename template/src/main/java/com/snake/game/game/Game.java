package com.snake.game.game;

import com.snake.game.game.powerup.PowerUp;
import com.snake.game.game.powerup.PowerUpFactory;
import com.snake.game.game.powerup.PowerUpName;
import com.snake.game.game.states.ActiveGameState;
import com.snake.game.game.states.FinishedGameState;
import com.snake.game.game.states.GameState;
import com.snake.game.game.states.GameStateName;
import com.snake.game.game.states.NewGameState;
import com.snake.game.game.states.PauseGameState;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represents the game that can be in 1 of 3 active states (active, paused, finished).
 * Houses the board, and each state class contains the logic of what to execute for the game
 */
public class Game {

    private boolean portalWalls = false;
    private boolean stopGrowFlag = false;
    private final transient int maxApples = 20;

    private Snake snake;
    private ArrayList<Apple> apples;
    private PowerUp powerUp;
    private PowerUpFactory powerUpFactory;

    private Board board;
    private SoundSystem soundSystem;
    private Score score;

    private GameState state;
    private final HashMap<GameStateName, GameState> states = new HashMap<>();

    public Timer<Runnable> gameUpdateTimer;

    public void setGameUpdateTimer(Timer<Runnable> gameUpdateTimer) {
        this.gameUpdateTimer = gameUpdateTimer;
    }

    /**
     * Constructor.
     */
    public Game(Board board, Score score, SoundSystem soundSystem) {
        this.board = board;
        this.score = score;
        this.soundSystem = soundSystem;

        states.put(GameStateName.newGame, new NewGameState(this));
        states.put(GameStateName.active, new ActiveGameState(this));
        states.put(GameStateName.paused, new PauseGameState(this));
        states.put(GameStateName.gameOver, new FinishedGameState(this));

        gameUpdateTimer = new Timer<>(this::run);
        gameUpdateTimer.setActive(false);

        powerUpFactory = new PowerUpFactory(this);
    }

    /**
     * Spawns in all sprites.
     */
    public void spawnSprites() {
        snake = new Snake(board,0, 0, 5);

        Apple apple = Apple.spawnApplePersistent(this);
        apples = new ArrayList<>();
        apples.add(apple);

    }

    /**
     * Handles update timer.
     */
    public void updateBoardTimer() {
        gameUpdateTimer.timerHandler(System.currentTimeMillis());
    }

    /**
     * Enters a state.
     *
     * @param gameStateName the name of the state
     */
    public void enterState(GameStateName gameStateName) {
        GameState state = states.get(gameStateName);
        assert state != null;
        this.state = state;
        state.enter();
    }

    /**
     * Game update.
     */
    @SuppressWarnings("PMD")
    //there must be at least one apple in the list we must not remove
    public void run() {
        if (snake.move(board)) {
            soundSystem.getDeathSound().play();
            enterState(GameStateName.gameOver);
            powerUp = null;
            apples.clear();
            return;
        }

        for (int i = 0; i < apples.size(); i++) {
            if (snake.collides(apples.get(i).getPosX(), apples.get(i).getPosY())) {
                soundSystem.getEatingSound().play();
                apples.get(i).consume(this, snake);
                apples.remove(apples.get(i));
            }
        }
        if (apples.size() == 0) {
            apples.add(Apple.spawnApplePersistent(this));
        }

        if (powerUp == null) {
            double chance = Math.random();
            int powerUpIndex = (int) (Math.random() * PowerUpName.values().length);
            updatePowerUp(chance, PowerUpName.values()[powerUpIndex]);
        }
        if (powerUp != null && snake.collides(powerUp.getPosX(), powerUp.getPosY())) {
            soundSystem.getPowerUpSound().play();
            powerUp.consume(this, snake);
            powerUp = null;
        }
    }

    /**
     * Method to update current powerUp. Chooses what powerUp to use (if any).
     */
    public void updatePowerUp(double chance, PowerUpName powerUpName) {
        final double threshold = 0.01;
        if (chance <= threshold) {
            powerUp = powerUpFactory.getPowerUp(powerUpName);
        }
    }

    /**
     * Adds more apples to the board.
     *
     * @param number of apples to add.
     */
    public void addApples(int number) {
        if (number < maxApples) {
            for (int i = 0; i < number; i++) {
                apples.add(Apple.spawnApplePersistent(this));
            }
        }
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
    }

    public boolean isPortalWalls() {
        return portalWalls;
    }

    public void setPortalWalls(boolean portalWalls) {
        this.portalWalls = portalWalls;
    }

    public boolean isStopGrowFlag() {
        return stopGrowFlag;
    }

    public void setStopGrowFlag(boolean stopGrowFlag) {
        this.stopGrowFlag = stopGrowFlag;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public ArrayList<Apple> getApples() {
        return apples;
    }

    public void setApples(ArrayList<Apple> apples) {
        this.apples = apples;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public PowerUpFactory getPowerUpFactory() {
        return powerUpFactory;
    }

    public void setPowerUpFactory(PowerUpFactory powerUpFactory) {
        this.powerUpFactory = powerUpFactory;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public SoundSystem getSoundSystem() {
        return soundSystem;
    }

    public void setSoundSystem(SoundSystem soundSystem) {
        this.soundSystem = soundSystem;
    }

    public Timer<Runnable> getGameUpdateTimer() {
        return gameUpdateTimer;
    }

    public HashMap<GameStateName, GameState> getStates() {
        return states;
    }
}
