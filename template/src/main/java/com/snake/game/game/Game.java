package com.snake.game.game;

import com.snake.game.game.powerup.PowerUp;
import com.snake.game.game.powerup.PowerUpFactory;
import com.snake.game.game.powerup.PowerUpName;
import com.snake.game.screens.ScreenController;
import com.snake.game.states.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represents the game that can be in 1 of 3 active states (active, paused, finished).
 * Houses the board, and each state class contains the logic of what to execute for the game
 */
public class Game {

    private ScreenController sc;

    private boolean PORTAL_WALLS = false;
    private boolean stopGrowFlag;

    private Snake snake;
    private ArrayList<Apple> apples;
    private PowerUp powerUp;
    private PowerUpFactory powerUpFactory;

    private Board board;
    private GameState state;

    private Score score;

    public Timer<Runnable> gameUpdateTimer;

    public void setGameUpdateTimer(Timer<Runnable> gameUpdateTimer) {
        this.gameUpdateTimer = gameUpdateTimer;
    }

    public enum StateName {
        empty, active, paused, finished
    }

    public Game(ScreenController sc) {
        this.sc = sc;

        states.put(StateName.empty, new EmptyGameState(sc, this));
        states.put(StateName.active, new ActiveGameState(sc, this));
        states.put(StateName.paused, new PauseGameState(sc, this));
        states.put(StateName.finished, new FinishedGameState(sc, this));

        board = new Board(this);
        gameUpdateTimer = new Timer<>(this::run);
        gameUpdateTimer.setActive(false);

        score = new Score();

        enterState(StateName.empty);
    }

    public void spawnSprites(){
        snake = new Snake(0, 0, 5);

        Apple apple = Apple.spawnApplePersistent(this);
        apples = new ArrayList<>();
        apples.add(apple);

        powerUpFactory = new PowerUpFactory(this);
    }

    public void updateBoardTimer(){
        gameUpdateTimer.timerHandler(System.currentTimeMillis());
    }


    private final HashMap<StateName, GameState> states = new HashMap<>();

    /**
     * Enters a state.
     *
     * @param stateName the name of the state
     */
    public void enterState(StateName stateName) {
        GameState state = states.get(stateName);
        assert state != null;
        this.state = state;
        state.enter();
    }

    /**
     * Game update.
     */
    @SuppressWarnings("PMD")
    //there must be at least one apple in the list we must not remove (line 229)
    public void run() {
        if (snake.move()) {
            snake.killSnake();
            enterState(Game.StateName.finished);
            return;
        }

        for (int i = 0; i < apples.size(); i++) {
            if (snake.collides(apples.get(i).getxPos(), apples.get(i).getyPos())) {
                apples.get(i).consume(this, snake);
                apples.remove(apples.get(i));
            }
        }
        if(apples.size() == 0){
            apples.add(Apple.spawnApplePersistent(this));
        }

        if(powerUp == null){
            double chance = Math.random();
            int powerUpIndex = (int) (Math.random() * PowerUpName.values().length);
            updatePowerUp(chance, PowerUpName.values()[powerUpIndex]);
        }
        if (powerUp != null && snake.collides(powerUp.getxPos(), powerUp.getyPos())) {
            powerUp.consume(this, snake);
            powerUp = null;
        }
    }

    /**
     * Method to update current powerUp. Chooses what powerUp to use (if any).
     */
    public void updatePowerUp(double chance, PowerUpName powerUpName) {
        if (chance <= 0.01) {
            this.powerUp = powerUpFactory.getPowerUp(powerUpName);
        }
    }

    /**
     * Adds more apples to the board.
     *
     * @param number of apples to add.
     */
    public void addApples(int number) {
        for (int i = 0; i < number; i++) {
            apples.add(Apple.spawnApplePersistent(this));
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
        return PORTAL_WALLS;
    }

    public void setPortalWalls(boolean PORTAL_WALLS) {
        this.PORTAL_WALLS = PORTAL_WALLS;
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

    public ScreenController getSc() {
        return sc;
    }

    public void setSc(ScreenController sc) {
        this.sc = sc;
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

    public Timer<Runnable> getGameUpdateTimer() {
        return gameUpdateTimer;
    }

    public HashMap<StateName, GameState> getStates() {
        return states;
    }
}
