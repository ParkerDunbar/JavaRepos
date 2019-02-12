package dunbar.parker.csc360.utilities;

public class GumballMachine {
	
	private State state;
	private AtRestWithGumballsState atRestWithGumballsState;
	private PaymentInsertedState paymentInsertedState;
	private DispensingGumballState dispensingGumballState;
	
	public GumballMachine() {
		this.atRestWithGumballsState = new AtRestWithGumballsState(this);
		this.paymentInsertedState = new PaymentInsertedState(this);
		this.dispensingGumballState = new DispensingGumballState(this);
		this.setState(atRestWithGumballsState);
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public AtRestWithGumballsState getAtRestWithGumballsState() {
		return atRestWithGumballsState;
	}
	public PaymentInsertedState getPaymentInsertedState() {
		return paymentInsertedState;
	}
	public DispensingGumballState getDispensingGumballState() {
		return dispensingGumballState;
	}
}
