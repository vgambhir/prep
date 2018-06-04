package basic;

import java.util.Arrays;

public class ArrayManipulation {

	/**
	 * reverse a given array by swapping elements on both sides of middle
	 * 
	 * @param a
	 * @return
	 */
	static int[] reverseArray(int[] a) {

		for (int i = 0; i < (a.length / 2); i++) {
			int temp = a[i];
			a[i] = a[(a.length - 1) - i];
			a[(a.length - 1) - i] = temp;

		}
		return a;
	}

	public static void main(String[] args) {
		//int[] res = reverseArray(new int[] { 1, 4, 3, 2 });
		//System.out.println(Arrays.toString(res));
		int[] res = arrayShift(new int[] { 1,2 },1);
		System.out.println(Arrays.toString(res));
	}

	static int[] arrayShift(int[] a, int shift) {

		int x = 0;
		while (x < shift) {
			int temp = a[0];

			for (int i = 0; i < (a.length - 1); i++) {
				a[i] = a[i + 1];
			}
			a[a.length - 1] = temp;
			x++;
		}
		
		return a;
	}

}
