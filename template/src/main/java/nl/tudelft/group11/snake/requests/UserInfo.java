package nl.tudelft.group11.snake.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class UserInfo extends ApiRequest<JsonNode> {

    private String username;

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

            JSONObject body = new JSONObject();
            body.put("username", this.username);

            HttpResponse<JsonNode> response = this.post("/user/login")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asJson();

            if (response.getStatus() != 200) {
                this.addError("User not found");
                return;
            }

            this.setResult(response);
        } catch (UnirestException e) {
            this.addError("Couldn't connect to the server");
        }
    }
}
