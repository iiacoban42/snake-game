package com.snake.game.game;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Body> snakeBody;
    private int length;
    private DirectionQueue direction;

    public LinkedList<Body> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(LinkedList<Body> snake) {
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

    public Snake(int x, int y, int length) {
        snakeBody = new LinkedList<>();
        init(x, y, length);
    }

    public Body getHead() {
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
        snakeBody.addLast(new Body(x, y));
        direction = new DirectionQueue(Direction.RIGHT);
        this.length = length;
        for (int i = 1; i < length; i++) {
            move();

        }
    }

    /**
     * Method to mocve a snake around.
     * @return true in case of collision
     */
    public boolean move() {
        direction.dequeue();
        Body newHead = new Body(getHead().getXc(), getHead().getYc(), direction.getDirection());
        if (collides(newHead.getXc(), newHead.getYc())) {
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
        for (Body body : snakeBody) {
            if (body.getXc() == x && body.getYc() == y) {
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
        for (Body b : snakeBody) {
            b.draw(board);
        }
    }

    public DirectionQueue getDirection() {
        return direction;
    }

    public void addLength(int increment) {
        length += increment;
    }

    public class Body {
        private final int xc;
        private final int yc;

        Body(int xc, int yc) {
            this.xc = xc;
            this.yc = yc;
        }

        Body(int xc, int yc, Direction direction) {
            this.xc = xc + direction.getDx();
            this.yc = yc + direction.getDy();
        }

        public int getXc() {
            return xc;
        }

        public int getYc() {
            return yc;
        }

        /**
         * Method to draw a board.
         * @param board current board
         */
        public void draw(Board board) {
            board.getRend().rect(
                    board.getDx() + xc * board.getTile(),
                    board.getDy() + yc * board.getTile(),
                    board.getTile(),
                    board.getTile());
        }
    }

    public enum Direction {
        UP(0, 1), DOWN(0, -1), LEFT(-1, 0), RIGHT(1, 0), SPACE(0,0);
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
