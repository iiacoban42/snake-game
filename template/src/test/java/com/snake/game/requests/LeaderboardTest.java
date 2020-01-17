package com.snake.game.requests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LeaderboardTest {

    @Test
    public void noServerTest() {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.execute();
        assertTrue(leaderboard.hasErrors());
        assertTrue(leaderboard.getErrors().size() > 0);
    }
}
