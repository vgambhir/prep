package misc;

public class FindSubArray {
/**
 * Find subarray with given sum
 * @param arr
 * @param givenSum
 */
	public static void subArrSum(int[] arr, int givenSum) {

		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (currSum == givenSum) {
					System.out.println("Sum found between indexes " + i + " and " + (j - 1));
					return;
				}
				if (currSum > givenSum) {
					break;
				}
				currSum += arr[j];
			}

		}
		
		System.out.println("No subArray Found");

	}
	
	public static void testsubArrSum()
	{
		FindSubArray.subArrSum(new int[] {1,4,20,3,10,5}, 33);
		
	}
	
	public static void main(String[] args) {
		testsubArrSum();
	}
	

}
