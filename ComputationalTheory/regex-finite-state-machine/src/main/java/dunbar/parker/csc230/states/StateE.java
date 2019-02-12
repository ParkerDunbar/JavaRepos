package dunbar.parker.csc230.states;

import dunbar.parker.csc230.state.StateMachine;

public class StateE implements State {

	private StateMachine sm;

	public StateE(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if (c == 'l')
			this.getSm().setState(sm.getStateF());
		else if (c == 'h')
			this.getSm().setState(sm.getStateB());
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
