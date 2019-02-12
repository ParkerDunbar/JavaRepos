package edu.neumont.dbt230.a2.changetolastnamefirstinitial;

import java.util.HashMap;

import edu.neumont.dbt230.Employee;

public class A2Start {

	public static void main(String[] args) {
		
		System.out.println("Starting....");
		
		//EmployeeTextFileDataAccess text = new EmployeeTextFileDataAccess();
		
		//question 1
		//text.q1_printEmployeesText("C:\\Users\\Parker Dunbar\\people\\simple\\");
		
		//question 2
		//text.q2_printEmployees("C:\\Users\\Parker Dunbar\\people\\simple\\");
		
		//question 3 ** remember to change the path to long serialized!
		//text.q2_printEmployees("C:\\Users\\Parker Dunbar\\people\\long serialized\\");
		
		//question 5
		//EmployeesSerializedDataAccess serialized = new EmployeesSerializedDataAccess();
		//serialized.q5a_printEmployeesText("C:\\Users\\Parker Dunbar\\people\\long serialized\\");
		

//		EmployeeCollectionDataAccess collection = new EmployeeCollectionDataAccess();
//		HashMap<Integer, Employee> h = collection.writeEmployeesToHashMap("C:\\Users\\Parker Dunbar\\people\\long serialized\\");
//		collection.saveEmployeesHashMap(h, "C:\\Users\\Parker Dunbar\\people\\empcollection.ser");
//		System.out.println(h.get(1));
		
		long startTime = System.nanoTime();
//		EmployeeTextFileDataAccess text = new EmployeeTextFileDataAccess();
//		text.q2_printEmployees("C:\\Users\\Parker Dunbar\\people\\large\\");
		EmployeesSerializedDataAccess serialized = new EmployeesSerializedDataAccess();
		serialized.q5a_printEmployeesText("C:\\Users\\Parker Dunbar\\people\\large serialized\\");
		long endTime = System.nanoTime();
		System.out.println("Done.");
		System.out.println("Took "+((endTime - startTime)/1000000.0) + " ms"); 
	}

}
