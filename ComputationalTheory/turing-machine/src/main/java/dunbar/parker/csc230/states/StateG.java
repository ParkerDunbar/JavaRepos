package dunbar.parker.csc230.states;

import dunbar.parker.csc230.turing.Turing;

public class StateG implements State {
	private Turing t;
	
	public StateG(Turing turing) {
		this.setT(turing);
	}

	public void change(char c) {
		if(c == '0') {
			t.getTuringInput()[t.getCurrentIndex()] = '9';
			t.setCurrentIndex(t.getCurrentIndex() + 1);
		}
		else if(c == '+' || c == '_') {
			t.setCurrentIndex(t.getCurrentIndex() - 1);
			t.setState(t.getStateD());
		}
	}

	public Turing getT() {
		return t;
	}

	public void setT(Turing t) {
		this.t = t;
	}

}
