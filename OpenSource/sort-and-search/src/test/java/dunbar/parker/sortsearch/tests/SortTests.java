package dunbar.parker.sortsearch.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dunbar.parker.sortsearch.SortSearch;

public class SortTests {
	public static class BubbleTests {
		@Test
		public void sortBubbleTestEmpty() {
			SortSearch sort = new SortSearch();
			double list[] = {  };
			sort.sortListBubble(list, true);
			assertEquals(0, list.length, 0);
		}
		@Test
		public void sortBubbleTestAsc() {
			SortSearch sort = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			double sorted[] = {-7.0, 2.0, 9.0, 11.0, 27.0, 67.0, 100.0, 144.0 };
			sort.sortListBubble(list, true);
			assertArrayEquals(sorted, list, 0);
		}
		@Test
		public void sortBubbleTestDsc() {
			SortSearch sort = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			double sorted[] = {144.0, 100.0, 67.0, 27.0, 11.0, 9.0, 2.0, -7.0};
			sort.sortListBubble(list, false);
			assertArrayEquals(sorted, list, 0);
		}
	}
	
	public static class SelectionTests {
		@Test
		public void sortSelectionTestEmpty() {
			SortSearch sort = new SortSearch();
			double list[] = {  };
			sort.sortListSelection(list, true);
			assertEquals(0, list.length, 0);
		}
		@Test
		public void sortSelectionTestAsc() {
			SortSearch sort = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			double sorted[] = {-7.0, 2.0, 9.0, 11.0, 27.0, 67.0, 100.0, 144.0 };
			list = sort.sortListSelection(list, true);
			assertArrayEquals(sorted, list, 0);
		}
		@Test
		public void sortSelectionTestDsc() {
			SortSearch sort = new SortSearch();
			double list[] = { 67.0, 2.0, 100.0, 11.0, -7.0, 27.0, 9.0, 144.0 };
			double sorted[] = {144.0, 100.0, 67.0, 27.0, 11.0, 9.0, 2.0, -7.0};
			list = sort.sortListSelection(list, false);
			assertArrayEquals(sorted, list, 0);
		}
	}
}
