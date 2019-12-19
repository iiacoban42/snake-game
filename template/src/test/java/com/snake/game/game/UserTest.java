package com.snake.game.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testSingleton() {
        User u1 = User.getInstance();
        User u2 = User.getInstance();

        assertSame(u1, u2);
    }

    @Test
    void testSetUsername() {
        User u = User.getInstance();
        u.setUsername("username1");

        assertEquals("username1", u.getUsername());
    }

    @Test
    void testSetMaxScore() {
        User u = User.getInstance();
        u.setMaxScore(12);

        assertEquals(12, u.getMaxScore());
    }

    @Test
    void testIsLoggedIn() {
        assertFalse(User.getInstance().isLoggedIn());
        User.getInstance()
                .setUsername("username2")
                .setMaxScore(51);
        assertTrue(User.getInstance().isLoggedIn());
    }

    @Test
    void testLogout() {
        User.getInstance()
                .setUsername("username3")
                .setMaxScore(31);

        User.getInstance().logout();

        assertFalse(User.getInstance().isLoggedIn());
    }
}
