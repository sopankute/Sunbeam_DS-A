import java.util.Scanner;

class Stack{
    int [] arr;
    int top;

    Stack( ){
        arr = new int[ 5 ];
        top = -1;
    }

    Stack(int size){
        arr = new int[ size ];
        top = -1;
    }

    boolean isStackFull( ){
        return ( top == arr.length-1 );
    }

    boolean isStackEmpty( ){
        return ( top == -1 );
    }

    void pushElement(int ele){
        //step-1: check stack is not full 
        if( isStackFull() ){
            throw new RuntimeException("stack overflow !!!");
        }else{//if stack is not full then only element can be pushed onto the stack from top end
            //step-2: increment the value of top by 1
            top++;
            //step-3: insert an element onto the stack at top end
            arr[ top ] = ele;
        }
    }

    int peekElement(){
        //step-1: check stack is not empty
        if( isStackEmpty() ){
            throw new RuntimeException("stack underflow !!!");
        }else{//if stack is not empty then only element can be pop from the stack which is at top end
            //step-2: return/get the value of an element at top end [ without increment/decrement top ].
            return ( arr[ top ] );
        }
    } 

    void popElement(){
        //step-1: check stack is not empty
        if( isStackEmpty() ){
            throw new RuntimeException("stack underflow !!!");
        }else{//if stack is not empty then only element can be peeked from the stack which is at top end
            //step-2: decrement the value of by 1 [ by decrementing value of top by 1 we are achieving deletion of an element from the stack ].
            top--;
        }
    }

}//end of Stack class

public class StaticStackMain {
 
    public static int menu(){
        //display menu list
        System.out.println("***** static stack *****");
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
    Stack s = new Stack();
    int ele;
    Scanner sc = new Scanner(System.in);

    while( true ){
        int choice = menu();
        switch(choice){
            case 0: System.exit(0);

            case 1://push element onto the stack
                try{
                    System.out.print("enter an ele : ");
                    ele = sc.nextInt();
                    s.pushElement(ele);
                    System.out.println(ele+" pushed onto the stack"); 
                }catch(RuntimeException e){
                    System.out.println( e.getMessage() );
                }
                break;

            case 2: //pop element from the stack
                try{
                    ele = s.peekElement(); 
                    s.popElement();
                    System.out.println("popped ele is : "+ele); 
                }catch(RuntimeException e){
                    System.out.println( e.getMessage() );
                }

                break;

            case 3://peek element from the stack
                try{
                    ele = s.peekElement(); 
                    System.out.println("topmost ele is : "+ele); 
                }catch(RuntimeException e){
                    System.out.println( e.getMessage() );
                }

                break;

            default: System.out.println("invalid choice");
                break;
        }

    }

 }   
}
