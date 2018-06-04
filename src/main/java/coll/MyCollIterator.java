package coll;

import java.util.Iterator;

public class MyCollIterator implements Iterator {
	MyCollection myColl;
	int index=-1;
	
	MyCollIterator(MyCollection coll){
		myColl=coll;		
	}

	
	@Override
	public boolean hasNext() {
		
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

}
