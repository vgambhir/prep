package hackerank.pQ;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Priorities {

	//Queue<Student> q = new PriorityQueue<Student>(new StudentComparator());
	PriorityQueue<Student> q = new PriorityQueue<Student>(
		    Comparator.comparing(Student::getCGPA).reversed() //descending
		    .thenComparing(Student::getName) // ascending
		    .thenComparing(Student::getID) //ascending
		    );

	List<Student> getStudents(List<String> events) {
		
		for(String s: events)
		{
		parseEvent(s);
		}
		
		return new LinkedList<Student>(q);
	}

	public void parseEvent(String eventStr) {

		String[] arr = eventStr.split(" ");
		if (arr[0].equalsIgnoreCase("ENTER")) {
			q.add(new Student(Integer.parseInt(arr[3]), arr[1], Double.parseDouble(arr[2])));
		}
		else if (arr[0].equalsIgnoreCase("SERVED"))
		{
			q.poll();
		}
	}

}


