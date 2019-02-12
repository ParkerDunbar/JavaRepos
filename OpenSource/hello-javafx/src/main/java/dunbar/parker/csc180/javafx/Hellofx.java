package dunbar.parker.csc180.javafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Hellofx extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Title");
		Label usernameLabel = new Label("Username:"), passwordLabel = new Label("Password:");
		TextField usernameBox = new TextField(), passwordBox = new TextField();
		Button loginButton = new Button("Log in");
		
		usernameLabel.setTextAlignment(TextAlignment.RIGHT);
		passwordLabel.setTextAlignment(TextAlignment.RIGHT);
		
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setAlignment(Pos.CENTER);
		grid.add(usernameLabel, 0, 0);
		grid.add(usernameBox, 1, 0);
		grid.add(passwordLabel, 0, 1);
		grid.add(passwordBox, 1, 1);
		grid.add(loginButton, 0, 2);
		grid.setConstraints(loginButton, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		
		Group group = new Group(grid);
		Scene scene = new Scene(group);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		loginButton.setOnMouseClicked(e -> displayMessage());
		
	}
	
	public void displayMessage() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("I have a great message for you!");

		alert.showAndWait();
	}

	public static void main(String[] args) {
		Hellofx.launch();
	}
}
