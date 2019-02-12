package dunbar.parker.csc230.state;

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
import dunbar.parker.csc230.states.StateJ;
import dunbar.parker.csc230.states.StateK;
import dunbar.parker.csc230.states.StateL;
import dunbar.parker.csc230.states.StateM;
import dunbar.parker.csc230.states.StateN;
import dunbar.parker.csc230.states.StateO;
import dunbar.parker.csc230.states.StateP;
import dunbar.parker.csc230.states.StateQ;
import dunbar.parker.csc230.states.StateR;
import dunbar.parker.csc230.states.StateS;
import dunbar.parker.csc230.states.StateT;
import dunbar.parker.csc230.states.StateU;
import dunbar.parker.csc230.states.StateV;
import dunbar.parker.csc230.states.StateW;
import dunbar.parker.csc230.states.StateX;
import dunbar.parker.csc230.states.StateY;

public class StateMachine {
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
	private StateJ stateJ;
	private StateK stateK;
	private StateL stateL;
	private StateM stateM;
	private StateN stateN;
	private StateO stateO;
	private StateP stateP;
	private StateQ stateQ;
	private StateR stateR;
	private StateS stateS;
	private StateT stateT;
	private StateU stateU;
	private StateV stateV;
	private StateW stateW;
	private StateX stateX;
	private StateY stateY;

	public StateMachine() {
		this.stateA = new StateA(this);
		this.stateB = new StateB(this);
		this.stateC = new StateC(this);
		this.stateD = new StateD(this);
		this.stateE = new StateE(this);
		this.stateF = new StateF(this);
		this.stateG = new StateG(this);
		this.stateH = new StateH(this);
		this.stateI = new StateI(this);
		this.stateJ = new StateJ(this);
		this.stateK = new StateK(this);
		this.stateL = new StateL(this);
		this.stateM = new StateM(this);
		this.stateN = new StateN(this);
		this.stateO = new StateO(this);
		this.stateP = new StateP(this);
		this.stateQ = new StateQ(this);
		this.stateR = new StateR(this);
		this.stateS = new StateS(this);
		this.stateT = new StateT(this);
		this.stateU = new StateU(this);
		this.stateV = new StateV(this);
		this.stateW = new StateW(this);
		this.stateX = new StateX(this);
		this.stateY = new StateY(this);
	}

	public void run() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Say hi, hello, howdy, aloha, thanks, or thank you to ELIZA!");

		while (true) {
			this.setState(stateA);
			String userInput = bf.readLine();
			userInput = userInput.toLowerCase();
			
			for (char c : userInput.toCharArray()) {
				this.getState().change(c);
			}
			
			if (this.getState().equals(stateC))
				System.out.println("Hi! (Hi recognized)");
			else if (this.getState().equals(stateG)) 
				System.out.println("Hello! (Hello recognized)");
			else if (this.getState().equals(stateK))
				System.out.println("Howdy! (Howdy recognized)");
			else if (this.getState().equals(stateP))
				System.out.println("Aloha! (Aloha recognized)");
			else if (this.getState().equals(stateV))
				System.out.println("Thanks! (Thanks / Thank You recognized)");
		}
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

	public StateJ getStateJ() {
		return stateJ;
	}

	public StateK getStateK() {
		return stateK;
	}

	public StateL getStateL() {
		return stateL;
	}

	public StateM getStateM() {
		return stateM;
	}

	public StateN getStateN() {
		return stateN;
	}

	public StateO getStateO() {
		return stateO;
	}

	public StateP getStateP() {
		return stateP;
	}

	public StateQ getStateQ() {
		return stateQ;
	}

	public StateR getStateR() {
		return stateR;
	}

	public StateS getStateS() {
		return stateS;
	}

	public StateT getStateT() {
		return stateT;
	}

	public StateU getStateU() {
		return stateU;
	}

	public StateV getStateV() {
		return stateV;
	}

	public StateW getStateW() {
		return stateW;
	}

	public StateX getStateX() {
		return stateX;
	}

	public StateY getStateY() {
		return stateY;
	}

}
