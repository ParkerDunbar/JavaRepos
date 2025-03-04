package dunbar.parker.csc230.states;

import dunbar.parker.csc230.turing.Turing;

public class StateH implements State {
	private Turing t;
	
	public StateH(Turing turing) {
		this.setT(turing);
	}

	public void change(char c) {
		if(c == '0' || c == '+') {
			t.getTuringInput()[t.getCurrentIndex()] = '_';
			t.setCurrentIndex(t.getCurrentIndex() + 1);
		}
		else if(c == '_') {
			t.setCurrentIndex(t.getCurrentIndex() + 1);
			t.setState(t.getStateI());
		}
	}

	public Turing getT() {
		return t;
	}

	public void setT(Turing t) {
		this.t = t;
	}

}
