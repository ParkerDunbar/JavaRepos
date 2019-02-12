package edu.neumont.csc110.d.gradearray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GradeArray {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
		
		String[] nameArray = new String[6];
		String[] gradeArray = new String[6];
		
		for(int i=1; i<6; i++) {
			System.out.println("Please enter a name for student #" + i);
			nameArray[i] = input.readLine();
			System.out.println("Please enter a grade for student #" + i);
			gradeArray[i] = input.readLine();
		}
		for(int i=1; i<6; i++) {
			int studentGrade = Integer.parseInt(gradeArray[i]);
			studentGrades(studentGrade);
			System.out.println(studentGrade);
		}
		
		for(int j=1; j<6; j++) {
			System.out.println(nameArray[j]);
			System.out.println(gradeArray[j]);
		}
		
		System.out.println("Whose grade would you like to see?");
		

		}
	public static int studentGrades(int grade) {
		return grade;
	}
	
}
