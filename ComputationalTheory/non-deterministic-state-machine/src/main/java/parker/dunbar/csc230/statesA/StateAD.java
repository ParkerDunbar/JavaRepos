package parker.dunbar.csc230.statesA;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateAD implements State {

	private StateMachine sm;

	public StateAD(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == '?')
			this.getSm().setState(sm.getStateAE());
		else if(c == ' ')
			this.getSm().setState(sm.getStateAG());
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
