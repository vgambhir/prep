package dp;

/**
 * restricts the creation of only one instance for a class
 * 
 * @author vandana
 *
 */
public class Singleton1 {

	private static Singleton1 sPattern = null;

	private Singleton1() {
	}

	public static Singleton1 getInstance() {

		if (null == sPattern) {
			sPattern = new Singleton1();

		}
		return sPattern;
	}

}
