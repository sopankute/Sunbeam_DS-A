import java.util.Scanner;

class LinkedList{
    static class Node{
        private int data;
        private Node prev;//prev is a reference of type Node class
        private Node next;//next is a reference of type Node class

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }//end of Node class

    private Node head;
    private int nodesCount;

    LinkedList(){
        head = null;
        nodesCount = 0;
    }

    boolean isListEmpty( ){
        return ( head == null );
    }

    int getNodesCount( ){
        return ( this.nodesCount );
    }

    void addNodeAtLastPosition(int data){
        //step-1: create a newnode
        Node newNode = new Node(data);

        //step-2: if list is empty -> attach newly created node to the head
        if( isListEmpty( ) ){
            head = newNode;
            nodesCount++;
        }else{//step-3: if list is not empty
            //start traversal of the list from first node
            Node trav = head;
            //traverse the list till last node
            while( trav.next != null )
                trav = trav.next;//move trav towards its next node

            //attach newly created node to the last node
            trav.next = newNode;
            //attach cur last node into the prev part of newly created node
            newNode.prev = trav;
            nodesCount++; 
        }
    }

    void addNodeAtFirstPosition(int data){
        //step-1: create a newnode
        Node newNode = new Node(data);

        //step-2: if list is empty -> attach newly created node to the head
        if( isListEmpty( ) ){
            head = newNode;
            nodesCount++;
        }else{//step-3: if list is not empty

            //attach cur first node into the next part of newly created node
            newNode.next = head;
            //attach newly created node into the prev part of cur first node
            head.prev = newNode;
            //attach newly created node to the head
            head = newNode;
            nodesCount++; 
        }
    }

    void displayList( ){
        if( isListEmpty() )
            throw new RuntimeException("list is empty");
        else{//if list is not empty
            //start traversal of the list from first node
            Node trav = head;
            Node temp = null;

            System.out.print("list in a forward dir is  : ");
            //traverse the list till last node
            while( trav != null ){
                temp = trav;
                System.out.printf("%4d", trav.data);
                trav = trav.next;
            }
            System.out.println();

            //start traversal from last node
            trav = temp;
            System.out.print("list in a backward dir is : ");
            //traverse the list till first node
            while( trav != null ){
                temp = trav;
                System.out.printf("%4d", trav.data);
                trav = trav.prev;//move trav towards its prev node
            }
            System.out.println();

            System.out.println("no. of nodes in a list are : "+getNodesCount());
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

            //attach cur (pos)th node into next part of newly created node
            newNode.next = trav.next;
            //attach (pos-1)th node into prev part of newly created node
            newNode.prev = trav;
            //attach newly created node into the prev part of cur (pos)th node
            trav.next.prev = newNode;
            //attach newly created node into the next part of cur (pos-1)th node
            trav.next = newNode;
            nodesCount++;
        }
    }

}//end of LinkedList class

public class DoublyLinLinkedListMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos;

        //create an empty linked list
        LinkedList l1 = new LinkedList();

        l1.addNodeAtLastPosition(11);
        l1.addNodeAtLastPosition(22);
        l1.addNodeAtLastPosition(33);
        l1.addNodeAtLastPosition(44);
        l1.addNodeAtLastPosition(55);
        l1.addNodeAtLastPosition(66);

        try{
            l1.displayList();
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

        //l1.addNodeAtFirstPosition(5);
        while( true ){
            //step-1: accept position from user
            System.out.print("enter the pos : ");
            pos = sc.nextInt();

            //step-2: validate position
            if( pos >= 1 && pos <= l1.getNodesCount() + 1 )
                break;

            System.out.println("invalid position");
        }

        l1.addNodeAtSpecificPosition(pos, 99);


        try{
            l1.displayList();
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

        
    }    
}
