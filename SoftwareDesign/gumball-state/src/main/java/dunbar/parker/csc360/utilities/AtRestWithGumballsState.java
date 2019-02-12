package dunbar.parker.csc360.utilities;

public class AtRestWithGumballsState implements State {
	
	private GumballMachine machine;
	
	public AtRestWithGumballsState(GumballMachine m) {
		this.setMachine(m);
	}
	
	public GumballMachine getMachine() {
		return machine;
	}

	public void setMachine(GumballMachine machine) {
		if(machine == null) {
			throw new IllegalArgumentException("cannot be null");
		}
		this.machine = machine;
	}

	public void insertCoin() {
		this.getMachine().setState(this.machine.getPaymentInsertedState());
	}

	public void turnCrank() {
		System.err.println("Cannot crank in this state");
	}

	public void takeGumball() {
		System.err.println("No gumball to take");
	}

	public void pressCoinReturn() {
		System.err.println("No coin to return");
	}
}
