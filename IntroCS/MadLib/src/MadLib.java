import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MadLib {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		System.out.println("What is your name?");
		String name = in.readLine();
		
		System.out.println("What is your favorite animal?");
		String animal = in.readLine();
		
		System.out.println("What is your favorite color?");
		String color = in.readLine();
		
		System.out.println("What is your favorite place to visit?");
		String place = in.readLine();
		
		
		System.out.println(name + " decided to visit " + place + " by flying in on a(n) " + color + " " + animal);
	}
}
