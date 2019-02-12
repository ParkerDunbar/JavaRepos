import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import dunbar.parker.objects.Animal;
import dunbar.parker.objects.Person;
import dunbar.parker.persistence.Database;

public class GenericTests {
	Animal genAnimal = new Animal("T", "T", "T", "T");
	Person genPerson = new Person("T", "T", "T", "T");
	
//	@Test
//	public void AnimalInsertTest() throws IOException {
//		Database<Animal> dataTest = new Database<Animal>("AnimalTest.txt", genAnimal);
//		Animal a = new Animal("Tiger", "Male", "Orange", "5");
//		Animal b = new Animal("Lion", "Male", "Red", "10");
//		Animal c = new Animal("Whale", "Female", "Blue", "16");
//		dataTest.insert(a);
//		dataTest.insert(b);
//		dataTest.insert(c);
//	}
	
//	@Test
//	public void AnimalLookupTest() throws IOException {
//		Database<Animal> dataTest = new Database<Animal>("AnimalTest.txt", genAnimal);
//		System.out.println(dataTest.lookup(1));
//	}
	
//	@Test
//	public void AnimalRemoveTest() throws IOException {
//		Database<Animal> dataTest = new Database<Animal>("AnimalTest.txt", genAnimal);
//		dataTest.remove(1);
//	}
	
	
	
//	@Test
//	public void PersonInsertTest() throws IOException {
//		Database<Person> data = new Database<Person>("PersonTest.txt", new Person());
//		Person a = new Person("Parker", "Dunbar", "test@gmail.com", "8018887777");
//		Person b = new Person("John", "Doe", "doe@aol.com", "3823441234");
//		Person c = new Person("Whats", "Hername", "whoknows@huh.com", "0001112222");
//		data.insert(a);
//		data.insert(b);
//		data.insert(c);
//	}
	
//	@Test
//	public void PersonLookupTest() throws IOException {
//		Database<Person> data = new Database<Person>("PersonTest.txt", new Person());
//		System.out.println(data.lookup(1));
//	}
	
//	@Test
//	public void PersonRemoveTest() throws IOException {
//		Database<Person> data = new Database<Person>("PersonTest.txt", new Person());
//		data.remove(1);
//	}
}
