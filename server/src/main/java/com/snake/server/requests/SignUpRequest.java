package com.snake.server.requests;

import javax.validation.constraints.NotBlank;

/**
 * Class to represent sign up request made by client.
 */
public class SignUpRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    /**
     * Constructor.
     * @param username username
     * @param password password
     */
    public SignUpRequest(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Empty constructor.
     */
    public SignUpRequest() {}

    /**
     * Getter username.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter password.
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter username.
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter password.
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
