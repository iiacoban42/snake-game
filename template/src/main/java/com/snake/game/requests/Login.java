package com.snake.game.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Login extends ApiRequest<String> {

    private transient String username;
    private transient String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * A method to check if username satisfies requirements.
     */
    public void usernameCheck() {
        if (this.username == null || this.username.length() == 0) {
            this.addError("Please provide a username");
            return;
        }
    }

    /**
     * A method to check if the password satisfies requirements.
     */
    public void check() {

        usernameCheck();

        if (this.password == null) {
            this.addError("Please provide a password");
            return;
        }
    }

    @Override
    public void execute() {

        check();

        if (this.hasErrors()) {
            return;
        }

        try {

            JSONObject body = new JSONObject();
            body.put("username", this.username);
            body.put("password", this.password);

            HttpResponse<String> response = this.post("/user/login")
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
