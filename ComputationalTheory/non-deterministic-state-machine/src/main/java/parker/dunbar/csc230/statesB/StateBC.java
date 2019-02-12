package parker.dunbar.csc230.statesB;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateBC implements State {

	private StateMachine sm;

	public StateBC(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'a')
			this.getSm().setState(sm.getStateBD());
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
