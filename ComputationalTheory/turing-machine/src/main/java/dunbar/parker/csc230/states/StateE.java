package dunbar.parker.csc230.states;

import dunbar.parker.csc230.turing.Turing;

public class StateE implements State {
	private Turing t;
	
	public StateE(Turing turing) {
		this.setT(turing);
	}

	public void change(char c) {
		if(c == '9') {
			t.getTuringInput()[t.getCurrentIndex()] = '0';
			t.setCurrentIndex(t.getCurrentIndex() - 1);
		}
		else if(c == '_') {
			t.getTuringInput()[t.getCurrentIndex()] = '1';
			t.setCurrentIndex(t.getCurrentIndex() + 1);
			t.setState(t.getStateA());
		}
		else if(c >= 48 && c <= 56) {
			int increment = Character.getNumericValue(c) + 1;
			increment = increment + 48;
			t.getTuringInput()[t.getCurrentIndex()] = (char) increment;
			t.setCurrentIndex(t.getCurrentIndex() + 1);
			t.setState(t.getStateA());
		}

	}

	public Turing getT() {
		return t;
	}

	public void setT(Turing t) {
		this.t = t;
	}

}
