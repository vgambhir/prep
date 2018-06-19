package visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Dynamic Programming
 * @author vandana
 *
 */
public class ShortestSubarray {

	public static void main(String[] args) {
		System.out.println(getShortestSubarr(new int[] { 1, 2,9,9, 11,7 }, 18));

	}

	public static String getShortestSubarr(int[] arr, int k) {

		List<String> result = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			int maxSoFar = curr;
			if (curr == k)
				return i + "";
			for (int j = i + 1; j < arr.length; j++) {

				maxSoFar = maxSoFar + arr[j];
				if (maxSoFar == k) {
					result.add(i + " and " + j);

				}
				if (maxSoFar < k)
					continue;
				else
					break;

			}

		}

		return Arrays.toString(result.toArray());
	}

}
