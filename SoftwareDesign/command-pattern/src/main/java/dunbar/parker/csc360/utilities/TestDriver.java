package dunbar.parker.csc360.utilities;

public class TestDriver {

	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl();
		
//		rc.program(0, 0, new CeilingLight());
//		rc.program(0, 0, new CeilingLightOnCommand(new CeilingLight()));
		
		CeilingFan fan = new CeilingFan();
		rc.program(1, 1, new CeilingFanHighCommand(fan, fan.getSpeed() != null ? fan.getSpeed() : "off"));
		
		
//		Anonymous Typing
//		rc.program(0, 1, new Command() {
//			public void execute() {
//				new CeilingLight().off();
//			}
//		});
		
		
//		Lambda / Functional Programming
//		rc.program(0, 1, () -> new CeilingLight().off());
		
		

//		rc.pressButton(0, 1);
		rc.pressButton(1, 1);
		rc.pressButton(1, 1);
		rc.pressUndoButton();
		rc.pressUndoButton();
	}

}
