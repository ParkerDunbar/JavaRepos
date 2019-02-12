package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateP implements State {

	private StateMachine sm;

	public StateP(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'o')
			this.getSm().setState(sm.getStateQ());
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
