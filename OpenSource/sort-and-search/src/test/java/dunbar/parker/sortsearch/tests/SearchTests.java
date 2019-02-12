package dunbar.parker.sortsearch.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dunbar.parker.sortsearch.SortSearch;

public class SearchTests {
	public static class LinearTests {
		@Test
		public void searchLinearTestPositive() {
			SortSearch search = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			int index = search.linearSearch(list, list[3]);
			assertTrue(list[index] > 0);	
		}
		@Test
		public void searchLinearTestNegative() {
			SortSearch search = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			int index = search.linearSearch(list, list[4]);
			assertTrue(list[index] < 0);
		}
		@Test
		public void searchLinearTestNull() {
			SortSearch search = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			int index = search.linearSearch(list, 400.0);
			assertEquals(-1, index, 0);
		}
	}
	
	public static class BinaryTests {
		@Test
		public void searchBinaryTestPositive() {
			SortSearch search = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			double sorted[] = {-7.0, 2.0, 9.0, 11.0, 27.0, 67.0, 100.0, 144.0 };
			int index = search.binarySearch(list, sorted[7]);
			assertTrue(sorted[index] > 0);
		}
		@Test
		public void searchBinaryTestNegative() {
			SortSearch search = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			double sorted[] = {-7.0, 2.0, 9.0, 11.0, 27.0, 67.0, 100.0, 144.0 };
			int index = search.binarySearch(list, sorted[0]);
			assertTrue(sorted[index] < 0);
		}
		@Test
		public void searchBinaryTestNull() {
			SortSearch search = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			int index = search.binarySearch(list, 400);
			assertEquals(-1, index, 0);
		}
	}
}

