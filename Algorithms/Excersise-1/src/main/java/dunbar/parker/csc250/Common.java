package dunbar.parker.csc250;

import java.util.ArrayList;
import java.util.List;

public class Common {

	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		
		ArrayList<Integer> common = findCommon(l1, l2);
		
	}

	private static ArrayList<Integer> findCommon(ArrayList l1, ArrayList l2) {
		ArrayList<Integer> common = new ArrayList<Integer>();
		for(int i=0; i<l1.size(); i++) {
			for(int j=0; i<l2.size(); i++) {
					if(l1.get(i) == l2.get(j)) {
						
					}
				}
			}
		
		return null;
	}

}