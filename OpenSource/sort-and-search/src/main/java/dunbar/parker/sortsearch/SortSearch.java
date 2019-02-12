package dunbar.parker.sortsearch;


public class SortSearch {
	// Bubble
	public double[] sortListBubble(double list[], boolean asc) {
		double temp = 0;
		for (int i = 0; i < list.length; i++) {
			for (int j = 1; j < list.length - i; j++) {
				if (list[j - 1] > list[j]) {
					temp = list[j - 1];
					list[j - 1] = list[j];
					list[j] = temp;
				}
			}
		}
		if (asc == false) {
			for (int i = 0; i < list.length / 2; i++) {
				temp = list[i];
				list[i] = list[list.length - i - 1];
				list[list.length - i - 1] = temp;
			}
		}

		return list;
	}

	// Selection
	public double[] sortListSelection(double list[], boolean asc) {
		for (int i = 0; i < list.length - 1; i++) {
			int temp = i;
			for (int j = i + 1; j < list.length; j++)
				if (list[j] < list[temp]) {
					temp = j;
				}

			double less = list[temp];
			list[temp] = list[i];
			list[i] = less;
		}
		
		if (asc == false) {
			for (int i = 0; i < list.length / 2; i++) {
				double temp = list[i];
				list[i] = list[list.length - i - 1];
				list[list.length - i - 1] = temp;
			}
		}
		return list;
	}

	// Linear
	public int linearSearch(double list[], double value) {
		int index = -1;
		for(int i = 0; i < list.length; i++) {
			if(list[i] == value) {
				index = i;
			}
		}
		return index;
	}

	// Binary
	public int binarySearch(double list[], double value) {
		list = sortListBubble(list, true);
		double low = 0;
		double high = list.length - 1;
		while(low <= high) {
			int mid = (int) ((low + high) / 2);
			
			if(list[mid] == value) {
				return mid;
			}
			if(value < list[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
