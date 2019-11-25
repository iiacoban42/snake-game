package com.snake.server.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Jpa repository to connect to the database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds user by username.
     * @param username username
     * @return optional of user (if not found, being empty)
     */
    Optional<User> findByUsername(String username);
}
