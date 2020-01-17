package com.snake.game.requests;

public class User {

    private String username;
    private int maxScore;

    public User(String username, int maxScore) {
        this.username = username;
        this.maxScore = maxScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
