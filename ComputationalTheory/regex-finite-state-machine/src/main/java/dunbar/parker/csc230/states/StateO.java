package dunbar.parker.csc230.states;

import dunbar.parker.csc230.state.StateMachine;

public class StateO implements State {
	
	private StateMachine sm;
	
	public StateO(StateMachine sm) {
		this.setSm(sm);
	}
	
	public void change(char c) {
		if (c == 'a')
			this.getSm().setState(sm.getStateP());
		else if (c == 'h')
			this.getSm().setState(sm.getStateB());
		else if (c == 'i')
			this.getSm().setState(sm.getStateC());
		else if (c == 'e')
			this.getSm().setState(sm.getStateD());
		else if (c == 'o')
			this.getSm().setState(sm.getStateH());
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
