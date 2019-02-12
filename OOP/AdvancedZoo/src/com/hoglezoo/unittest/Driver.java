package com.hoglezoo.unittest;

import com.hoglezoo.animals.Animal;
import com.hoglezoo.animals.Birds;
import com.hoglezoo.animals.Bugs;
import com.hoglezoo.animals.JungleCats;
import com.hoglezoo.animals.Reptiles;

public class Driver {

	public static void main(String[] args) {
		
		Animal[] animals = new Animal[10];
		animals[0] = new Birds("Blue Jay", "Blue", 3.5);
		animals[1] = new Birds("Robin", "Red", 4.2);
		animals[2] = new Birds("Hawk", "Brown", 5.3);
		animals[3] = new Bugs("Black Widow", "Black", 8);
		animals[4] = new Bugs("Grasshopper", "Green", 6);
		animals[5] = new JungleCats("Lion", "Tan", 50);
		animals[6] = new JungleCats("Tiger", "Orange", 70);
		animals[7] = new Reptiles("Python", "Green", 5603);
		animals[8] = new Reptiles("Aligator", "Green", 79524);
		animals[9] = new Reptiles("Crocodile", "Green", 34324);
		
	}

}
