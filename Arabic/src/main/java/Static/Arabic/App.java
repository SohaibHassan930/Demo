package Static.Arabic;

import Static.Arabic.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		Controller controller = new Controller();
		controller.showView(stage);
	}

	public static void main(String[] args) {
		launch();
	}

}