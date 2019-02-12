package dunbar.parker.csc252;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MazeSolver {
	public static Map<String, Node> nodes = new HashMap<String, Node>();
	public static Node start;
	public static Node end;
	public static boolean endOfFile = false;

	public static void main(String[] args) throws IOException {
		String filePath = getValidFilePath();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
//		while(!endOfFile) {
		getNodesAndConnections(br);
//		}
		
	}

	private static void getNodesAndConnections(BufferedReader br) throws IOException {
		//Get all nodes
		String unseparatedNodes = br.readLine();
		while(unseparatedNodes == null || unseparatedNodes.length() == 0) {
			unseparatedNodes = br.readLine();
		}
		System.out.println("Nodes: " + unseparatedNodes);
		String[] separatedNodes = unseparatedNodes.split(",");
		//Get start and end node elements
		String startEnd = br.readLine();
		String startString = startEnd.substring(0, 1);
		String endString = startEnd.substring(2, 3);
		
		for(String node : separatedNodes) {
			nodes.put(node, new Node(node));			
			//Set start node
			if(node.equals(startString)) {
				start = nodes.get(node);
			}
			//Set end node
			if(node.equals(endString)) {
				end = nodes.get(node);
			}
		}
		String connections = br.readLine();
		while(!connections.contains("//")) {
			String[] splitConns = connections.split(",");			
			for(int i = 1; i < splitConns.length; i ++) {
				nodes.get(splitConns[0]).connections.add(nodes.get(splitConns[i]));
			}
			connections = br.readLine();
		}
		br.readLine();
	}

	private static String getValidFilePath() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean notValid = true;
		String filePath = "";
		while (notValid) {
			// C:\Users\Parker Dunbar\Downloads\TestMazes.txt
			System.out.println("Please enter a valid file path:");
			filePath = reader.readLine();
			File input = new File(filePath);
			if (input.exists() && !input.isDirectory()) {
				notValid = false;
			} else {
				System.out.println("Not a valid file path.");
			}
		}
		return filePath;
	}
}
