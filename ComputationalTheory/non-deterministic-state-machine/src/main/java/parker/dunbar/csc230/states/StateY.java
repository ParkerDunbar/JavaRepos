package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateY implements State {

	private StateMachine sm;

	public StateY(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'e')
			this.getSm().setState(sm.getStateZ());
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
