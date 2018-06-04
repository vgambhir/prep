package coll;

import java.util.Iterator;

import org.junit.Test;

public class MyTestCollection {

	@Test
	public void test() {
		MyCollection m = new MyCollection();
		
		Iterator iter1 = m.iterator();
		Iterator iter2 = m.iterator();
		
		m.add("A");
		m.add("B");
		System.out.println(m.getSize());
		while(m.hasNext())
			{
			  System.out.println(m.next());
			}
		
		
	}

}
