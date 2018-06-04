package misc;

public class DataManip {

	/***
	 * Also called Kadane's algorithm Given an array of positive and-ve numbers,
	 * find maximum contiguous sum [2,-10,8] -> 8
	 * Will not work for all -negative numbers
	 * Time Complexity O(n) (order of n)
	 ***/

	public static int findMaxContiguous(int[] arr) {
		int max = 0, maxSoFar = 0;
		for (int i = 0; i < arr.length; i++) {
			// running addition
			maxSoFar += arr[i];
			if (maxSoFar < 0)
				maxSoFar = 0;
			if (max < maxSoFar)
				max = maxSoFar;
		}
		System.out.println("Max =" + max);
		return max;
	}
	
	/***
	 * Also called Kadane's algorithm Given an array of positive and-ve numbers,
	 * find maximum contiguous sum [2,-10,8] -> 8
	 * Will not work for all -negative numbers
	 * Minor optimization 
	 ***/

	public static int findMaxContiguousBetter(int[] arr) {
		int max = 0, maxSoFar = 0;
		for (int i = 0; i < arr.length; i++) {
			// running addition
			maxSoFar += arr[i];
			if (maxSoFar < 0)
				maxSoFar = 0;
			else if (max < maxSoFar)
				max = maxSoFar;
		}
		System.out.println("Max =" + max);
		return max;
	}
	
	/***
	 * Also called Kadane's algorithm Given an array of positive and-ve numbers,
	 * find maximum contiguous sum [2,-10,8] -> 8
	 * Will not work for all -negative numbers
	 ***/

	public static int findMaxContiguousWithNegativeNumbers(int[] arr) {
		int max = 0;
		int maxSoFar = 0;
		for (int i = 0; i < arr.length; i++) {
			maxSoFar = Math.max(arr[i],maxSoFar+arr[i]);
			max = Math.max(max,maxSoFar);
		}
		System.out.println("Max =" + max);
		return max;
	}
	

	public static void testFindMaxContiguous() {
		System.out.println(findMaxContiguousWithNegativeNumbers(new int[] { 20,-50,10,-25 }));
		
	}

	public static void main(String[] args) {
		DataManip.testFindMaxContiguous();
	}

}
