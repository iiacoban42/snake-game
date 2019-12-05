package com.snake.server.repositories;

import com.snake.server.domain.User;
import com.snake.server.domain.UserInfo;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    /**
     * Query to get top-5 scores.
     * @return set of UserInfo classes.
     */
    @Query(nativeQuery = true, value =
            "SELECT "
                    + "username as username, maxscore as score "
                    + "FROM "
                    + "users "
                    + "ORDER BY "
                    + "maxscore desc "
                    + "limit 5;"

    )
    Set<UserInfo> getTopScores();
}
