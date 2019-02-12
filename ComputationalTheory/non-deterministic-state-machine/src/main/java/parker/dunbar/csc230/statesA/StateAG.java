package parker.dunbar.csc230.statesA;

import parker.dunbar.csc230.state.StateMachine;
import parker.dunbar.csc230.states.State;

public class StateAG implements State {

	private StateMachine sm;

	public StateAG(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'd')
			this.getSm().setState(sm.getStateAH());
		else if(c == 'h')
			this.getSm().setState(sm.getStateB());
		else if(c == 'a')
			this.getSm().setState(sm.getStateAM());
		else if(c == 't')
			this.getSm().setState(sm.getStateBB());
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
