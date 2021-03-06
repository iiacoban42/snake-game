package com.snake.game.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class UserInfo extends ApiRequest<JsonNode> {

    private transient String username;

    public UserInfo(String username) {
        this.username = username;
    }

    @Override
    public void execute() {
        if (this.username == null || this.username.length() == 0) {
            this.addError("Please provide a username");
            return;
        }

        try {

            HttpResponse<JsonNode> response = this.post("/user/userinfo")
                    .header("Content-Type", "text/plain")
                    .body(this.username)
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
