package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateC implements State {

	private StateMachine sm;

	public StateC(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == ' ')
			this.getSm().setState(sm.getStateD());
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
