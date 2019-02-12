package sorting.library;

import java.util.ArrayList;
import java.util.List;

public class Sorter<T extends Comparable<? super T>> {

	public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) == 1) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; ++i) {
			T key = arr[i];
			int j = i - 1;
			while (j >= 0 && (arr[j].compareTo(key) == 1)) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			int low = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j].compareTo(arr[low]) == -1) {
					low = j;
				}
			}
			T temp = arr[low];
			arr[low] = arr[i];
			arr[i] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
		mergeSorting(arr, 0, arr.length - 1);
	}

	public static <T extends Comparable<? super T>> void mergeSorting(T[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;

			// sort left
			mergeSorting(arr, low, mid);

			// sort right
			mergeSorting(arr, mid + 1, high);

			// merge halves
			merge(arr, low, high);
		}
	}

	public static <T extends Comparable<? super T>> void merge(T[] arr, int start, int end) {
		// find the middle
		int middle = (start + end) / 2;

		// create a temp array
		ArrayList<T> temp = new ArrayList<T>();

		// keep track of indices for both halves
		int left = start;
		int right = middle + 1;

		// while both halves have data
		while ((left <= middle) && (right <= end)) {
			// if the left half value is less than right
			if (arr[left].compareTo(arr[right]) == -1) {
				// take from left
				temp.add(arr[left]);
				left++;
			} else {
				// take from right
				temp.add(arr[right]);
				right++;
			}
		}

		// add elements from left half
		while (left <= middle) {
			temp.add(arr[left]);
			left++;
		}

		// add elements from right half
		while (right <= end) {
			temp.add(arr[right]);
			right++;
		}

		// move temp array to original array
		for (int i = start; i <= end; i++) {
			arr[i] = temp.get(i - start);
		}
	}

	// find middle
	// new array 0 -> middle
	// new array2 middle -> end
	// mergemain(new array)
	// mergemain(new array2)
	// newlist
	// if(newarray[i] > newarray2[i]
	// {
	// sort shit
	// newlist.add()
	// }

	// array.copy()

	public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
		quickMain(arr, 0, arr.length - 1);
	}

	public static <T extends Comparable<? super T>> void quickMain(T[] arr, int low, int high) {
		if (low < high) {
			int index = quickPartition(arr, low, high);
			quickMain(arr, low, index - 1);
			quickMain(arr, index + 1, high);
		}
	}

	public static <T extends Comparable<? super T>> int quickPartition(T[] arr, int low, int high) {
		T point = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j].compareTo(point) == -1 || arr[j].compareTo(point) == 0) {
				i++;
				T temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		T temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
