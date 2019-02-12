package parker.dunbar.csc230.statesB;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateBM implements State {

	private StateMachine sm;

	public StateBM(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == ' ')
			this.getSm().setState(sm.getStateBN());
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
