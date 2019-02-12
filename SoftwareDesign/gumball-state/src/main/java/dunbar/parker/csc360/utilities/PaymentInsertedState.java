package dunbar.parker.csc360.utilities;

public class PaymentInsertedState implements State {
	
	private GumballMachine machine;
	
	public PaymentInsertedState(GumballMachine m) {
		this.setMachine(m);
	}
	
	public GumballMachine getMachine() {
		return machine;
	}

	public void setMachine(GumballMachine machine) {
		this.machine = machine;
	}

	public void insertCoin() {
		System.err.println("Coin already inserted");
	}

	public void turnCrank() {
		this.getMachine().setState(this.machine.getDispensingGumballState());
	}

	public void takeGumball() {
		System.err.println("No gumball to take");
	}

	public void pressCoinReturn() {
		this.getMachine().setState(this.machine.getAtRestWithGumballsState());
	}



}
