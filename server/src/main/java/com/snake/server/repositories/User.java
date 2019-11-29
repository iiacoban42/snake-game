package com.snake.server.repositories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;


/**
 * Class to represent a user in a database.
 */
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Long maxscore;

    /**
     * Empty constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     * @param username username
     * @param password password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for id.
     * @return Long id
     */
    public Long getId() {
        return this.id;
    }

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
     * Getter max score.
     * @return Long max score
     */
    public Long getMaxscore() {
        return this.maxscore;
    }

    /**
     * Setter id.
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
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


    /**
     * Setter to update max score.
     * @param newScore new max score
     */
    public void setMaxscore(Long newScore) {
        if (newScore >= maxscore) {
            this.maxscore = newScore;
        }
    }
}
