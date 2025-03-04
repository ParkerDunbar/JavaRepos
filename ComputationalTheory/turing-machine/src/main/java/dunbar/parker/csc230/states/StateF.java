package dunbar.parker.csc230.states;

import dunbar.parker.csc230.turing.Turing;

public class StateF implements State {
	private Turing t;
	
	public StateF(Turing turing) {
		this.setT(turing);
	}

	public void change(char c) {
		if(c == '+') {
			t.setCurrentIndex(t.getCurrentIndex() - 1);
			t.setState(t.getStateC());
		}
		else if(c == '=') {
			t.getTuringInput()[t.getCurrentIndex()] = '_';
			t.setCurrentIndex(t.getCurrentIndex() + 1);
			t.setState(t.getStateH());
		}
		else if(c == '0') {
			t.setCurrentIndex(t.getCurrentIndex() - 1);
		}
		else if(c >= 49 && c <= 57) {
			int decrement = Character.getNumericValue(c) - 1;
			decrement = decrement + 48;
			t.getTuringInput()[t.getCurrentIndex()] = (char) decrement;
			t.setCurrentIndex(t.getCurrentIndex() + 1);
			t.setState(t.getStateG());
		}

	}

	public Turing getT() {
		return t;
	}

	public void setT(Turing t) {
		this.t = t;
	}

}
