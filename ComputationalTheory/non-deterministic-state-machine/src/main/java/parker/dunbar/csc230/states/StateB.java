package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateB implements State {

	private StateMachine sm;

	public StateB(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'i')
			this.getSm().setState(sm.getStateC());
		else if(c == 'e')
			this.getSm().setState(sm.getStateE());
		else if(c == 'o')
			this.getSm().setState(sm.getStateJ());
		else if(c == ' ')
			this.getSm().setState(sm.getStateA());
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
