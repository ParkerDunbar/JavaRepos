package parker.dunbar.csc230.statesB;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateBA implements State {

	private StateMachine sm;

	public StateBA(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		this.getSm().setState(sm.getStateBA());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}

}
