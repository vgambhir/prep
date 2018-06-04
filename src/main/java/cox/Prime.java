package cox;
/**
 * Prime Number starts with 2. 1 is not a prime number
 * Any number that has 2 factors -> 1 and number itself
 * @author vandana
 *
 */
public class Prime {

	public void checkPrime(int... n) {
		StringBuilder b = new StringBuilder();
		for (int x = 0; x < n.length; x++) {

			int temp = n[x];
			if (temp <=1)
				continue;
			boolean isPrime = true;

			for (int i = 2; i < temp; i++) {
				if (temp % i == 0) {
					isPrime = false;
				}

			}
			if (isPrime)
				b.append(temp + " ");

		}

		System.out.println(b.toString());
	}

}