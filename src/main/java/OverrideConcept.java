
//
public class OverrideConcept {
	
	public static void foo() {System.out.println("I am in Override Concept foo");}
	public static void bar() {System.out.println("I am in Override Concept bar");}
	
	
	public static void main(String[] args) {
		OverrideConcept p = new ChildOverrideConcept();
		ChildOverrideConcept c = new ChildOverrideConcept();
		p.foo();
		c.foo();
		c.bar();
		
	}
}

class ChildOverrideConcept extends OverrideConcept{
	
	public static void foo() {System.out.println("I am in ChildOverride Concept foo");}
	//public static void bar() {System.out.println("I am in ChildOverride Concept bar");}
	
}