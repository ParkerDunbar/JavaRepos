package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateE implements State {

	private StateMachine sm;

	public StateE(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'l')
			this.getSm().setState(sm.getStateF());
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
