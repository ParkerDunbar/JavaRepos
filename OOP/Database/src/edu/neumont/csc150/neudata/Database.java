package edu.neumont.csc150.neudata;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class Database extends ArrayList<Person>{
	public void sortOnSsn() {
		Collections.sort(this);
	}
}
