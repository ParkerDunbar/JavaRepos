package parker.dunbar.csc230.statesA;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateAS implements State {

	private StateMachine sm;

	public StateAS(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'o')
			this.getSm().setState(sm.getStateAT());
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
