package dunbar.parker.csc230.states;

import dunbar.parker.csc230.state.StateMachine;

public class StateP implements State {

	private StateMachine sm;
	
	public StateP(StateMachine sm) {
		this.setSm(sm);
	}
	
	public void change(char c) {
		this.getSm().setState(sm.getStateP());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}	
}
