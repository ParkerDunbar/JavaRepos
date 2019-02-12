package dunbar.parker.csc230.states;

import dunbar.parker.csc230.state.StateMachine;

public class StateC implements State{
	
	private StateMachine sm;
	
	public StateC(StateMachine sm) {
		this.setSm(sm);
	}
	
	public void change(char c) {
		this.getSm().setState(sm.getStateC());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}

}
