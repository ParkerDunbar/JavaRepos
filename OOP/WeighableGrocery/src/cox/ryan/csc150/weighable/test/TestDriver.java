package cox.ryan.csc150.weighable.test;

import java.util.Arrays;

import cox.ryan.csc150.weighable.Apple;
import cox.ryan.csc150.weighable.Celery;
import cox.ryan.csc150.weighable.Orange;
import cox.ryan.csc150.weighable.WeighableItem;

public class TestDriver {

	public static void main(String[] args) {
		WeighableItem[] items = new WeighableItem[3];
		//items[0] = new Apple(1, 0.50);
		items[0].printItemName();
		Apple a1 = (Apple)items[0];
		Orange o1 = (Orange)items[0];
		Celery c1 = (Celery)items[0];
		a1.getWeight();
		o1.getWeight();
		c1.getWeight();
		//WeighableItem j = new WeighableItem();
		
		//items[1] = new Orange(0.5, 0.50);
		//items[2] = new Celery(1.75, 0.10);
		Arrays.sort(items);
	}

}






