package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateL implements State {

	private StateMachine sm;

	public StateL(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'd')
			this.getSm().setState(sm.getStateM());
		else if(c == 'a')
			this.getSm().setState(sm.getStateX());
		else if(c == 'h')
			this.getSm().setState(sm.getStateB());
		else if(c == 't')
			this.getSm().setState(sm.getStateBB());
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
