package dunbar.parker.csc360.utilities;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Driver extends Application {
	
	Driver driver;
	StopLight stopLight;
	TimerTask task;
	
	@FXML
	private Canvas canvas;
	@FXML
	private Button stopLightButton;
	
	
	public static void main(String[] args) {
		Driver.launch(Driver.class, args);
	}
	
    @FXML
    void initialize() {
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	draw(gc);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Stoplight.fxml"));
		Parent root = fxmlLoader.load();
		Scene s = new Scene(root);
		
//		Parent root = FXMLLoader.load(this.getClass().getResource("Stoplight.fxml"));
		
		primaryStage.setScene(s);
		primaryStage.setTitle("Stoplight");
		primaryStage.setMaximized(true);
		primaryStage.show();
		initStopLightTimer();
	}
	
	@FXML
	private void handleButtonAction(ActionEvent event) {

	}
	
	private void initStopLightTimer() {
		stopLight = new StopLight(this);
		task = new Switch(stopLight);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task,5000,5000);
	}
	
	private void draw(GraphicsContext gc) {
	      gc.setFill(Color.BLACK);
	      gc.fillRect(0, 0, 1000, 1000);
	      gc.setFill(Color.RED);
	      gc.fillOval(135, 25, 150, 150);
	      gc.setFill(Color.YELLOW);
	      gc.fillOval(135, 225, 150, 150);
	      gc.setFill(Color.GREEN);
	      gc.fillOval(135, 425, 150, 150);
	}
	
	public void drawGreenLight() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
	    gc.setFill(Color.RED);
	    gc.fillOval(135, 25, 150, 150);
	}

}
