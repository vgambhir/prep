package visa;

import util.HelperClass;

/**
 * Deep clone vs shallow clone A shallow clone will have their own copy for
 * primitive types and will share references to Object types. Class needs to
 * implement Cloneable interface and override protected method public Object
 * clone() throws CloneNotSupportedException Shallow copy is method of copying
 * an object and is followed by default in cloning. In this method the fields of
 * an old object X are copied to the new object Y. While copying the object type
 * field the reference is copied to Y i.e object Y will point to same location
 * as pointed out by X. If the field value is a primitive type it copies the
 * value of the primitive type. Therefore, any changes made in referenced
 * objects in object X or Y will be reflected in other object.
 * 
 * @author vandana
 *
 */
public class Human implements Cloneable {

	String name;

	public Human(String n) {
		this.name = n;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "name: " + name;

	}

	public static void main(String[] args) {
		Human h1 = new Human("V");
		HelperClass.print(h1);
		try {
			Human h2 = (Human) h1.clone();
			HelperClass.print(h2);

			HelperClass.print(h2);

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
