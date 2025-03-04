package dunbar.parker.csc230.turing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dunbar.parker.csc230.states.State;
import dunbar.parker.csc230.states.StateA;
import dunbar.parker.csc230.states.StateB;
import dunbar.parker.csc230.states.StateC;
import dunbar.parker.csc230.states.StateD;
import dunbar.parker.csc230.states.StateE;
import dunbar.parker.csc230.states.StateF;
import dunbar.parker.csc230.states.StateG;
import dunbar.parker.csc230.states.StateH;
import dunbar.parker.csc230.states.StateI;

public class Turing {
	private State state;
	private StateA stateA;
	private StateB stateB;
	private StateC stateC;
	private StateD stateD;
	private StateE stateE;
	private StateF stateF;
	private StateG stateG;
	private StateH stateH;
	private StateI stateI;
	private char[] turingInput;
	private int currentIndex;
	
	public Turing() {
		this.stateA = new StateA(this);
		this.stateB = new StateB(this);
		this.stateC = new StateC(this);
		this.stateD = new StateD(this);
		this.stateE = new StateE(this);
		this.stateF = new StateF(this);
		this.stateG = new StateG(this);
		this.stateH = new StateH(this);
		this.stateI = new StateI(this);
	}
	
	public void run() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter an addition equation with two base-10 numbers:");
		
		while(true) {
			String input = bf.readLine();
			input = "_________=" + input + "_________";
			turingInput = input.toCharArray();
			
			calculateEquation();
			print();
			
		}
	}

	private void calculateEquation() {
		boolean calculating = true;
		currentIndex = 0;
		
		this.setState(stateA);
		while(calculating) {
			this.getState().change(turingInput[currentIndex]);
			if(this.getState().equals(stateI)) {
				calculating = false;
			}
		}
	}
	
	private void print() {
		String output = "";
		for(char c : turingInput) {
			output += c;
		}
		output = output.replaceAll("_", "");
		System.out.println(output);
		
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public StateA getStateA() {
		return stateA;
	}

	public StateB getStateB() {
		return stateB;
	}

	public StateC getStateC() {
		return stateC;
	}

	public StateD getStateD() {
		return stateD;
	}

	public StateE getStateE() {
		return stateE;
	}

	public StateF getStateF() {
		return stateF;
	}

	public StateG getStateG() {
		return stateG;
	}

	public StateH getStateH() {
		return stateH;
	}

	public StateI getStateI() {
		return stateI;
	}
	

	public char[] getTuringInput() {
		return turingInput;
	}

	public void setTuringInput(char[] turingInput) {
		this.turingInput = turingInput;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}
	

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

}
