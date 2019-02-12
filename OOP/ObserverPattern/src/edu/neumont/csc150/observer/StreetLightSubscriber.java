package edu.neumont.csc150.observer;

public interface StreetLightSubscriber {
	void lightChanged(StreetLightColor newColor);
}
