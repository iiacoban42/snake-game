package com.snake.game.game;

import com.snake.game.requests.MaxScore;

/**
 * Class used for score calculation.
 */
public class Score {

    private transient int points;

    /**
     * Constructor for this Score class.
     */
    public Score() {
        this.points = 0;
    }

    /**
     * Get the score.
     * @return the score
     */
    public int get() {
        return this.points;
    }

    /**
     * Increment the score by some amount.
     * @param by the amount to increment by
     * @return this
     */
    public Score increment(int by) {
        this.points += by;
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
        this.save();
        this.points = 0;
        return this;
    }

    /**
     * Save the users score if it's higher than its max score.
     */
    public void save() {
        if (this.points > User.getInstance().getMaxScore()) {
            MaxScore req = new MaxScore(User.getInstance().getUsername(), this.points);
            req.execute();
            User.getInstance().setMaxScore(this.points);
        }
    }

}
