package basic;
/**
 * Modulus 10 is used to get the last digit
 * Division is used to remove the last digit
 * Multiplication is internal addition
 * Number 9/10 = 0
 * it just gets digit by digit by using remainder operator and reduce number by 1 digit after dividing it by 10.
 *
 * actually armstrong number is a that number whose sum of (each digit to the power of no of digits present in that number)is equal
 * to that number,
 * then we can say it is an armstrong number. so 1^4+6^4+3^4+4^4=1634 so 1634 is an armstrong number.
 *
 * @author vandana
 *
 */
public class ArmStrongNumber {

	public static void main(String[] args) {
		ArmStrongNumber armStrong = new ArmStrongNumber();
		armStrong.log(armStrong.printArmStrong(371));
	}

	public boolean isNumberOfDigitsValid(int x, int valid) {

		return Integer.toString(x).length() == valid;

	}

	public String printArmStrong(int val) {
		if (!isNumberOfDigitsValid(val, 3))
			return "Number provided is not a 3 digit number:" + val;

		int originalNumber = val;
		int currNumber = val;

		int result = 0;

		while (currNumber != 0) {
			int remainder = currNumber % 10;
			result = result + (remainder * remainder * remainder);
			currNumber = currNumber / 10;
			
		}

		if (originalNumber == result)
			return "Number provided is an armstrong:" + val;

		return "Number provided is not armstrong:" + val;

	}

	public void log(Object o) {
		System.out.println(o);
	}

}
