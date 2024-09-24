import java.util.*;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList();

        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        l1.addLast(50);

        //way-1: display linked list
        System.out.print("list l1 is : ");
        System.out.println(l1);

        l1.addFirst(5);

        //way-2: display linked list by using for each loop
        System.out.print("list l1 is : ");
        for( Integer ele : l1 )
            System.out.printf("%4d", ele);
        System.out.println();

        l1.add(4, 99);
        //way-3: display linked list by an iterator
        System.out.print("list l1 is : ");
        for( int index = 0 ; index < l1.size() ; index++ ){
            System.out.print(" "+ l1.get(index) );
        }
        System.out.println();

    }    
}
