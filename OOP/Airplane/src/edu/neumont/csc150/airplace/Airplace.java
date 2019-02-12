package edu.neumont.csc150.airplace;

public class Airplace {

	public static void main(String[] args) {
		Pilot p = new Pilot("Sully", Rank.SeniorCaptain);
		Pilot p2 = new Pilot ("Joe", Rank.CoPilot);
		
		Passenger pass1 = new Passenger("John");
		Passenger pass2 = new Passenger("Carl");
		Passenger pass3 = new Passenger("Scott");
		Passenger pass4 = new Passenger("James");
		Passenger pass5 = new Passenger("Jake");
		Passenger pass6 = new Passenger("Larry");
		Passenger pass7 = new Passenger("Dave");
		Passenger pass8 = new Passenger("Ray");
		Passenger pass9 = new Passenger("Troy");
		Passenger pass10 = new Passenger("Shane");
		
		Airplane plane1 = new Airplane();
		plane1.addPilot(p);
		plane1.addPilot(p2);
		plane1.addPassenger(pass1);
		plane1.addPassenger(pass2);
		plane1.addPassenger(pass3);
		plane1.addPassenger(pass4);
		plane1.addPassenger(pass5);
		plane1.addPassenger(pass6);
		plane1.addPassenger(pass7);
		plane1.addPassenger(pass8);
		plane1.addPassenger(pass9);
		plane1.addPassenger(pass10);
		
		
		Airplane plane2 = new Airplane();
		plane2.addPilot(p);
		plane2.addPilot(p2);
		plane2.addPassenger(pass1);
		plane2.addPassenger(pass2);
		plane2.addPassenger(pass3);
		plane2.addPassenger(pass4);
		plane2.addPassenger(pass5);
		plane2.addPassenger(pass6);
		plane2.addPassenger(pass7);
		plane2.addPassenger(pass8);
		plane2.addPassenger(pass9);
		plane2.addPassenger(pass10);
	}

}
