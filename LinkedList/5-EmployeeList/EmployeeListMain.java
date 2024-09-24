import java.util.*;
import java.util.LinkedList;

class Employee{
    int empID;
    String empName;
    float salary;

    Employee( ){
        this.empID = 0;
        this.empName = " ";
        this.salary = 0.0f;
    }

    Employee( int empid, String name, float salary){
        this.empID = empid;
        this.empName = name;
        this.salary = salary;
    }

    //getter functions
    //setter functions
    //facilitators
    //mutators
}

public class EmployeeListMain {
    public static void main(String[] args) {
        LinkedList<Employee> emplist = new LinkedList<Employee>();
        emplist.addLast( new Employee(111, "sachin", 1111.11f ) );
        emplist.addLast( new Employee(222, "rakesh", 2222.22f ) );
        emplist.addLast( new Employee(333, "nilesh", 3333.33f ) );
        emplist.addLast( new Employee(444, "sandeep", 4444.44f ) );

        System.out.println("list of an employees is: ");
        for( Employee emp : emplist ){
            System.out.printf("%-10d %-20s %-10.2f\n", emp.empID, emp.empName, emp.salary);
        }

    }    
}
