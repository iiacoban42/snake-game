package com.snake.game.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class MaxScore extends ApiRequest<String> {

    private transient String username;
    private transient int theMaxScore;

    public MaxScore(String username, int maxScore) {
        this.username = username;
        this.theMaxScore = maxScore;
    }

    @Override
    public void execute() {
        if (this.username == null || this.username.length() == 0) {
            this.addError("Please provide a username");
            return;
        }

        try {

            JSONObject body = new JSONObject();
            body.put("username", this.username);
            body.put("maxScore", this.theMaxScore);

            HttpResponse<String> response = this.post("/user/maxscore")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asString();

            if (response.getStatus() != HTTP_OKAY) {
                this.addError(response.getBody());
                return;
            }

            this.setResult(response);
        } catch (UnirestException e) {
            this.addError("Couldn't connect to the server");
        }
    }
}
