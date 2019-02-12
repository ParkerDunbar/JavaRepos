package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateX implements State {

	private StateMachine sm;

	public StateX(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'r')
			this.getSm().setState(sm.getStateY());
		else if(c == 'l')
			this.getSm().setState(sm.getStateAN());
		else if(c == 'h')
			this.getSm().setState(sm.getStateAS());
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
