package coll;

import java.util.Iterator;
/**
 * The iterator implementation in Java is just an inner class that implements the iterator interface.
 * In order to be able to use it in a for loop construction, the iterable interface must be implemented.
 * @author vandana
 *
 */
public class DataSetIterable implements Iterable<String>{
	
	private String data[] = {"1", "2", "3", "4"};

	@Override
	public Iterator<String> iterator() {
		
		 return new DataSetIterator();
	}

	
	private class DataSetIterator implements Iterator<String>
	{

		private int curr = 0;
		@Override
		public boolean hasNext() {
			if (curr < data.length)
                return true;
            else
                return false;
		}

		@Override
		public String next() {
			if (this.hasNext())
                return data[curr++];
            else
                return null;
		}
		
	}
	
	public static void main(String[] args) {
		DataSetIterable dataSet = new DataSetIterable();
        Iterator<String> iterator = dataSet.iterator();
        while (iterator.hasNext()) {
            String nextValue = iterator.next();
            System.out.println("The next value with Iterator is: " + nextValue);
        }
 
        for (String nextValue : dataSet) {
            System.out.println("The next value with the for Loop is: " + nextValue);
        }
    }
	
	
	
}
