package jintefaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 *
 * Note that if an anonymous class is converted into a stateless lambda, the same lambda object can be reused by Java runtime
 * during subsequent invocations. On the other hand, when an anonymous class is used, separate objects are created every time.
 * Thus, applying the quick-fix can cause the semantics change in rare cases, e.g. when anonymous class instances are used as HashMap keys.
 * Lambda syntax is not supported under Java 1.7 or earlier JVMs.
 */
public class CompareMgr {
    public static void main(String[] args) {
        Student st1 = new Student(1,"Vee");
        Student st2 = new Student(2,"Amit");
        Student st3 = new Student(0,"Vee");
        List<Student> stList = Arrays.asList(st1,st2,st3);
        System.out.println(stList);

        stList = Arrays.asList(st1,st2,st3);
        stList.sort(new StudentCompareByRollNo());


        System.out.println(stList);
        stList = Arrays.asList(st1,st2,st3);
        stList.sort(new StudentCompareByName());
        System.out.println(stList);
        stList.sort(new StudentCompareByVariousTypes());
        System.out.println(stList);
        stList = Arrays.asList(st1,st2,st3);
        stList.sort(Student.annonymousStudentComp);
        System.out.println(stList);

    }


}

class Student {
    String name;
    int rollNo;

    Student(int rollNo, String name) {
        this.name = name;
        this.rollNo = rollNo;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }


//    // use of annonymous classes
//    static Comparator<Student> annonymousStudentComp = new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o1.name.compareTo(o2.name);
//        }
//    };

    // use of annonymous classes functional interface and lambda function
    static Comparator<Student> annonymousStudentComp = (o1, o2) -> o1.name.compareTo(o2.name);





}
class StudentCompareByRollNo implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.rollNo - o2.rollNo;
    }
}
class StudentCompareByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}



class StudentCompareByVariousTypes implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {

        if(o1.name.compareTo(o2.name) == 0)
        {
            return o1.rollNo - o2.rollNo;

        }
        else
            return o1.name.compareTo(o2.name);
    }
}