package dunbar.parker.csc180.personcollection;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Collection {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		#1
		List<Person> people = PersonGenerator.generateRandomPeople(10000);
		
//		#2
		List<Person> filteredPeople = people.stream()
				.filter(p -> (p.getFirstname().charAt(0) == 'A'
				|| p.getFirstname().charAt(0) == 'R'
				|| p.getFirstname().charAt(0) == 'Q')
				&& (p.getLastname().charAt(0) == 'S'
				|| p.getLastname().charAt(0) == 'C'))
				.collect(Collectors.toList());
		
//		#3
		filteredPeople.stream().filter(p -> p.getSsn() % 2 == 0).forEach(p -> System.out.println(p));
		
//		#4
		List<String> shortenedPeople = people.stream()
				.filter(p -> p.getFirstname().length() >= 4 && p.getFirstname().length() <= 7)
				.map(p -> p.getFirstname())
				.collect(Collectors.toList());
		
//		#5
		shortenedPeople.stream().forEach(p -> System.out.println(p));
		
//		#6
		long largestSsn = (long) people.stream().mapToLong(p -> p.getSsn()).max().orElse(-1);
		
//		#7
//		System.out.println(largestSsn);
		
//		#8
		int average = (int) people.stream().mapToInt(p -> p.getAge()).average().orElse(-1);
		
//		#9
		if(average == -1) {
			System.out.println("Not valid!");
		}
		else {
//			System.out.println(average);
		}
		
//		#10
		FileWriter file = new FileWriter("my.csv");
		BufferedWriter buffer = new BufferedWriter(file);
		List<Person> csv = people.stream().filter(p -> p.getLastname().length() >= 4)
				.filter(p -> p.getAge() > average)
				.collect(Collectors.toList());
		buffer.write(csv.toString());
		buffer.close();
	}
	
	

}
