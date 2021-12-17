package Static.Arabic.View;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Static.Arabic.Controller.Controller;
import Static.Arabic.Model.Handler.Model;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class View extends Pane implements PropertyChangeListener {
	private Text welcomeTxt;

	private TextField bookAuthor;
	private TextField bookName;
	private TextField bookDescription;
	private TextField bookID;
	private Label name;
	private Label id;
	private Label author;
	private Label description;
	private Label empty;
	private Button save;
	private Button back;
	private Button select;
	private FileChooser fileChooser;
	private Model model;
	private Controller controller;

//step 1
	public View(Controller controller, Model model) {

		this.initialize(controller, model);
	}

// step 2 fun defi
	private void initialize(Controller controller, Model model) {
//step 3
		this.controller = controller;
		this.model = model;
		this.model.addPropertyChangeListener(this);
//step 4
		this.welcomeTxt = new Text();
		this.welcomeTxt.setText("Arabic Corpus");
		this.welcomeTxt.setLayoutX(200);
		this.welcomeTxt.setLayoutY(100);
		this.welcomeTxt.setFont(Font.font("Money Serif", FontWeight.THIN, 45));
		this.welcomeTxt.setFill(Color.DARKSLATEBLUE);
		this.getChildren().add(welcomeTxt);

//step 5
		name = new Label(); // Name
		name.setStyle("-fx-font-weight: bold");
		name.setText("Name");
		name.relocate(190, 154);
		name.setPrefWidth(500);
		name.setPrefHeight(28);
		this.getChildren().add(name);
//step 6
		this.bookName = new TextField(); // Name TextField
		this.bookName.setPromptText("e.g: Heroes Of Islam");
		this.bookName.relocate(260, 154);
		this.bookName.setPrefWidth(200);
		this.bookName.setPrefHeight(27);
		this.getChildren().add(bookName);
//step 7
		id = new Label(); // ID
		id.setStyle("-fx-font-weight: bold");
		id.setText("ID");
		id.relocate(190, 195);
		id.setPrefWidth(500);
		id.setPrefHeight(28);
		this.getChildren().add(id);
//step 8

		this.bookID = new TextField(); // ID TextField
		this.bookID.setPromptText("e.g: EA101");
		this.bookID.relocate(260, 195);
		this.bookID.setPrefWidth(200);
		this.bookID.setPrefHeight(27);
		this.getChildren().add(bookID);
//step 9
		author = new Label(); // Author
		author.setStyle("-fx-font-weight: bold");
		author.setText("Author");
		author.relocate(190, 235);
		author.setPrefWidth(500);
		author.setPrefHeight(28);
		this.getChildren().add(author);
//step 10

		this.bookAuthor = new TextField(); // Author TextField
		this.bookAuthor.setPromptText("e.g: Prof.M Esma'il Sieny");
		this.bookAuthor.relocate(260, 235);
		this.bookAuthor.setPrefWidth(200);
		this.bookAuthor.setPrefHeight(27);
		this.getChildren().add(bookAuthor);
//step 11
		description = new Label(); // Description
		description.setStyle("-fx-font-weight: bold");
		description.setText("Description");
		description.relocate(190, 275);
		description.setPrefWidth(500);
		description.setPrefHeight(28);
		getChildren().add(description);
//step 12
		this.bookDescription = new TextField(); // Description TextField
		this.bookDescription.setPromptText("e.g: XYZ");
		this.bookDescription.relocate(260, 278);
		this.bookDescription.setPrefWidth(200);
		this.bookDescription.setPrefHeight(27);
		this.getChildren().add(bookDescription);
//step 13

		this.select = new Button(); // Back to Home Button
		this.select.setText("Select");
		this.select.relocate(250, 320); // change 250
		this.select.setPrefWidth(68); //change 68
		this.select.setPrefHeight(30);
		this.select.setTextFill(Color.MIDNIGHTBLUE);
		this.getChildren().add(select);
		
		this.save = new Button(); // Save Button
		this.save.setText("Save");
		this.save.relocate(327, 320); // change 327
		this.save.setPrefWidth(68); //change 68
		this.save.setPrefHeight(30);
		this.save.setTextFill(Color.MIDNIGHTBLUE);
		this.getChildren().add(save);
//step 14
		this.back = new Button(); // Back to Home Button
		this.back.setText("Back");
		this.back.relocate(404, 320);  //Change 404
		this.back.setPrefWidth(68); // change 68
		this.back.setPrefHeight(30);
		this.back.setTextFill(Color.MIDNIGHTBLUE);
		this.getChildren().add(back);
		empty = new Label("");
//step 15
		save.setOnAction(event -> {
			String bookName = this.bookName.getText();
			String bookId = this.bookID.getText();
			String bookAuthorName = this.bookAuthor.getText();
			String bookDescriptions = this.bookDescription.getText();
			this.controller.addBookDetails(bookName, bookId, bookAuthorName, bookDescriptions);

			this.bookName.setText(this.empty.getText());
			this.bookID.setText(this.empty.getText());
			this.bookAuthor.setText(this.empty.getText());
			this.bookDescription.setText(this.empty.getText());
		});

		select.setOnAction(event -> {
			fileChooser = new FileChooser();
			FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("PDF File", "*pdf");
			fileChooser.getExtensionFilters().add(fileExtensions);
			fileChooser.showOpenDialog(null);
			//System.out.print(fileChooser);
		});
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if (propertyName.equals("name")) {
			updateName();
		}
	}

	private void updateName() {
		name.setText(this.model.getBookName());
	}

}