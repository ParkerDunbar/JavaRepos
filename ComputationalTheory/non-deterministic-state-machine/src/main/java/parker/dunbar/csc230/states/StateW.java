package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateW implements State {

	private StateMachine sm;

	public StateW(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		this.getSm().setState(sm.getStateW());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}

}
