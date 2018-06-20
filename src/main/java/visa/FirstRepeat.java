package visa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import util.HelperClass;

/**
 * Find the first repeated word in the sentence.
 * 
 * @author vandana
 *
 */
public class FirstRepeat {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		HelperClass.print(FirstRepeat.firstRepeated(line));
		sc.close();

	}

	public static String firstRepeated(String s) {

		String[] arr = s.trim().split("[ ,:;.-]");
		Set<String> strSet = new HashSet<String>();

		for (int i = 0; i < arr.length; i++) {
			if (strSet.contains(arr[i].trim())) {
				return arr[i].trim();
			}

			else
				strSet.add(arr[i].trim());

		}
		return "";
	}

}
