package dunbar.parker.csc180.javafx;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FxController extends Application {
	
	@FXML
	private Label countLabel;
	@FXML
	private IntegerProperty count = new SimpleIntegerProperty(0);
	
	public int getCount() {
		return count.get();
	}

	public void setCount(int count) {
		this.count.set(count);
	}
	
	public IntegerProperty countProperty() {
		return count;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("FxView.fxml"));
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	@FXML
	protected void onConnectClick(ActionEvent e) {
		new Alert(AlertType.INFORMATION, "You have clicked the button",
				ButtonType.APPLY, ButtonType.FINISH, ButtonType.CANCEL)
		.showAndWait().ifPresent(bt -> System.out.println(bt.getButtonData()));
	}
	
	@FXML
	protected void incrementCounter(ActionEvent e) {
		this.setCount(this.getCount() + 1);
	}
	
	public static void main(String[] args) {
		FxController.launch(FxController.class, args);
	}


}
