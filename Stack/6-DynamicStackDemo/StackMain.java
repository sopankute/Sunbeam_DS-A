import java.util.Scanner;
import java.util.Stack;

public class StackMain {

    public static int menu(){
        //display menu list
        System.out.println("***** dynamic stack *****");
        System.out.println("0. exit");
        System.out.println("1. push element");
        System.out.println("2. pop element");
        System.out.println("3. peek element");

        //accept choice from user
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the choice : ");
        int choice = sc.nextInt();
        //return choice to the calling function
        return choice;
    }

    public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    int ele;
    Scanner sc = new Scanner(System.in);

    while( true ){
        int choice = menu();
        switch(choice){
            case 0: System.exit(0);

            case 1://push element onto the stack
                System.out.printf("enter an ele : ");
                ele = sc.nextInt();
                s.push(ele);
                System.out.println(ele+" pushed onto the stack");
                break;

            case 2: //pop element from the stack
                if( !s.empty() ){//if stack is not empty
                    ele = s.peek();
                    s.pop();
                    System.out.println("popped ele is : "+ele);
                }else{
                    System.out.println("stack underflow !!!");
                }

                break;

            case 3://peek element from the stack
                if( !s.empty() ){//if stack is not empty
                    System.out.println("topmost ele is : "+s.peek() );
                }else{
                    System.out.println("stack underflow !!!");
                }
                break;

            default: System.out.println("invalid choice");
                break;
        }

    }

 }   
    
}
