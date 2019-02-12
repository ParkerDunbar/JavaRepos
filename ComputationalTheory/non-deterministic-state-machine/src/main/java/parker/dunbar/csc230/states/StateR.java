package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateR implements State {

	private StateMachine sm;

	public StateR(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == ' ')
			this.getSm().setState(sm.getStateS());
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
