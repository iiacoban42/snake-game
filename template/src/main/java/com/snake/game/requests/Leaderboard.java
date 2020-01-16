package com.snake.game.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Leaderboard extends ApiRequest<JsonNode> {

    public Leaderboard() {

    }

    @Override
    public void execute() {
        try {
            HttpResponse<JsonNode> response = this.get("/user/topscores")
                    .asJson();

            if (response.getStatus() != HTTP_OKAY) {
                this.addError("User not found");
                return;
            }

            this.setResult(response);
        } catch (UnirestException e) {
            this.addError("Couldn't connect to the server");
        }
    }
}
