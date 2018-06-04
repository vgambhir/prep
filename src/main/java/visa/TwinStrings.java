package visa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import util.HelperClass;
/**
 * Get list of even characters ...sort
 * Get list of odd characters ..sort
 * Test if given two strings are twins. One can move/swap between even characters and odd characters
 * @author vandana
 *
 */
public class TwinStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String arg1 = scan.nextLine().trim();
		String arg2 = scan.nextLine().trim();
		HelperClass.print(isTwin(arg1, arg2));
		scan.close();
	}

	public static String isTwin(String arg1, String arg2) {

		if (arg1.length() != arg2.length())
			return "Strings can not be twin";
		return isTwinEvenOdd(arg1, arg2);

	}

	public static String isTwinEvenOdd(String arg1, String arg2) {
		// even
		List<String> evenArg1 = getCharacters(arg1, 0);
		List<String> evenArg2 = getCharacters(arg2, 0);
		Collections.sort(evenArg1);
		Collections.sort(evenArg2);

		List<String> oddArg1 = getCharacters(arg1, 1);
		List<String> oddArg2 = getCharacters(arg2, 1);
		Collections.sort(oddArg1);
		Collections.sort(oddArg2);

		if (evenArg1.equals(evenArg2) && oddArg1.equals(oddArg2))
			return "Yes";
		else
			return "No";

	}

	public static List<String> getCharacters(String s, int start)

	{
		List<String> numberList = new ArrayList<String>();
		char[] arr = s.toCharArray();
		for (int i = start; i < arr.length; i += 2) {
			numberList.add(Character.toString(arr[i]));
		}

		return numberList;
	}

}
