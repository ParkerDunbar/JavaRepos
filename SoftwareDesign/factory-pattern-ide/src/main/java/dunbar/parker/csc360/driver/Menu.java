package dunbar.parker.csc360.driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application{

	public static void main(String[] args) {
		Menu.launch(Menu.class, args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("Form.fxml"));
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.setTitle("Factory IDE");
		primaryStage.setWidth(800);
		primaryStage.setHeight(400);
		primaryStage.show();
	}

}
