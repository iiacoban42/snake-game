import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    private Parent root;


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/homeScreen.fxml"));
        root = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }


}
