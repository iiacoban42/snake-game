package com.snake.game.game;

import com.badlogic.gdx.graphics.Color;

import java.util.LinkedList;

/**
 * The snake is the player-controlled entity which can move around the board. The snake grows
 * in length when it consumes an apple. This increases the score, and incrementally makes it
 * more difficult for the player, as the player must try to avoid the snake colliding with itself.
 */
public class Snake {

    private LinkedList<BodyPart> snakeBody;
    private int length;
    private DirectionQueue direction;

    public LinkedList<BodyPart> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(LinkedList<BodyPart> snake) {
        this.snakeBody = snake;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirection(DirectionQueue direction) {
        this.direction = direction;
    }

    /**
     * Constructor of snake.
     * @param x x
     * @param y y
     * @param length default length
     */
    public Snake(int x, int y, int length) {
        snakeBody = new LinkedList<>();
        init(x, y, length);
    }

    public BodyPart getHead() {
        return snakeBody.getLast();
    }

    /**
     * Initialize snake game.
     * @param x x position
     * @param y y position
     * @param length length of a snake
     */
    public void init(int x, int y, int length) {
        snakeBody = new LinkedList<>();
        snakeBody.addLast(new BodyPart(x, y));
        direction = new DirectionQueue(Direction.RIGHT);
        this.length = length;
        for (int i = 1; i < length; i++) {
            move();
        }
    }

    /**
     * Method to move a snake around.
     * @return true in case of collision
     */
    public boolean move() {
        direction.dequeue();
        BodyPart newHead = new BodyPart(
                getHead().getPosX(),
                getHead().getPosY(),
                direction.getDirection());
        if (collides(newHead.getPosX(), newHead.getPosY())) {
            return true;
        }

        snakeBody.addLast(newHead);
        while (snakeBody.size() > length) {
            snakeBody.removeFirst();
        }

        return false;
    }

    /**
     * Check if a snake collides.
     * @param x x coordinate of collision
     * @param y y coordinate of collision
     * @return true if collides
     */
    @SuppressWarnings("PMD")
    //UR anomaly : body is undefined. Stackoverflow report: bug in pmd.
    //https://stackoverflow.com/questions/21592497/java-for-each-loop-being-flagged-as-ur-anomaly-by-pmd
    public boolean collides(int x, int y) {
        for (BodyPart bodyPart : snakeBody) {
            if (bodyPart.getPosX() == x && bodyPart.getPosY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method handles snake death.
     */
    public void killSnake() {
        snakeBody = new LinkedList<>();
        length = 0;

    }

    /**
     * Method to draw a board (and snake).
     * @param board current board
     */
    @SuppressWarnings("PMD")
    //UR anomaly. Same issue described above in method collides()
    public void draw(Board board) {
        for (BodyPart b : snakeBody) {
            b.draw(board);
        }
    }

    public DirectionQueue getDirection() {
        return direction;
    }

    public void addLength(int increment) {
        length += increment;
    }

    public class BodyPart {
        private final int posX;
        private final int posY;

        BodyPart(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
        }

        BodyPart(int posX, int posY, Direction direction) {
            this.posX = posX + direction.getDx();
            this.posY = posY + direction.getDy();
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        /**
         * Method to draw a board.
         * @param board current board
         */
        public void draw(Board board) {
            board.getRend().setColor(Color.PURPLE);
            board.getRend().rect(
                    board.getBoardX() + posX * board.getTile(),
                    board.getBoardY() + posY * board.getTile(),
                    board.getTile(),
                    board.getTile());
        }
    }

    public enum Direction {
        UP(0, 1),
        DOWN(0, -1),
        LEFT(-1, 0),
        RIGHT(1, 0),
        SPACE(0,0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }

        public boolean isOrthogonalTo(Direction direction) {
            return (direction.getDx() * dx + direction.getDy() * dy) == 0;
        }
    }
}
