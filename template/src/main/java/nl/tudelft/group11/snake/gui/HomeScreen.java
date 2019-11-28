package nl.tudelft.group11.snake.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.tudelft.group11.snake.gui.Controller;

@SuppressWarnings("PMD")
public class HomeScreen extends Controller {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    private String user;
    private String pass;

    public void registerButtonPressed(ActionEvent event) throws Exception {
        changeWindow("register.fxml");
    }

    /**
     *Sends username and password to the server. To be implemented.
     * @param event triggered by pressing the login button
     * @throws Exception if something goes wrong.
     */
    public void loginButtonPressed(ActionEvent event) throws Exception {
        user = username.getText();
        pass = password.getText();

        if (validText(user) && validText(pass)) {
            String result = "";

        }

    }
}

