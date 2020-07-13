package demo;

/**
 * @author zhaopeng
 * @create 2020-06-12 12:57
 */

class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
  /*  public  Person(){

    }*/
}
class Employee extends Person {
    String empID = "0000";

    public Employee(String nm) {
        super(nm);
    }
}
public class Test {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}