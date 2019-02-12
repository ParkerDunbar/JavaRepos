package parker.dunbar.csc230.states;

import parker.dunbar.csc230.state.StateMachine;

public class StateO implements State {

	private StateMachine sm;

	public StateO(StateMachine sm) {
		this.setSm(sm);
	}

	public void change(char c) {
		if(c == 'y')
			this.getSm().setState(sm.getStateP());
		else if(c == 'h')
			this.getSm().setState(sm.getStateB());
		else if(c == 'a')
			this.getSm().setState(sm.getStateAM());
		else if(c == 't')
			this.getSm().setState(sm.getStateBB());
		else if(c == ' ')
			this.getSm().setState(sm.getStateO());
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
