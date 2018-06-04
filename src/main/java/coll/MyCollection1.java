package coll;

import java.util.Iterator;



public class MyCollection1 {//implements Iterator<String>, Iterable<String>{

//	private String[] arr = new String[5]; //default to null
//	private int idx = -1;
//	private int curr = -1;
//
//	@Override
//	public boolean hasNext() {
//		if (curr < idx && )
//			return true;
//		return false;
//	}
//	
//	
//	public int hasNonNull()
//	{
//		
//		for (int i = curr ; curr < idx; i++)
//		{
//			
//			if(arr[i] != null)
//			{
//		}
//		
//		
//		
//	}
//
//	@Override
//	public String next() {
//
//		if (hasNext()) {
//			curr++;
//			return arr[curr];
//
//		} else
//			throw new RuntimeException("NoSuchElementException");
//
//	}
//
//	public void add(String str) {
//		if (null == str) {
//			throw new RuntimeException("Can not add null");
//		}
//		idx ++;
//		System.out.println("value of count:"+ idx);
//		arr[idx] = str;
//
//	}
//	
//	@Override
//	public void remove() {
//
//		if (hasNext()) {
//			curr++;
//			return arr[curr];
//
//		} else
//			throw new RuntimeException("NoSuchElementException");
//
//	}
//	
//
//	public int getSize() {
//		return idx + 1;
//
//	}
//
//	@Override
//	public Iterator<String> iterator() {
//		return this;
//	}

}
