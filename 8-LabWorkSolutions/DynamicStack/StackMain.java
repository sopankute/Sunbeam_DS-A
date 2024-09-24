/* Implementation of Dynamic Stack (By using Linked List)*/ 

import java.util.Scanner;

class Stack{
    static class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }//end of Node class

    private Node top;

    Stack( ){
        top = null;
    }

    boolean isStackEmpty( ){
        return ( top == null );
    }

    //we are using logic of addFirst() in SLLL which takes O(1) time
    void pushElement(int ele){
        //create a newnode
        Node newNode = new Node(ele);

        //if stack is empty => attach newly created node to the top
        if( isStackEmpty() ){
            top = newNode;
        }else{//if stack is not empty
            //attach cur first node into the next part of newNode which is to be added at top i.e. first pos
            newNode.next = top;
            //attach newNode the top
            top = newNode;
        }
    }

    //we are using logic of deleteFirst() in SLLL which takes O(1) time
    void popElement( ){
        //step-1: check stack is not empty
        if( isStackEmpty() ){//if stack is empty
            throw new RuntimeException("stack underflow !!!");
        }else{//if stack is not empty
            //attach cur second node to the head
            top = top.next;
        }
    }

    //in this function we are returning value of data part of first node i.e. value of data part topmost element 
    int peekElement( ){
        //step-1: check stack is not empty
        if( isStackEmpty() ){//if stack is empty
            throw new RuntimeException("stack underflow !!!");
        }else{//if stack is not empty
            return ( top.data );
        }
    }
}//end of Stack class

public class StackMain {

    public static int menu(){
        //display menu
        System.out.println("********* dynamic stack *********");
        System.out.println("0. exit");
        System.out.println("1. push element");
        System.out.println("2. pop element");
        System.out.println("3. peek element");
    
        //accept choice from user and return it to the calling function 
        System.out.print("enter the choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        Scanner sc = new Scanner(System.in);
        int ele;

        while( true ){
            int choice = menu();
            switch( choice ){
                case 0: System.exit(0);
                
                case 1://push element
                    System.out.print("enter an ele : ");
                    ele = sc.nextInt();
                    s.pushElement(ele);
                    System.out.println(ele+" is pushed onto the stack ...");
                    break;

                case 2://pop element
                    try{
                        ele = s.peekElement();
                        s.popElement();
                        System.out.println("deleted ele is : "+ele);
                    }catch(RuntimeException e ){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3://peek element
                    try{
                        ele = s.peekElement();
                        System.out.println("topmost ele is : "+ele);
                    }catch(RuntimeException e ){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }    
}
