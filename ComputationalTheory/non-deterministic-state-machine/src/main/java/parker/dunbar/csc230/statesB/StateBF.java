package parker.dunbar.csc230.statesB;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateBF implements State {

	private StateMachine sm;

	public StateBF(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 's')
			this.getSm().setState(sm.getStateBG());
		else if(c == ' ')
			this.getSm().setState(sm.getStateBI());
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
