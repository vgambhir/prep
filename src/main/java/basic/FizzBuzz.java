package basic;

public class FizzBuzz {

	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		fizzBuzz.printFizzBuzz(1, 50);
	}

	public boolean isMultipleOf(int x, int multipleOf) {
		return (x % multipleOf == 0);
	}

	public void printFizzBuzz(int min, int max) {
		for (int i = min; i <= max; i++) {
			if (isMultipleOf(i, 15))
				log("Fizz Buzz");
			else if (isMultipleOf(i, 3))
				log("Fizz");
			else if (isMultipleOf(i, 5))
				log("Buzz");
			else
				log(i);
		}

	}

	public void log(Object o) {
		System.out.println(o);
	}

}
