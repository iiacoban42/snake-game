package com.snake.game.requests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserInfoTest {

    @Test
    void testUsernameNull() {
        UserInfo u = new UserInfo(null);
        u.execute();

        assertTrue(u.hasErrors());
        assertTrue(u.getErrors().size() > 0);
    }

    @Test
    void testUsernameEmpty() {
        UserInfo u = new UserInfo("");
        u.execute();

        assertTrue(u.hasErrors());
        assertTrue(u.getErrors().size() > 0);
    }

    @Test
    void testNoRunningServer() {
        UserInfo u = new UserInfo("username1");
        u.execute();

        assertTrue(u.hasErrors());
        assertTrue(u.getErrors().size() > 0);
    }

}
