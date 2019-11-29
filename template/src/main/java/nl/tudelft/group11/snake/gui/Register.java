package nl.tudelft.group11.snake.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import nl.tudelft.group11.snake.requests.Signup;

@SuppressWarnings("PMD")
public class Register extends Controller {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Text errors;

    @FXML
    private Button registerButton;
    private String user;
    private String pass;

    /**
     * Sends username and password to the server. To be implemented.
     *
     * @param event triggered by pressing the register button
     * @throws Exception if something goes wrong.
     */
    public void registerButtonPressed(ActionEvent event) throws Exception {
        user = username.getText();
        pass = password.getText();

        if (validText(user) && validText(pass)) {
            Signup signup = new Signup(user, pass);
            signup.execute();

            if (signup.hasErrors()) {
                errors.setText(signup.getErrors().get(0));
            } else {
                errors.setText(signup.getResult().getBody());
            }
        }

    }
}
