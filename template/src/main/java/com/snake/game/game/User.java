package com.snake.game.game;

public class User {

    private static User instance;

    private String username;
    private int maxScore;

    private User() {

    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }

        return instance;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setMaxScore(int maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    public boolean isLoggedIn() {
        return this.username != null;
    }

    public void logout() {
        this.username = null;
        this.maxScore = 0;
    }

}
