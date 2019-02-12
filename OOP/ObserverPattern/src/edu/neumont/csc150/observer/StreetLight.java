package edu.neumont.csc150.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class StreetLight implements ActionListener{
	public static final int LIGHT_DELAY = 2000;
	
	private StreetLightColor color;
	
	private Timer timer;
	
	private List<StreetLightSubscriber> subscribers = new ArrayList<>();
	
	public StreetLight() {
		this.setColor(StreetLightColor.Red);
		this.timer = new Timer(LIGHT_DELAY, this);
		this.timer.start();
	}

	public void subscribe(StreetLightSubscriber newSubscriber) {
		if(newSubscriber == null) {
			throw new IllegalArgumentException("newSubscriber cannot be null");
		}
		else {
			this.subscribers.add(newSubscriber);
		}
	}
	/**
	 * @return the color
	 */
	public StreetLightColor getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(StreetLightColor color) {
		if(color == null) {
			throw new IllegalArgumentException("color cannot be null");
		}
		this.color = color;
		
		for(StreetLightSubscriber subscriber : this.subscribers) {
			subscriber.lightChanged(color);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(this.getColor()) {
		case Red:
			this.setColor(StreetLightColor.Green);
			break;
		case Green:
			this.setColor(StreetLightColor.Yellow);
			break;
		case Yellow:
			this.setColor(StreetLightColor.Red);
			break;
		default:
			throw new IllegalArgumentException("unrecognized light color: " + this.getColor());
		}


			
		
	}
}
