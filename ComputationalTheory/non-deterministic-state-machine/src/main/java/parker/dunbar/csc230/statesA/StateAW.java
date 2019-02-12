package parker.dunbar.csc230.statesA;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateAW implements State {

	private StateMachine sm;

	public StateAW(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'a')
			this.getSm().setState(sm.getStateAX());
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
