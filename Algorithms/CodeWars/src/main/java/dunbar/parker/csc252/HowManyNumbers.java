package dunbar.parker.csc252;

import java.util.ArrayList;
import java.util.List;


class HowManyNumbers {

	public static List<Long> findAll(final int sumDigits, final int numDigits) {
		System.out.println();
		List<Long> list = new ArrayList<Long>();
		List<Long> finalList = new ArrayList<Long>();
		String strnum = "";
		for (int i = 0; i < numDigits; i++) {
			strnum += "9";
		}
		int num = Integer.parseInt(strnum) + 1;
		for (int i = (int) (num / 10); i < num; i++) {
			String I = "";
			I += i;
			if (!I.contains("0")) {
				char[] c = I.toCharArray();
				if (sumDigits / numDigits < ((int) (c[0]) - 48)) {
					break;
				}
				boolean good = true;
				for (int j = 0; j < numDigits - 1; j++) {
					if ((int) (c[j]) > (int) (c[j + 1])) {
						good = false;
						break;
					}
				}
				if (good) {
					int total = 0;
					for (int j = 0; j < numDigits; j++) {
						total += (int) (c[j]) - 48;
						if (total > sumDigits) {
							break;
						}
					}
					if (total == sumDigits) {
						list.add((long) i);
					}
				}
			}
		}
		if (list.size() != 0) {
			finalList.add((long) list.size());
			finalList.add(list.get(0));
			finalList.add(list.get(list.size() - 1));
		}
		return finalList;
	}
}
