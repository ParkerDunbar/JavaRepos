package edu.neumont.csc110.d.AsciiPyramid;

public class Pyramid {

	public static void main(String[] args) {
		final int HEIGHT = 3;
		//final int WIDTH = 3;
		
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
