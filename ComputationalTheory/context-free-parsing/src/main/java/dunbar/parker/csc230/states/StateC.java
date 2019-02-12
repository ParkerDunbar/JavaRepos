package dunbar.parker.csc230.states;

import dunbar.parker.csc230.parsing.Parser;

public class StateC implements State {

	private Parser p;

	public StateC(Parser p) {
		this.setP(p);
	}

	public void change(char c) {
		
	}

	public Parser getP() {
		return p;
	}

	public void setP(Parser p) {
		this.p = p;
	}

}
