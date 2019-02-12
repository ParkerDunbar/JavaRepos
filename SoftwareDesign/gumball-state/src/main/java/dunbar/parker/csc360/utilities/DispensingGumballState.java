package dunbar.parker.csc360.utilities;

public class DispensingGumballState implements State {
	
	private GumballMachine machine;
	
	public DispensingGumballState(GumballMachine m) {
		this.setMachine(m);
	}
	
	public GumballMachine getMachine() {
		return machine;
	}

	public void setMachine(GumballMachine machine) {
		this.machine = machine;
	}

	public void insertCoin() {
		System.err.println("Coin cannot be inserted");
	}

	public void turnCrank() {
		System.err.println("Crank is already being turned");
		
	}

	public void takeGumball() {
		this.getMachine().setState(this.machine.getAtRestWithGumballsState());
		
	}

	public void pressCoinReturn() {
		System.err.println("Cannot return coin at this time");
	}



}
