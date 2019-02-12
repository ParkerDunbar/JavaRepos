package parker.dunbar.csc230.statesB;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateBI implements State {

	private StateMachine sm;

	public StateBI(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'y')
			this.getSm().setState(sm.getStateBJ());
		else if(c == 'h')
			this.getSm().setState(sm.getStateB());
		else if(c == 'a')
			this.getSm().setState(sm.getStateAM());
		else if(c == 't')
			this.getSm().setState(sm.getStateBB());
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
