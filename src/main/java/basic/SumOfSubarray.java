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
public class SumOfSubarray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 5 };
		System.out.println(subArray(arr, arr.length, 5));

	}

	public static boolean subArray(int arr[], int n, int sum) {
		int currSum = 0;

		// Starting point
		for (int i = 0; i < n; i++) {
			currSum = arr[i];

			for (int j = i + 1; j <= n; j++) {
				if (currSum == sum) {
					int p = j - 1;
					System.out.println("Sum found between indexes " + i + " and " + p);
					return true;
				}
				if ((currSum > sum) || j == n)
					break;

				currSum += arr[j];

			}

		}
		System.out.println("No subarray found");
		return false;

	}

}
