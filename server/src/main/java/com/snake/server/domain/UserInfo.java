package com.snake.server.domain;

/**
 * Class to get custom query from UserRepository.
 */
public interface UserInfo {

    /**
     * Method to get username.
     * @return username
     */
    String getUsername();

    /**
     * Method to get score.
     * @return score
     */
    int getScore();
}
