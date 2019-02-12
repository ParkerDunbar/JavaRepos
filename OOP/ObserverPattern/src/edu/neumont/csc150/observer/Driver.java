package edu.neumont.csc150.observer;

public class Driver implements StreetLightSubscriber {

	@Override
	public void lightChanged(StreetLightColor newColor) {
		switch(newColor) {
		case Red:
			System.out.println("Light is red, I must stop!");
			break;
		case Green:
			System.out.println("Light is green, I can go now!");
			break;
		case Yellow:
			System.out.println("Light is yellow, check for cops!");
			break;
		}
		
	}

}
