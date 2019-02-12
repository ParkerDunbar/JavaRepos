package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algo.data.structures.DoubleLinkedList;

public class DoubleTests {

	@Test
	public void test() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		System.out.println(list.search(3));
	}

}
