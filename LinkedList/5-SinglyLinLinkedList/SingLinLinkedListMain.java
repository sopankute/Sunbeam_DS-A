import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;
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

    void deleteNodeAtFirstPosition( ){
        //step-1: check list is empty or not
        if( isListEmpty() ){
            throw new RuntimeException("list is empty");
        }else{//if list is not empty
            //step-2 : if list contains only one node
            if( head.next == null ){
                //make head as null
                head = null;
                nodesCount--;
            }else{//step-3: if list contains more than nodes
                //attach cur second node to the head
                head = head.next;
                nodesCount--;
            }
        }
    }

    void deleteNodeAtLastPosition( ){
        //step-1: check list is empty or not
        if( isListEmpty() ){
            throw new RuntimeException("list is empty");
        }else{//if list is not empty
            //step-2 : if list contains only one node
            if( head.next == null ){
                //make head as null
                head = null;
                nodesCount--;
            }else{//step-3: if list contains more than nodes
                //start traversal from first node
                Node trav = head;
                //traverse the list till second last node
                while( trav.next.next != null ){
                    trav = trav.next;//move trav towards its next node	
                }
                
                //make next part of second last node as null
                trav.next = null;
                nodesCount--;
            }
        }
    }

    void deleteNodeAtSpecificPosition(int pos){
        if( pos == 1 )//if pos is the first position
            deleteNodeAtFirstPosition();
        else if( pos == getNodesCount() )//if pos is the last position
            deleteNodeAtLastPosition();
        else{//if pos is in between position
            int i=1;
            //start traversal from first node
            Node trav = head;
            //traverse the list till (pos-1)th node
            while( i < pos-1 ){
                i++;
                trav = trav.next;//move trav towards its next node
            } 

            //attach (pos+1)th node to the next part of (pos-1)th node
            trav.next = trav.next.next;
            nodesCount--;
        }
    }

    /*
        searcNode() function: 
        on sucess this function returns true and it also returns an addr of node which is to be deleted in temp[1]
        as well as an addr of its prev node in temp[ 0 ] as an out parameter, and 
        on failure this function returns false and in a temp ref it retruns null  */

    boolean searchNode(int data, Node [] temp){
        temp[ 0 ] = null;

        for( Node trav = head ; trav != null ; trav = trav.next ){
            if( data == trav.data ){//if key data matches with data part of a node
                temp[ 1 ] = trav;
                return true;
            }

            temp[ 0 ] = trav;//this will refer to prev node
        
        }//end of for loop

        //if key data do not matches with any node => node not found
        temp[ 0 ] = null; //will refer to prev node of a node which is to be deleted
        temp[ 1 ] = null; // will refer to node which is to be deleted
        return false;
    }
    
    
    boolean searchAndDelete(int data){
        Node [] temp = { null, null };

        //search a node whose data part matches with "data"
        if( !searchNode(data, temp) )//if node is nod found -> return false
            return false;

        //if node is found
        System.out.println("node is found in a list");
        if( temp[ 0 ] == null )
            System.out.println("node is found at first pos => temp[1].data : "+temp[1].data);
        else
            System.out.println("temp[0].data : "+temp[0].data+"\t temp[1].data : "+temp[1].data);

        
        //if node which is to be delete is at first position 
        if( temp[ 0 ] == null )
            head = head.next;//attach cur second node to the head
        else
            temp[ 0 ].next = temp[ 1 ].next;//attach next node of a node which to be deleted to its prev node 

        nodesCount--;
        return true;
    }

    void displayListInReverseOrder(Node trav){
        //base condition
        if( trav == null )
            return;

        displayListInReverseOrder(trav.next);//modification
        System.out.printf("%4d", trav.data);
    }

    //wrapper fuunction => from inside this function actual rec function gets called 
    void displayListInReverseOrder(){
        if( isListEmpty() ){
            throw new RuntimeException("list is empty");
        }else{
            System.out.print("list in a reverse order is : ");
            displayListInReverseOrder(head);//initialization
            System.out.println();
        }
    }

    void reverseList(){
        if( isListEmpty() ){
            throw new RuntimeException("list is empty");
        }else{
            Node t1=head;
            Node t2=t1.next;
            t1.next = null;

            while( t2 != null ){
                Node t3 = t2.next;//move t3 towards its next node
                t2.next = t1;//reverse link
                
                t1 = t2;//move t1 towards its next node
                t2 = t3;//move t2 towards its next node
            }
            //attach cur last node to the head
            head = t1;
        }
    }

}//end of LinkedList class

public class SingLinLinkedListMain{
    
    public static int menu( ){
        //display menu list
        System.out.println("***** singly linear linked list *****");
        System.out.println("0. exit");
        System.out.println("1. add node at last position");
        System.out.println("2. add node at first position");
        System.out.println("3. add node at specific position");
        System.out.println("4. delete node at first position");
        System.out.println("5. delete node at last position");
        System.out.println("6. delete node at specific position");
        System.out.println("7. search and delete");
        System.out.println("8. display list");
        System.out.println("9. display list in a reverse order");
        System.out.println("10. reverse list");

        System.out.print("enter the choice : ");
        //accept choice from user
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        //return choice to the calling function
        return choice;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos;
        int data;
        
        //create an empty linked list
        LinkedList l1 = new LinkedList();

        while( true ){
            int choice = menu();
            switch(choice){
                case 0:
                    System.exit(0);

                case 1://add node at last position
                    System.out.print("enter data : ");
                    data = sc.nextInt();
                    l1.addNodeAtLastPosition(data);
                    break;

                case 2://add node at first position
                    System.out.print("enter data : ");
                    data = sc.nextInt();
                    l1.addNodeAtFirstPosition(data);
                    break;

                case 3://add node at specific position
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

                    System.out.print("enter data : ");
                    data = sc.nextInt();
                    l1.addNodeAtSpecificPosition(pos, data);
                    break;
                
                case 4://delete node at first position
                    try{
                        l1.deleteNodeAtFirstPosition();
                    }catch( RuntimeException e ){
                        System.out.println( e.getMessage() );
                    }
                    break;

                case 5://delete node at last position
                    try{
                        l1.deleteNodeAtLastPosition();
                    }catch( RuntimeException e ){
                        System.out.println( e.getMessage() );
                    }
                    break;

                case 6://delete node at specific position
                    //till user will not enter valid position this loop will continue
                    while( true ){
                        //step-1: accept position from user
                        System.out.print("enter pos : ");
                        pos = sc.nextInt();
                        
                        //step-2: validate position
                        //if( pos >= 1 && pos <= count_nodes ) => pos valid
                        if( pos >= 1 && pos <= l1.getNodesCount() ) //pos is valid
                            break;//if user entered valid pos while loop gets breaked

                        //if position is invalid
                        System.out.println("invalid position ...");
                    }

                    l1.deleteNodeAtSpecificPosition(pos);
                    
                    break;
                case 7://search and delete
                    //step-1: accept data part of a node which is to be deleted (key data) 
                    System.out.print("enter key data : ");
                    data = sc.nextInt();
                    
                    if( l1.searchAndDelete(data) ){
                        System.out.println("node having data part : "+data+ " is found in a list and deleted");
                    }else{
                        System.out.println("node having data part : "+data+ " is not found");
                    }
                    break;

                case 8://display list
                        
                    try{
                        l1.displayList();
                    }catch( RuntimeException e ){
                        System.out.println( e.getMessage() );
                    }
                    break;

                case 9://display list in a reverse order
                    try{
                        l1.displayListInReverseOrder();
                    }catch( RuntimeException e ){
                        System.out.println( e.getMessage() );
                    }
                    break;

            case 10:
                    try{
                        l1.reverseList();
                    }catch( RuntimeException e ){
                        System.out.println( e.getMessage() );
                    }
                    break;
            default :
                    System.out.println("invalid choice");                    

            }

        }

    }
        
}
