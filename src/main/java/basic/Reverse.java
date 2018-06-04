package basic;

public class Reverse {

	public static void main(String[] args) {

		int arg = 25;
		Reverse r = new Reverse();
		
		r.log(r.reverseNumberC(arg));
		
//		r.log(r.reverseNumberA(arg));
//		r.log(r.reverseNumberB(arg));
//		r.log(r.reverseNumberC(arg));
//		r.log(r.reverseNumberD(arg));
	}

	public String reverseNumberA(int arg) {

		String str = Integer.toString(arg);
		char[] cArr = str.toCharArray();
		String result = "";

		for (int i = 0; i < cArr.length; i++)
			result = cArr[i] + result;

		return result;

	}

	public String reverseNumberB(int arg) {

		String str = Integer.toString(arg);
		char[] cArr = str.toCharArray();
		String result = "";

		for (int i = cArr.length - 1; i >= 0; i--)
			result += cArr[i];

		return result;

	}

	public String reverseNumberC(int arg) {

		String result = "";

		int myArg = arg;

		do {
			int currDigit = myArg % 10;
			result += currDigit;
			myArg = myArg / 10;

		} while (myArg > 0);

		return result;

	}

	public int reverseNumberD(int number) {

		int result = 0;
		int currDigit = 0;

		do {
			currDigit = number % 10;
			result = result * 10 + currDigit;
			number = number / 10;

		}while (number > 0);

		return result;

	}

	public void log(Object o) {
		System.out.println(o);
	}

}
