package cox;

import java.util.Arrays;

public class RotateElement {

	public static char[] rotateElements(char[] arr, int k) {
		// first half before k
		reverseArr(0, arr.length - k - 1, arr);
		// second half after k
		reverseArr(arr.length - k, arr.length-1, arr);
		// reverse whole string
		reverseArr(0, arr.length - 1, arr);
		return arr;

	}

	public static void reverseArr(int start, int end, char[] arr) {
		for (int i = start, j = end; i <= (start+end) / 2; i++, j--) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

		}

	}

	public static void main(String[] args) {

		//rotateElements(new char[] { 'A', 'B', 'C', 'D' }, 2);
		char[] test = new char[] { 'A', 'B', 'C', 'D' };
		//char[] res = reverseArr(0,test.length - 2 - 1, test);
		//char[] res = reverseArr(test.length - 2 ,test.length-1, test);
		//char[] res = rotateElements(test,2);
		rotateElements(test,2);
		System.out.println(Arrays.toString(test));
		

	}

}
