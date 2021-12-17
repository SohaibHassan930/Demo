package Static.Arabic.Controller;

import Static.Arabic.Model.Handler.Model;
import Static.Arabic.View.View;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller implements Show {
//step 1
	private Model model;
	private Parent dashboardView;

//step 2
	public Controller() {
		this.model = new Model();
	}

	public void addBookDetails(String bookName, String bookId, String bookAuthorName, String bookDescriptions) {
		this.model.setBookName(bookName);
		this.model.setBookId(bookId);
		this.model.setBookAuthor(bookAuthorName);
		this.model.setBookDescription(bookDescriptions);

		System.out.print("Added");
	}
	// ignore

	@Override
	public void showView(Stage stage) {
		this.dashboardView = new View(this, this.model);
		Scene scene = stage.getScene();
		if (scene == null) {
			scene = new Scene(this.dashboardView, 600, 600);
			stage.setScene(scene);
		}

		scene.setRoot(this.dashboardView);
		stage.show();
	}

}
