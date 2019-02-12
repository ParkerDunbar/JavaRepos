package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateI implements State {

	private StateMachine sm;

	public StateI(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		this.getSm().setState(sm.getStateI());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}

}
