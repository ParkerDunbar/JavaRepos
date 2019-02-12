package dunbar.parker.csc230.states;

import dunbar.parker.csc230.parsing.Parser;

public class StateB implements State {

	private Parser p;

	public StateB(Parser p) {
		this.setP(p);
	}

	public void change(char c) {
		if(c == ' ')
			p.setState(p.getStateC());
			
		else
			p.setState(p.getStateB());
	}

	public Parser getP() {
		return p;
	}

	public void setP(Parser p) {
		this.p = p;
	}

}
