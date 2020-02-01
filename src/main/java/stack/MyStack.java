package stack;

import java.util.Objects;
import java.util.Stack;

/**
 * Stack data structure - LIFO, FILO
 * pop(), peek(), push(), isEmpty(), search()
 *  Java implementation - extends Vector and implements interfaces(Iterable, Collection, List)
 */
public class MyStack {


    static class Employee {

        String name;
        String id;

        public Employee(String name, String id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name) &&
                    Objects.equals(id, employee.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Stack<Employee> empStack = new Stack<Employee>();
        empStack.push(new Employee("V", "1"));
        empStack.push(new Employee("A", "2"));
        System.out.println(empStack.peek());
        //position from top of the stack
        System.out.println(empStack.search(new Employee("V", "1")));

    }




}
