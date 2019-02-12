package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateD implements State {

	private StateMachine sm;

	public StateD(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		this.getSm().setState(sm.getStateD());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}

}
