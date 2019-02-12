package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateK implements State {

	private StateMachine sm;

	public StateK(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'd')
			this.getSm().setState(sm.getStateBL());
		else if(c == ' ')
			this.getSm().setState(sm.getStateL());
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
