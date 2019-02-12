package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateZ implements State {

	private StateMachine sm;

	public StateZ(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == ' ')
			this.getSm().setState(sm.getStateAA());
		else
			this.getSm().setState(sm.getStateCC());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}
}
