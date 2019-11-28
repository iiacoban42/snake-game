package nl.tudelft.group11.snake.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public abstract class Controller {

    /**
     * Switches to another window.
     *
     * @param fxmlFile to switch to.
     * @throws IOException if something goes wrong.
     */
    public void changeWindow(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/" + fxmlFile));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);

    }

    /**
     * Validate user input.
     *
     * @param text to check.
     * @return
     */
    public static boolean validText(String text) {
        return text != null && !text.isEmpty();
    }

}
