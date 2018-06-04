package java8;

@FunctionalInterface // informative annotation to state that this interface has one abstract method
public interface MyJava8Interf {
	
	String getMyString(int x); //public 
	
	// this can be overridden by class implementing the interface
	default String getMyString2(int x) {
		return "222";
	}
	// this method is only available at interface namespace level
	static String getMyString3(int x)
	{
		return "333";
	}
	

}

class TestInterface
{
	
	public static void main(String[] args) {
		System.out.println(MyJava8Interf.getMyString3(3));
	}
	
	
}

class MyInterface implements MyJava8Interf{

	@Override
	public String getMyString(int x) {
		getMyString2(x);
		MyJava8Interf.getMyString3(3);
		return null;
	}
	
	
	

}

