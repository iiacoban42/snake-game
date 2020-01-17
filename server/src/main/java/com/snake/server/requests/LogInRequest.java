package com.snake.server.requests;

import javax.security.auth.login.LoginContext;
import javax.validation.constraints.NotBlank;

/**
 * Class to represent login request.
 */
public class LogInRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    /**
     * Constructor.
     * @param username username
     * @param password password
     */
    public LogInRequest(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Empty constructor.
     */
    public LogInRequest() {}

    /**
     * Getter for username.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter for password.
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for username.
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for password.
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
