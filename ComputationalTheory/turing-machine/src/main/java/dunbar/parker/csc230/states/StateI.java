package dunbar.parker.csc230.states;

import dunbar.parker.csc230.turing.Turing;

public class StateI implements State {
	private Turing t;
	
	public StateI(Turing turing) {
		this.setT(turing);
	}

	public void change(char c) {

	}

	public Turing getT() {
		return t;
	}

	public void setT(Turing t) {
		this.t = t;
	}

}
