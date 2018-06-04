package dp;

/**
 * restricts the creation of only one instance for a class
 * 
 * @author vandana
 *
 */
public class Singleton {
    // restrict construction
	private Singleton() {
	}

	public static Singleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	// Private Static inner class only accessible by outer class
	private static class SingletonHelper{
		private static final Singleton INSTANCE = new Singleton();		
	}

}
