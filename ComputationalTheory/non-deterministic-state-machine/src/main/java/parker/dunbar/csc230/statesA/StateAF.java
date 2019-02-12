package parker.dunbar.csc230.statesA;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateAF implements State {

	private StateMachine sm;

	public StateAF(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		this.getSm().setState(sm.getStateAF());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}
}
