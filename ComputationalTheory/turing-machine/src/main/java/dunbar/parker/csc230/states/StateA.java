package dunbar.parker.csc230.states;

import dunbar.parker.csc230.turing.Turing;

public class StateA implements State {
	private Turing t;
	
	public StateA(Turing turing) {
		this.setT(turing);
	}

	public void change(char c) {
		if(c == '_') {
			t.setCurrentIndex(t.getCurrentIndex() + 1);
		}
		else if(c >= 48 && c <= 57) {
			t.setCurrentIndex(t.getCurrentIndex() + 1);
		}
		else if(c == '=') {
			t.setCurrentIndex(t.getCurrentIndex() + 1);
			t.setState(t.getStateB());
		}
	}

	public Turing getT() {
		return t;
	}

	public void setT(Turing t) {
		this.t = t;
	}

}
