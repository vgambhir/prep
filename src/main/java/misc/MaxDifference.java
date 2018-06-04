package misc;

import util.HelperClass;

public class MaxDifference {

	public static int getMaxDifferenceNotEfficient(int[] arr) {

		int max = 0;

		for (int i = arr.length - 1; i >= 0; i--) {
			int sell = arr[i];
			for (int x = 0; x < i; x++) {
				int buy = arr[x];
				if (buy > sell)
					continue;
				else {
					int diff = sell - buy;
					if (diff > max) {
						max = diff;
					}

				}

			}

		}

		return max;

	}
	/**
	 * Maximum difference between two elements such that larger element appears
	 * after the smaller number Space Complexity only
	 * O(1) Time Complexity O(n) Auxiliary Space O(1)
	 * 
	 * @param arr
	 * @return
	 */
	public static int getMaxDifference(int[] arr) {

		int maxDiff = 0, cummulativeDiffSoFar = 0;
		for (int i = 1; i < arr.length; i++) {
			cummulativeDiffSoFar += arr[i] - arr[i - 1];
			if (cummulativeDiffSoFar < 0)
				cummulativeDiffSoFar = 0;

			if (maxDiff < cummulativeDiffSoFar)
				maxDiff = cummulativeDiffSoFar;
		}
		return maxDiff;
	}

	public static void main(String args[]) {
		HelperClass.print(MaxDifference.getMaxDifference(new int[] { 2, 3, 10, 6, 4, 8, 1 }));
	}

}
