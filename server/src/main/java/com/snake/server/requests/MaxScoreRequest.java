package com.snake.server.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Class to represent login request.
 */
public class MaxScoreRequest {

    @NotBlank
    private String username;

    @NotNull
    private int maxScore;

    /**
     * Constructor.
     * @param username username
     * @param maxScore the new maxscore
     */
    public MaxScoreRequest(@NotBlank String username, @NotNull int maxScore) {
        this.username = username;
        this.maxScore = maxScore;
    }

    /**
     * Empty constructor.
     */
    public MaxScoreRequest() {

    }

    /**
     * Getter for username.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter for maxScore.
     * @return maxScore
     */
    public int getMaxScore() {
        return this.maxScore;
    }

    /**
     * Setter for username.
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for maxScore.
     * @param maxScore maxScore
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

}
