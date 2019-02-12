package edu.neumont.csc150.airplace;

import java.util.ArrayList;

public class Airplane {
	static final int NUM_PILOTS = 2;
	
	private double airSpeed;
	
	private Pilot[] pilots = new Pilot[NUM_PILOTS];
	
	private ArrayList<Passenger> passengers = new ArrayList<>(); 
	
	private int nextPilotIndex = 0;
	
	public void addPilot(Pilot pilot) {
		if(nextPilotIndex == pilots.length) {
			throw new IllegalArgumentException("Plane is full");
		}
		pilots[nextPilotIndex] = pilot;
		nextPilotIndex++;
	}
	
	public void addPassenger(Passenger passenger) {
		this.getPassengers().add(passenger);
	}
	
	
	/**
	 * @return the airSpeed
	 */
	public double getAirSpeed() {
		return airSpeed;
	}

	/**
	 * @param airSpeed the airSpeed to set
	 */
	public void setAirSpeed(double airSpeed) {
		this.airSpeed = airSpeed;
	}

	/**
	 * @return the pilots
	 */
	public Pilot[] getPilots() {
		return pilots;
	}

	/**
	 * @param pilots the pilots to set
	 */
	public void setPilots(Pilot[] pilots) {
		this.pilots = pilots;
	}

	/**
	 * @return the passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}


}
