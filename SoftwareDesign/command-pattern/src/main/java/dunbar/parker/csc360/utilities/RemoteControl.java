package dunbar.parker.csc360.utilities;

import java.util.Stack;

public class RemoteControl {
	
	public static final int ROWS = 8;
	public static final int COLS = 2;
	
//	private Object[][] buttons = new Object[ROWS][COLS];
	private Command[][] buttons = new Command[ROWS][COLS];
	
	private Stack<Command> commands = new Stack<Command>();
	
	public void program(int r, int c, Command functionality) {
		buttons[r][c] = functionality;
	}
	
	public void pressButton(int r, int c) {
		Command cmd = buttons[r][c];
		if(cmd != null) {
			cmd.execute();
			commands.push(cmd.clone());
		}
		
//		if(buttons[r][c] instanceof CeilingLight) {
//			CeilingLight light = (CeilingLight)buttons[r][c];
//			light.on();
//		}
//		else if(buttons[r][c] instanceof Hottub) {
//			
//		}

	}
	
	public void pressUndoButton() {
		if(commands.isEmpty()) {
			return;
		}
		Command cmd = commands.pop();
		cmd.undo();
	}
}
