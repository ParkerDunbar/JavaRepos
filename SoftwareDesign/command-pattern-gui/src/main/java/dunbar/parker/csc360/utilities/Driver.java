package dunbar.parker.csc360.utilities;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Driver extends Application {

	public static void main(String[] args) {
		Driver.launch(Driver.class, args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("Command.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Command.fxml"));
		Parent root = (Parent) loader.load();
		Controller controller = (Controller) loader.getController();
		Scene s = new Scene(root);
		Button b = controller.setButton();
		s.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent event) {
		        if(event.getCode() == KeyCode.UP) {
		        	controller.setCommand(new ButtonUp(b, b.getPosition()));
		        } 
		        else if(event.getCode() == KeyCode.DOWN) {
		        	controller.setCommand(new ButtonDown(b, b.getPosition()));
		        }
		        else if(event.getCode() == KeyCode.RIGHT) {
		        	controller.setCommand(new ButtonRight(b, b.getPosition()));
		        }
		        else if(event.getCode() == KeyCode.LEFT) {
		        	controller.setCommand(new ButtonLeft(b, b.getPosition()));
		        }
		        event.consume();
		    }});
		
		
		primaryStage.setScene(s);
		primaryStage.setTitle("Command");
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
	

}
