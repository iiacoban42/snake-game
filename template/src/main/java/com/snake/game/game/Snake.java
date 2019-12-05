package com.snake.game.game;

import java.util.LinkedList;

public class Snake {

    private Body head;
    private LinkedList<Body> snake;
    private int length;
    private DirectionQueue direction;

    public Snake(int x, int y, int length) {
        snake = new LinkedList<>();
        init(x, y, 5);
    }

    public void init(int x, int y, int length) {
        snake = new LinkedList<>();
        snake.addLast(new Body(x, y));
        head = snake.getFirst();
        direction = new DirectionQueue(Direction.RIGHT);
        this.length = length;
        for (int i = 1; i < length; i++) {
            move();

        }
    }

    public void move() {
        direction.dequeue();
        Body newHead = new Body(head.getX(), head.getY(), direction.getDirection());
        if (collides(newHead.getX(), newHead.getY())) {
            killSnake();
        }

        snake.addLast(newHead);
        while (snake.size() > length)
            snake.removeFirst();
//        System.out.println(snake);
        head = snake.getLast();
    }

    public boolean collides(int x, int y) {
        for (Body body : snake)
            if (body.getX() == x && body.getY() == y)
                return true;
        return false;
    }

    public void killSnake() {
        snake = new LinkedList<>();

    }

    public void draw(Board board) {
        for (Body b : snake) {
            b.draw(board);
        }
    }

    public DirectionQueue getDirection(){
        return direction;
    }

    public void addLength(int increment) {
        length += increment;
    }

    class Body {
        private final int x, y;

        Body(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Body(int x, int y, Direction direction) {
            this.x = x + direction.getDx();
            this.y = y + direction.getDy();
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void draw(Board board) {
//            System.out.println(x+"  "+y);
            board.getRend().rect(
                    board.getX() + x * board.getTILE(),
                    board.getY() + y * board.getTILE(),
                    board.getTILE(),
                    board.getTILE());
        }
    }

    public enum Direction {
        UP(0, 1), DOWN(0, -1), LEFT(-1, 0), RIGHT(1, 0);
        private final int dx, dy;

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

        public boolean isOrthogonalTo(Direction direction){
            return (direction.getDx()*dx + direction.getDy()*dy) == 0;
        }
    }
}
