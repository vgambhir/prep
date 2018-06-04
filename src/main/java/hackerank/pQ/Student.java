package hackerank.pQ;

import java.util.Comparator;

public class Student {

	int id;
	String name;
	double cgpa;

	public Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;

	}

	public int getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public double getCGPA() {
		return this.cgpa;
	}

}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student st1, Student st2) {
		if (st1.cgpa < st2.cgpa) {
			return 1;
		} else if (st1.cgpa > st2.cgpa) {
			return -1;
		} else {

			int compName = st1.name.compareTo(st2.name);
			if (compName != 0) {
				return compName;
			} else {
				return (int) (st1.id - st2.id);

			}

		}

	}
}