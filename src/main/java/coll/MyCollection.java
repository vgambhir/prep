package coll;

import java.util.Iterator;



public class MyCollection implements Iterator<String>, Iterable<String>{

	private String[] arr = new String[5]; //default to null
	private int idx = -1;
	private int curr = -1;
	
	@Override
	public Iterator iterator(){
		return new MyCollIterator(this);
	}

	@Override
	public boolean hasNext() {
		if (curr < idx)
			return true;
		return false;
	}

	@Override
	public String next() {

		if (hasNext()) {
			curr++;
			return arr[curr];

		} else
			throw new RuntimeException("NoSuchElementException");

	}

	public void add(String str) {
		if (null == str) {
			throw new RuntimeException("Can not add null");
		}
		idx ++;
		System.out.println("value of count:"+ idx);
		arr[idx] = str;

	}

	public int getSize() {
		return idx + 1;

	}

	

}
