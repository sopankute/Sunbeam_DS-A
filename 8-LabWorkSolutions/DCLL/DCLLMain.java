/* implementation of doubly circular linked list operations */

import java.util.Scanner;

class LinkedList{

    //Node class is a static inner class of Linked List class
    static class Node{
        int data;
        Node next;
        Node prev; 
        //Node class constructor
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }//end of Node class

    private Node head;
    private int nodesCount;

    //LinkedList class constructor
    LinkedList( ){
        //initially head is null => list is empty and no. of nodes in a list = 0
        this.head = null;
        this.nodesCount = 0;
    }

    boolean isListEmpty(){
        return ( this.head == null );
    }

    int getNodesCount( ){
        return ( this.nodesCount );
    }

    void addNodeAtLastPosition(int data){
        //step-1: create a newnode
        Node newNode = new Node(data);

        //step-2: if list is empty -> attach newly created node to the head
        if( isListEmpty() ){
            head = newNode;
            //attach first node into the next part of newNode which is added at last position
            newNode.next = head;
            //attach last node into the prev part of newNode which is added at first position
            newNode.prev = newNode;
            nodesCount++;
        }else{//step-3: if list is not empty
            //attach first node into the next part of newNode which is to be added at last position
            newNode.next = head;
            //attach cur last node into the prev part of newNode which is to be added at last position
            newNode.prev = head.prev;
            //attach newNode into the next part of cur last node
            head.prev.next = newNode;
            //update prev part of first node by newNode which is added at last position
            head.prev = newNode;

            nodesCount++;
        }
    }

    void addNodeAtFirstPosition(int data){
        //step-1: create a newnode
        Node newNode = new Node(data);

        //step-2: if list is empty -> attach newly created node to the head
        if( isListEmpty() ){
            head = newNode;
            //attach first node into the next part of newNode which is added at last position
            newNode.next = head;
            //attach last node into the prev part of newNode which is added at first position
            newNode.prev = newNode;
            nodesCount++;
        }else{//step-3: if list is not empty
            //attach cur first node into the next part of newNode which is to be added at first position
            newNode.next = head;
            //attach last node into the prev part of newNode which is to be added at first position
            newNode.prev = head.prev;
            //attach newNode into the next part of last node
            head.prev.next = newNode;
            //attach newNode into the prev part of cur first node
            head.prev = newNode;
            //attach newNode to the head
            head = newNode;
            nodesCount++;
        }
    }

    void addNodeAtSpecificPosition(int pos, int data){
        if( pos == 1 )//if pos is the first position
            addNodeAtFirstPosition(data);
        else if( pos == getNodesCount() + 1 )//if pos is the last position
            addNodeAtLastPosition(data);
        else{//if pos is inbetween position
            //create a newnode
            Node newNode = new Node(data);
            int i = 1;
            //start traversal from first node
            Node trav = head;
            //traverse the list till (pos-1)th node
            while( i < pos-1 ){
                i++;
                trav = trav.next;
            }

            //attach cur (pos)th node into the next part of newNode
            newNode.next = trav.next;
            //attach (pos-1)th node into the prev part of newNode
            newNode.prev = trav;
            //attach newNode into the prev part of cur (pos)th node
            trav.next.prev = newNode;
            //attach newNode into the next part of (pos-1)th node
            trav.next = newNode;
            nodesCount++;
        }
    }

    void displayList( ){
        //if list empty
        if( isListEmpty() ){
            throw new RuntimeException("list is empty !!!");
        }else{//if list is not empty
            //start traversal of the list from first node
            Node trav = head;
            System.out.print("list in forward dir is  : ");
            //traverse the list till last node
            do{
                System.out.printf("%4d", trav.data);//display data part of node
                trav = trav.next;//move trav towards its next node
            }while( trav != head );
            System.out.println();

            //start traversal of the list from last node
            trav = head.prev;
            System.out.print("list in backward dir is : ");
            //traverse the list till first node
            do{
                System.out.printf("%4d", trav.data);//display data part of node
                trav = trav.prev;//move trav towards its prev node
            }while( trav != head.prev );
            System.out.println();
            System.out.println("no. of nodes in a list are : "+getNodesCount());
        }
    }

    void deleteNodeAtFirstPosition( ){
        //step-1: if list is empty
        if( isListEmpty() ){
            throw new RuntimeException("list is empty !!!");
        }else{//if list is not empty
            //step-2: if list contains only one node
            if( head == head.next ){
                head = null;
                nodesCount--;
            }else{//step-3: if list contains more than one nodes
                //update next part of last node by cur second node
                head.prev.next = head.next;
                //update prev part of cur second by last node
                head.next.prev = head.prev;
                //update head by second node
                head = head.next;
                nodesCount--;
            }
        }
    }

    void deleteNodeAtLastPosition( ){
        //step-1: if list is empty
        if( isListEmpty() ){
            throw new RuntimeException("list is empty !!!");
        }else{//if list is not empty
            //step-2: if list contains only one node
            if( head == head.next ){
                head = null;
                nodesCount--;
            }else{//step-3: if list contains more than one nodes
                //update next part of cur second last node by head
                head.prev.prev.next = head;
                //update prev part of first node by cur second last node
                head.prev = head.prev.prev;
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
            int i = 1;
            //start traversal from first node
            Node trav = head;
            //traverse the list (pos-1)th node
            while( i < pos-1 ){
                i++;
                trav = trav.next;
            }
            //attach (pos-1)th node into the prev part of (pos+1)th node
            trav.next.next.prev = trav;
            //attach (pos+1)th node into the next part of (pos-1)th node
            trav.next = trav.next.next;
            nodesCount--;
        }
    }

}//end of LinkedList class

public class DCLLMain {
    public static int menu( ){
        //display menu list
        System.out.println("********* doubly circular linked list operations *********");
        System.out.println("0. exit");
        System.out.println("1. add node at last position");
        System.out.println("2. add node at first position");
        System.out.println("3. add node at specific position");
        System.out.println("4. delete node at first position");
        System.out.println("5. delete node at last position");
        System.out.println("6. delete node at specific position");
        System.out.println("7. display list");

        //accept choice from user and return it to the calling function
        System.out.print("enter the choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int data;
        int pos;

        while( true ){
            int choice = menu();
            switch(choice){
                case 0: System.exit(0);
                
                case 1://add node at last position
                    System.out.print("enter data : ");
                    data = sc.nextInt();
                    l1.addNodeAtLastPosition(data);
                    System.out.println("node having data part : "+data+" added at last position");
                    break;

                case 2://add node at first position
                    System.out.print("enter data : ");
                    data = sc.nextInt();
                    l1.addNodeAtFirstPosition(data);
                    System.out.println("node having data part : "+data+" added at first position");
                    break;

                case 3://add node at specific position
                    //step-1: accept position from user
                    while( true ){
                        System.out.print("enter the pos : ");
                        pos = sc.nextInt();

                        if( pos >= 1 && pos <= l1.getNodesCount() + 1 )
                            break;

                        System.out.println("invalid position !!!");
                    }
                    
                    System.out.print("enter data : ");
                    data = sc.nextInt();
                    l1.addNodeAtSpecificPosition(pos, data);
                    System.out.println("node having data part : "+data+" added at position : "+pos);
                    break;

                case 4://delete node at first position
                    try{
                        l1.deleteNodeAtFirstPosition();
                        System.out.println("node at first position deleted ...");
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage() );
                    }
                    break;

                case 5://delete node at last position
                    try{
                        l1.deleteNodeAtLastPosition();
                        System.out.println("node at last position deleted ...");
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage() );
                    }

                    break;

                case 6://delete node at specific position
                    //step-1: accept position from user
                    while( true ){
                        System.out.print("enter the pos : ");
                        pos = sc.nextInt();

                        if( pos >= 1 && pos <= l1.getNodesCount() )
                            break;

                        System.out.println("invalid position !!!");
                    }
                    
                    l1.deleteNodeAtSpecificPosition(pos);
                    System.out.println("node at position "+pos+" deleted ...");
                    break;

                case 7://display list
                    try{
                        l1.displayList();
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;

            }//end of switch control block
        }
    }
}
