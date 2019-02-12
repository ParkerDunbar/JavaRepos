package parker.dunbar.csc230.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parker.dunbar.csc230.states.State;
import parker.dunbar.csc230.states.StateA;
import parker.dunbar.csc230.states.StateB;
import parker.dunbar.csc230.states.StateC;
import parker.dunbar.csc230.states.StateD;
import parker.dunbar.csc230.states.StateE;
import parker.dunbar.csc230.states.StateF;
import parker.dunbar.csc230.states.StateG;
import parker.dunbar.csc230.states.StateH;
import parker.dunbar.csc230.states.StateI;
import parker.dunbar.csc230.states.StateJ;
import parker.dunbar.csc230.states.StateK;
import parker.dunbar.csc230.states.StateL;
import parker.dunbar.csc230.states.StateM;
import parker.dunbar.csc230.states.StateN;
import parker.dunbar.csc230.states.StateO;
import parker.dunbar.csc230.states.StateP;
import parker.dunbar.csc230.states.StateQ;
import parker.dunbar.csc230.states.StateR;
import parker.dunbar.csc230.states.StateS;
import parker.dunbar.csc230.states.StateT;
import parker.dunbar.csc230.states.StateU;
import parker.dunbar.csc230.states.StateV;
import parker.dunbar.csc230.states.StateW;
import parker.dunbar.csc230.states.StateX;
import parker.dunbar.csc230.states.StateY;
import parker.dunbar.csc230.states.StateZ;
import parker.dunbar.csc230.statesA.StateAA;
import parker.dunbar.csc230.statesA.StateAB;
import parker.dunbar.csc230.statesA.StateAC;
import parker.dunbar.csc230.statesA.StateAD;
import parker.dunbar.csc230.statesA.StateAE;
import parker.dunbar.csc230.statesA.StateAF;
import parker.dunbar.csc230.statesA.StateAG;
import parker.dunbar.csc230.statesA.StateAH;
import parker.dunbar.csc230.statesA.StateAI;
import parker.dunbar.csc230.statesA.StateAJ;
import parker.dunbar.csc230.statesA.StateAK;
import parker.dunbar.csc230.statesA.StateAL;
import parker.dunbar.csc230.statesA.StateAM;
import parker.dunbar.csc230.statesA.StateAN;
import parker.dunbar.csc230.statesA.StateAO;
import parker.dunbar.csc230.statesA.StateAP;
import parker.dunbar.csc230.statesA.StateAQ;
import parker.dunbar.csc230.statesA.StateAR;
import parker.dunbar.csc230.statesA.StateAS;
import parker.dunbar.csc230.statesA.StateAT;
import parker.dunbar.csc230.statesA.StateAU;
import parker.dunbar.csc230.statesA.StateAV;
import parker.dunbar.csc230.statesA.StateAW;
import parker.dunbar.csc230.statesA.StateAX;
import parker.dunbar.csc230.statesA.StateAY;
import parker.dunbar.csc230.statesA.StateAZ;
import parker.dunbar.csc230.statesB.StateBA;
import parker.dunbar.csc230.statesB.StateBB;
import parker.dunbar.csc230.statesB.StateBC;
import parker.dunbar.csc230.statesB.StateBD;
import parker.dunbar.csc230.statesB.StateBE;
import parker.dunbar.csc230.statesB.StateBF;
import parker.dunbar.csc230.statesB.StateBG;
import parker.dunbar.csc230.statesB.StateBH;
import parker.dunbar.csc230.statesB.StateBI;
import parker.dunbar.csc230.statesB.StateBJ;
import parker.dunbar.csc230.statesB.StateBK;
import parker.dunbar.csc230.statesB.StateBL;
import parker.dunbar.csc230.statesB.StateBM;
import parker.dunbar.csc230.statesB.StateBN;
import parker.dunbar.csc230.statesC.StateCC;

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
	private StateZ stateZ;
	// A
	private StateAA stateAA;
	private StateAB stateAB;
	private StateAC stateAC;
	private StateAD stateAD;
	private StateAE stateAE;
	private StateAF stateAF;
	private StateAG stateAG;
	private StateAH stateAH;
	private StateAI stateAI;
	private StateAJ stateAJ;
	private StateAK stateAK;
	private StateAL stateAL;
	private StateAM stateAM;
	private StateAN stateAN;
	private StateAO stateAO;
	private StateAP stateAP;
	private StateAQ stateAQ;
	private StateAR stateAR;
	private StateAS stateAS;
	private StateAT stateAT;
	private StateAU stateAU;
	private StateAV stateAV;
	private StateAW stateAW;
	private StateAX stateAX;
	private StateAY stateAY;
	private StateAZ stateAZ;
	// B
	private StateBA stateBA;
	private StateBB stateBB;
	private StateBC stateBC;
	private StateBD stateBD;
	private StateBE stateBE;
	private StateBF stateBF;
	private StateBG stateBG;
	private StateBH stateBH;
	private StateBI stateBI;
	private StateBJ stateBJ;
	private StateBK stateBK;
	private StateBL stateBL;
	private StateBM stateBM;
	private StateBN stateBN;
	// C
	private StateCC stateCC;
	
	
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
		this.stateZ = new StateZ(this);
		// A
		this.stateAA = new StateAA(this);
		this.stateAB = new StateAB(this);
		this.stateAC = new StateAC(this);
		this.stateAD = new StateAD(this);
		this.stateAE = new StateAE(this);
		this.stateAF = new StateAF(this);
		this.stateAG = new StateAG(this);
		this.stateAH = new StateAH(this);
		this.stateAI = new StateAI(this);
		this.stateAJ = new StateAJ(this);
		this.stateAK = new StateAK(this);
		this.stateAL = new StateAL(this);
		this.stateAM = new StateAM(this);
		this.stateAN = new StateAN(this);
		this.stateAO = new StateAO(this);
		this.stateAP = new StateAP(this);
		this.stateAQ = new StateAQ(this);
		this.stateAR = new StateAR(this);
		this.stateAS = new StateAS(this);
		this.stateAT = new StateAT(this);
		this.stateAU = new StateAU(this);
		this.stateAV = new StateAV(this);
		this.stateAW = new StateAW(this);
		this.stateAX = new StateAX(this);
		this.stateAY = new StateAY(this);
		this.stateAZ = new StateAZ(this);
		// B
		this.stateBA = new StateBA(this);
		this.stateBB = new StateBB(this);
		this.stateBC = new StateBC(this);
		this.stateBD = new StateBD(this);
		this.stateBE = new StateBE(this);
		this.stateBF = new StateBF(this);
		this.stateBG = new StateBG(this);
		this.stateBH = new StateBH(this);
		this.stateBI = new StateBI(this);
		this.stateBJ = new StateBJ(this);
		this.stateBK = new StateBK(this);
		this.stateBL = new StateBL(this);
		this.stateBM = new StateBM(this);
		this.stateBN = new StateBN(this);
		// C
		this.stateCC = new StateCC(this);
	}
	

	public void run() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Greet, thank, or ask Eliza how she is doing!");
		
		while (true) {
			this.setState(getStateA());
			String userInput = bf.readLine();
			userInput = userInput.toLowerCase();
			
			for (char c : userInput.toCharArray()) {
				this.getState().change(c);
			}
			determineEOL();
			determineOutput();
		}
	}


	private void determineEOL() {
		// C, H, BM, V, AE, AQ, AZ, BG
		if(this.getState().equals(stateC))
			this.setState(stateD);
		else if(this.getState().equals(stateH))
			this.setState(stateI);
		else if(this.getState().equals(stateBM))
			this.setState(stateBN);
		else if(this.getState().equals(stateV))
			this.setState(stateW);
		else if(this.getState().equals(stateAE))
			this.setState(stateAF);
		else if(this.getState().equals(stateAQ))
			this.setState(stateAR);
		else if(this.getState().equals(stateAZ))
			this.setState(stateBA);
		else if(this.getState().equals(stateBG))
			this.setState(stateBH);
	}
	
	private void determineOutput() {
		if(this.getState().equals(stateD))
			System.out.println("Hi! (Hi recognized)");
		else if(this.getState().equals(stateI))
			System.out.println("Hello! (Hello recognized)");
		else if(this.getState().equals(stateBN))
			System.out.println("Howdy! (Howdy recognized)");
		else if(this.getState().equals(stateW))
			System.out.println("I do well, thanks! (HDYD? recognized)");
		else if(this.getState().equals(stateAF))
			System.out.println("I'm doing well, thanks! (HAY? / HAYD?  recognized)");
		else if(this.getState().equals(stateAR))
			System.out.println("Aloha! (Aloha recognized)");
		else if(this.getState().equals(stateBA))
			System.out.println("Ahoy! (Ahoy mate recognized)");
		else if(this.getState().equals(stateBH))
			System.out.println("You're welcome! (Thanks / Thank you recognized)");
		else
			System.out.println("Not sure what you said there.");
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


	public StateZ getStateZ() {
		return stateZ;
	}


	public StateAA getStateAA() {
		return stateAA;
	}


	public StateAB getStateAB() {
		return stateAB;
	}


	public StateAC getStateAC() {
		return stateAC;
	}


	public StateAD getStateAD() {
		return stateAD;
	}


	public StateAE getStateAE() {
		return stateAE;
	}


	public StateAF getStateAF() {
		return stateAF;
	}


	public StateAG getStateAG() {
		return stateAG;
	}


	public StateAH getStateAH() {
		return stateAH;
	}


	public StateAI getStateAI() {
		return stateAI;
	}


	public StateAJ getStateAJ() {
		return stateAJ;
	}


	public StateAK getStateAK() {
		return stateAK;
	}


	public StateAL getStateAL() {
		return stateAL;
	}


	public StateAM getStateAM() {
		return stateAM;
	}


	public StateAN getStateAN() {
		return stateAN;
	}


	public StateAO getStateAO() {
		return stateAO;
	}


	public StateAP getStateAP() {
		return stateAP;
	}


	public StateAQ getStateAQ() {
		return stateAQ;
	}


	public StateAR getStateAR() {
		return stateAR;
	}


	public StateAS getStateAS() {
		return stateAS;
	}


	public StateAT getStateAT() {
		return stateAT;
	}


	public StateAU getStateAU() {
		return stateAU;
	}


	public StateAV getStateAV() {
		return stateAV;
	}


	public StateAW getStateAW() {
		return stateAW;
	}


	public StateAX getStateAX() {
		return stateAX;
	}


	public StateAY getStateAY() {
		return stateAY;
	}


	public StateAZ getStateAZ() {
		return stateAZ;
	}


	public StateBA getStateBA() {
		return stateBA;
	}


	public StateBB getStateBB() {
		return stateBB;
	}


	public StateBC getStateBC() {
		return stateBC;
	}


	public StateBD getStateBD() {
		return stateBD;
	}


	public StateBE getStateBE() {
		return stateBE;
	}


	public StateBF getStateBF() {
		return stateBF;
	}


	public StateBG getStateBG() {
		return stateBG;
	}


	public StateBH getStateBH() {
		return stateBH;
	}


	public StateBI getStateBI() {
		return stateBI;
	}


	public StateBJ getStateBJ() {
		return stateBJ;
	}


	public StateBK getStateBK() {
		return stateBK;
	}

	
	public StateBL getStateBL() {
		return stateBL;
	}

	
	public StateBM getStateBM() {
		return stateBM;
	}
	
	
	public StateBN getStateBN() {
		return stateBN;
	}
	
	
	public StateCC getStateCC() {
		return stateCC;
	}
}
