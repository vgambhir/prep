import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		List<Integer> lst = new ArrayList<Integer>();
		lst.add(1);
		int[] arr = convertListToPrimIntArr(lst);
		printArr(arr);
	}

	
	
	
	
	
	
	
	
	

	/*
	 * Print String
	 */
	public static void printObject(Object o) {

		System.out.println(o.toString());

	}

	/*
	 * Print Array
	 */
	public static void printArr(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ",  ");
		}
	}

	public static int[] convertListToPrimIntArr(List<Integer> intList) {

		Integer[] r = (Integer[]) intList.toArray(new Integer[intList.size()]);
		return Arrays.stream(r).mapToInt(Integer::intValue).toArray();
	}
}
