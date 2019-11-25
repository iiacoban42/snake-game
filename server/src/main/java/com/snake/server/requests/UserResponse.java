package com.snake.server.requests;

/**
 * Class to represent response when requested user information.
 */
public class UserResponse {

    private String username;

    private int maxScore;

    /**
     * Constructor.
     * @param username username
     * @param maxScore max score
     */
    public UserResponse(String username, int maxScore) {
        this.username = username;
        this.maxScore = maxScore;
    }

    /**
     * Getter for username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter max score.
     * @return max score
     */
    public int getMaxScore() {
        return maxScore;
    }

    /**
     * Setter for username.
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for max score.
     * @param maxScore max score
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
