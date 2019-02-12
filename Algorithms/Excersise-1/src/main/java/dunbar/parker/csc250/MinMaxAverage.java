package dunbar.parker.csc250;

public class MinMaxAverage {

	public static void main(String[] args) {
		int[] array = new int[] { 10, 43, 72, 32, 90, 3, 77, 54 };
		int min = Integer.MAX_VALUE;
		int max = 0;
		int sum = 0;

		for (int i = 0; i < array.length - 1; i++) {
			sum += array[i];
			if (array[i] < array[i + 1]) {
				if (array[i] < min) {
					min = array[i];
				}
			} else {
				if (array[i + 1] < min) {
					min = array[i + 1];
				}
			}
			if (array[i] > array[i + 1]) {
				if (array[i] > max) {
					max = array[i + 1];
				}
			} else {
				if (array[i + 1] > max) {
					max = array[i + 1];
				}
			}
			if(i == array.length - 2) {
				sum += array[i + 1];
			}

		}
		double average = sum / array.length;
		System.out.println(min);
		System.out.println(max);
		System.out.println(average);

	}

}
