package dunbar.parker.csc230.states;

import dunbar.parker.csc230.turing.Turing;

public class StateC implements State {
	private Turing t;
	
	public StateC(Turing turing) {
		this.setT(turing);
	}

	public void change(char c) {
		if(c >= 49 && c <= 57) {
			int decrement = Character.getNumericValue(c) - 1;
			decrement = decrement + 48;
			t.getTuringInput()[t.getCurrentIndex()] = (char) decrement;
			t.setCurrentIndex(t.getCurrentIndex() - 1);
			t.setState(t.getStateD());
		}
		else if(c == '+') {
			t.getTuringInput()[t.getCurrentIndex()] = '_';
			t.setCurrentIndex(t.getCurrentIndex() - 1);
			t.setState(t.getStateD());
		}
		else if(c == '0') {
			t.setCurrentIndex(t.getCurrentIndex() - 1);
			t.setState(t.getStateF());
		}

	}

	public Turing getT() {
		return t;
	}

	public void setT(Turing t) {
		this.t = t;
	}

}
