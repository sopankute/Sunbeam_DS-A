import java.util.Scanner;

import javax.sound.midi.SysexMessage;

class LinkedList{

    static class Node{
        private int data;//data part : contains actual data of type "int"
        private Node next;//next part : reference of type Node class which refers to the next node

        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }//end of Node class

    //sizeof Node class object = 8 bytes ( on 32 bit compiler )

    private Node head;//4 bytes => reference of type Node class which always referes to first node in a list 
    private int nodesCount;

    public LinkedList(){
        this.head = null;
        this.nodesCount = 0;
    }

    boolean isListEmpty( ){
        return ( head == null );
    }

    int getNodesCount( ){
        return ( this.nodesCount );
    }

    void addNodeAtLastPosition(int data){
        //step-1: create a newnode dynamically/runtime
        Node newNode = new Node(data);

        //step-2: check list is empty or not
        if( isListEmpty() ){//if list is empty then attach newly created node to the head
            head = newNode;
            nodesCount++;
        }else{//step-3: if list is not empty
            //start traversal from first node
            Node trav = head;
            //traverse the list till last node
            while( trav.next != null ){
                trav = trav.next;//move trav towards its next node
            }
            //attach newly created node to the last node i.e. store an addr of newly created node into the next part of last node
            trav.next = newNode;
            nodesCount++;
        }
    }

    void addNodeAtFirstPosition(int data){
        //step-1: create a newnode dynamically/runtime
        Node newNode = new Node(data);

        //step-2: check list is empty or not
        if( isListEmpty() ){//if list is empty then attach newly created node to the head
            head = newNode;
            nodesCount++;
        }else{//step-3: if list is not empty
            //store an addr cur first node into the next part of newly created node
            newNode.next = head;
            //attach newly created node to the head
            head = newNode;
            nodesCount++;
        }
    }

    //as in this function there is need to traverse list till last node this function takes O(n) time 
    int countNodes( ){
        int cnt = 0;
        //if list is not empty -> traverse the list and count no. of nodes in it
        if( !isListEmpty() ){
            Node trav = head;
            while( trav != null ){
                cnt++;
                trav = trav.next;//move trav towards its next node
            }
        }
        return cnt;
    }

    void displayList(){
        if( isListEmpty() ){//if list is empty then trow RuntimeException error message
            throw new RuntimeException("list is empty !!!");
        }else{//if list is not empty
            //start traversal of linked list from first node
            Node trav = head;//trav is a reference of Node class
            //traverse the list till last node including it
            System.out.print("list is : head -> ");
            while( trav != null ){
                System.out.printf(" %d -> ", trav.data);//display data part of each node
                trav = trav.next;//move trav towards its next node
            }
            System.out.println(" null");
            //System.out.println("no. of nodes in a list are: "+countNodes());
            System.out.println("no. of nodes in a list are: "+getNodesCount());
        }
    }

    void addNodeAtSpecificPosition(int pos, int data){
        if( pos == 1 )//if pos is the first position
            addNodeAtFirstPosition(data);
        else if( pos == getNodesCount() + 1 )//if pos is the last position
            addNodeAtLastPosition(data);
        else{//if pos is in between position
            //create a newnode
            Node newNode = new Node(data);
            int i=1;
            //start traversal from first node
            Node trav = head;
            //traverse the list till (pos-1)th node
            while( i < pos-1 ){
                i++;
                trav = trav.next;
            }

            //attach cur (pos)th node to the next part of newly created node
            newNode.next = trav.next;
            //attach newly created node into the next part of (pos-1)th node
            trav.next = newNode;
            nodesCount++;
        }
    }

}//end of LinkedList class

public class SingLinLinkedListMain{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos;
        
        //create an empty linked list
        LinkedList l1 = new LinkedList();

        l1.addNodeAtLastPosition(10);
        l1.addNodeAtLastPosition(20);
        l1.addNodeAtLastPosition(30);
        l1.addNodeAtLastPosition(40);
        l1.addNodeAtLastPosition(50);
        l1.addNodeAtLastPosition(60);
        l1.addNodeAtLastPosition(70);

        try{
            l1.displayList();
        }catch( RuntimeException e ){
            System.out.println( e.getMessage() );
        }

        //l1.addNodeAtFirstPosition(5);

        //till user will not enter valid position this loop will continue
        while( true ){
            //step-1: accept position from user
            System.out.print("enter pos : ");
            pos = sc.nextInt();
            
            //step-2: validate position
            //if( pos >= 1 && pos <= count_nodes + 1 ) => pos valid
            if( pos >= 1 && pos <= l1.getNodesCount() + 1 ) //pos is valid
                break;//if user entered valid pos while loop gets breaked

            //if position is invalid
            System.out.println("invalid position ...");
        }

        l1.addNodeAtSpecificPosition(pos, 99);

        try{
            l1.displayList();
        }catch( RuntimeException e ){
            System.out.println( e.getMessage() );
        }
        
    }
          
}
