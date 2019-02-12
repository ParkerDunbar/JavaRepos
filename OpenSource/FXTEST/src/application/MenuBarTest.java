package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuBarTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border);
		
		MenuBar menuBar = new MenuBar();
		Menu user = new Menu("User");
		MenuItem settings = new MenuItem("Settings");
		MenuItem logout = new MenuItem("Log Out");
		
		
		
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		MenuBarTest.launch(args);
	}



}
