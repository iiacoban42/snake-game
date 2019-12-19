package com.snake.game.game;

import com.snake.game.requests.MaxScore;

/**
 * Class used for score calculation
 */
public class Score {

    private int score;

    /**
     * Constructor for this Score class.
     */
    public Score() {
        this.score = 0;
    }

    /**
     * Get the score.
     * @return the score
     */
    public int get() {
        return this.score;
    }

    /**
     * Increment the score by some amount.
     * @param by the amount to increment by
     * @return this
     */
    public Score increment(int by) {
        this.score += by;
        return this;
    }

    /**
     * Increment the score by one.
     * @return this
     */
    public Score increment() {
        return this.increment(1);
    }

    /**
     * Reset the score to zero.
     * Save the highscore.
     * @return this
     */
    public Score reset() {
        if (this.score > User.getInstance().getMaxScore()) {
            MaxScore req = new MaxScore(User.getInstance().getUsername(), this.score);
            req.execute();
            User.getInstance().setMaxScore(this.score);
        }
        this.score = 0;
        return this;
    }

}
