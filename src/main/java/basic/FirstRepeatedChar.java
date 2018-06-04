package basic;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {

	public static void main(String[] args) {
		System.out.println(findRepeatedChar("Helop"));

	}

	public static char findRepeatedChar(String x) {
		char[] cArr = x.toCharArray();
		Set<Character> cSet = new HashSet<Character>();

		for (int i = 0; i < cArr.length; i++) {
			if (!cSet.add(cArr[i]))
				return cArr[i];
		}

		return '\0';
	}

}
