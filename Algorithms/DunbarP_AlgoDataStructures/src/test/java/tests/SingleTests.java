package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import algo.data.structures.*;

public class SingleTests {

	@Test
	public void SLL_Methods() {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
		
		System.out.println(list.search(3));

//		System.out.println(list.get(0));
//		System.out.println(list.count());
//		list.removeLast();
//		System.out.println(list.get(0));
//		System.out.println(list.count());
//		list.removeLast();
//		System.out.println(list.get(0));
//		System.out.println(list.count());
//		list.removeLast();
//		System.out.println(list.get(0));
//		System.out.println(list.count());
	}
	
	@Test
	public void SLL_EmptyList() {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		Integer expectedCount = 0;
		Integer actualCount = list.count();
		String expectedString = "";
		String actualString = list.toString();
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedString, actualString);
	}
}
