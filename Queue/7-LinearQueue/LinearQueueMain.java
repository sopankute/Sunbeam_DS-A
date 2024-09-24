import java.util.Scanner;

import javax.naming.ldap.ExtendedRequest;

class LinearQueue{
    int [] arr;
    int front;
    int rear;

    LinearQueue(int size){
    
        arr = new int[ size ];
        front = -1;
        rear = -1;
    }

    boolean isQueueFull( ){
        return ( rear == arr.length-1 );
    }   

    boolean isQueueEmpty( ){
        return ( rear == -1 || front > rear );
    }   

    void enqueue(int ele){
        //step-1: check queue is not full 
        if( isQueueFull() ){
            throw new RuntimeException("Queue is full !!!");
        }else{//if queue is not full then only we can insert an element into it
            //step-2: increment the value of rear by 1
            rear++;
            //step-3: insert an element into the queue from rear end
            arr[ rear ] = ele;
            /* step-4: if( front == -1 ) => front = 0 */
            if( front == -1 )
                front = 0; 
        }
    }

    int getFront(){
        if( isQueueEmpty() ){
            throw new RuntimeException("Queue is empty");
        }else{
            //return the value of an ele at front end
            return ( arr[ front ] );
        }
    }

    void dequeue(){
        //step-1: check queue is not empty
        if( isQueueEmpty() ){
            throw new RuntimeException("Queue is empty");
        }else{//if queue is not empty then only we can delete an element from it
            //step-2: increment the value of front by 1 [ by means of incrementing value of front by 1 we are achieving deletion of an element from queue ].
            front++;
        }
    }

}

public class LinearQueueMain {
    
    public static int menu( ){
        
        //display menu list
        System.out.println("***** linear queue *****");
        System.out.println("0. exit");
        System.out.println("1. enqueue");
        System.out.println("2. dequeue");
        
        //accept choice from user and return it to the calling function
        System.out.print("enter the choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }

    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);
        int ele;
        Scanner sc =new Scanner(System.in);

        while( true ){
            int choice = menu();
            switch( choice ){
                case 0: System.exit(0);

                case 1://insert ele into the queue
                    try{
                        //accept ele from user
                        System.out.print("enter an ele : ");
                        ele = sc.nextInt();

                        q.enqueue(ele);
                        System.out.println(ele+" inserted into the queue ....");
                    }catch( RuntimeException e){
                        System.out.println(e.getMessage() );
                    }
                    break;

                case 2://delete ele from the queue
                    try{
                        //get the value of an ele at front end
                        ele = q.getFront();
                        //delete ele from the queue
                        q.dequeue();
                        System.out.println("deleted ele is : "+ele);
                    }catch( RuntimeException e){
                        System.out.println(e.getMessage() );
                    }

                    break;
            }

        }

    }   
}
