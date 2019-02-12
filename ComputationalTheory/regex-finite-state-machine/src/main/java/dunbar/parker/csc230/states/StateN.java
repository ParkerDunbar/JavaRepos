package dunbar.parker.csc230.states;

import dunbar.parker.csc230.state.StateMachine;

public class StateN implements State {

	private StateMachine sm;
	
	public StateN(StateMachine sm) {
		this.setSm(sm);
	}
	
	public void change(char c) {
		if (c == 'h')
			this.getSm().setState(sm.getStateO());
		else if (c == 'a')
			this.getSm().setState(sm.getStateL());
		else if (c == 't')
			this.getSm().setState(sm.getStateQ());
		else
			this.getSm().setState(sm.getStateA());
	}

	public StateMachine getSm() {
		return sm;
	}

	public void setSm(StateMachine sm) {
		this.sm = sm;
	}	
}
