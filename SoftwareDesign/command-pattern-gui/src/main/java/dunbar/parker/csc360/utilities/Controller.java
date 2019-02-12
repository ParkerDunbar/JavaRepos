package dunbar.parker.csc360.utilities;

import java.io.IOException;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {
	
	private Stack<Command> commands = new Stack<Command>();
	
	@FXML
	private Circle circle;
	@FXML
	private Button undo;
	@FXML
	private ColorPicker colorPicker;


	public Controller() {
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if(commands.isEmpty()) {
			return;
		}
		Command cmd = commands.pop();
		cmd.undo();
	}
	
	@FXML
	private void handleColorPicker() {
		Color c = colorPicker.getValue();
        Command cmd = new dunbar.parker.csc360.utilities.Color(circle, c);
        cmd.execute();
        commands.push(cmd.clone());
	}
	
	public void setCommand(Command c) {
		Command cmd = c;
		cmd.execute();
		commands.push(cmd.clone());
	}
	
	public dunbar.parker.csc360.utilities.Button setButton() {
		dunbar.parker.csc360.utilities.Button b = new dunbar.parker.csc360.utilities.Button();
		b.setCircle(circle);
		return b;
	}
}
