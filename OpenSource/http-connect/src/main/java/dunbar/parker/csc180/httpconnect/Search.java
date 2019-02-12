package dunbar.parker.csc180.httpconnect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search {
	private static Map<String, List<Integer>> search = new HashMap<>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		boolean serializedFileExists = new File("crawler.ser").exists();
		if (serializedFileExists) {
			loadHashMap("crawler.ser");
		}

	}

	private static void loadHashMap(String filePath) throws IOException, ClassNotFoundException {
		try (FileInputStream in = new FileInputStream(filePath)) {
			try (ObjectInputStream obj = new ObjectInputStream(in)) {
				search = (Map<String, List<Integer>>) obj.readObject();
				obj.close();
				in.close();
			}
		}
	}
	

}
