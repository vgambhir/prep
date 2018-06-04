package basic;

/**
 * A simple solution is to consider all subarrays one by one and check the sum
 * of every subarray.Following program implements the simple solution.We run two
 * loops:the outer loop picks a starting point i and the inner loop tries all
 * subarrays starting from i.
 * 
 * @author vandana
 *
 */
public class SumOfSubarray2 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 5 };
		System.out.println(subArray(arr, arr.length, 5));

	}

	public static boolean subArray(int arr[], int n, int sum) {
		int curr_sum = arr[0];
		int start = 0;

		// Starting point
		for (int i = 0; i < n; i++) {

			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			if (curr_sum == sum) {
				return true;
			}
			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];

		}

		return false;
	}
}