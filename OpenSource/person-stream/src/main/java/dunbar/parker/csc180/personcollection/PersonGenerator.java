package dunbar.parker.csc180.personcollection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PersonGenerator {
	private static List<String> firstnames = new ArrayList<String>();
	private static List<String> lastnames = new ArrayList<String>();
	private static Random generator = new Random();
	
	public static void createFirstNames() throws IOException {
		try (BufferedReader read = new BufferedReader(new FileReader("firstnames.txt"))) {
		    String firstname;
		    while ((firstname = read.readLine()) != null) {
		       firstnames.add(firstname);
		    }
		}
	}
	
	public static void createLastNames() throws FileNotFoundException, IOException {
		try (BufferedReader read = new BufferedReader(new FileReader("lastnames.txt"))) {
		    String lastname;
		    while ((lastname = read.readLine()) != null) {
		       lastnames.add(lastname);
		    }
		}
	}

	public static List<Person> generateRandomPeople(int count) throws IOException {
		createFirstNames();
		createLastNames();
		List<Person> people = new ArrayList<Person>();
		for(int i=0;i<count;i++) {
			people.add(generateRandomPerson());
		}
		return people;
	}
	
	public static Person generateRandomPerson() {
		String firstname = firstnames.get(generator.nextInt(firstnames.size()));
		String lastname = lastnames.get(generator.nextInt(lastnames.size()));
		int age = generator.nextInt(151);
		String ssnString = "";
		ssnString += generator.nextInt(9) + 1;
		for(int i=0;i<8;i++) {
			ssnString += generator.nextInt(10);
		}
		int ssn = Integer.parseInt(ssnString);
		return new Person(firstname, lastname, age, ssn);
	}
}
