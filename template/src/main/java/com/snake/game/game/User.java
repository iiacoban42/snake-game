package com.snake.game.game;

/**
 * Singleton of logged in user.
 */
public class User {

    private static User instance;

    private String username = "";
    private int maxScore;

    /**
     * Private constructor.
     */
    private User() {

    }

    /**
     * Get the only User instance available.
     * @return the logged in user
     */
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }

        return instance;
    }

    /**
     * Set username of logged in user.
     * @param username the username
     * @return this
     */
    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Set the maxScore of the logged in user.
     * @param maxScore the new maxScore
     * @return this
     */
    public User setMaxScore(int maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    /**
     * Get the current user's username.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Get the current user's maxScore.
     * @return the maxScore
     */
    public int getMaxScore() {
        return this.maxScore;
    }

    /**
     * Check if a user is currently logged in.
     * @return whether a user is logged in
     */
    public boolean isLoggedIn() {
        return !this.username.equals("");
    }

    /**
     * Logout the current user, if any.
     */
    public void logout() {
        this.username = "";
        this.maxScore = 0;
    }

}
