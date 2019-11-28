package nl.tudelft.group11.snake.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Signup extends ApiRequest<String> {

    private String username;
    private String password;

    public Signup(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() {
        if (this.username == null || this.username.length() == 0) {
            this.addError("Please provide a username");
            return;
        }

        if (this.password == null) {
            this.addError("Please provide a password");
            return;
        }

        if (this.password.length() < 8) {
            this.addError("Please provide a password of at least 8 characters");
            return;
        }

        try {

            JSONObject body = new JSONObject();
            body.put("username", this.username);
            body.put("password", this.password);

            HttpResponse<String> response = this.post("/user/signup")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asString();

            if (response.getStatus() != 200) {
                this.addError(response.getBody());
                return;
            }

            this.setResult(response);
        } catch (UnirestException e) {
            this.addError("Couldn't connect to the server");
        }
    }
}
