class LinkedList{

    static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }//end of Node class

    private Node head;//head is a reference of type Node class
    private int nodesCount;
    
    public LinkedList(){
        this.head = null;
        this.nodesCount=0;
    }

    boolean isListEmpty( ){
        return ( head == null );
    }

    void addNodeAtLastPosition(int data){
        //step-1: create a newnode
        Node newNode = new Node(data);
        
        //step-2: //if list is empty then attach newly created node to the head
	    if( isListEmpty() ){
		    head = newNode;
		    //attach first node into the next part of newly created node added at last position
		    newNode.next = head;
            nodesCount++;
        }else{//step-3: if list is not empty
            //- start traversal of the list from first node
            Node trav = head;
            //step-4: traverse the list till last node
            while( trav.next != head ){
                trav = trav.next;
            }
            //step-5: attach newly created node to the head
            trav.next = newNode;
            //step-6: attach first node into the next part of newly created node added at last position
            newNode.next = head;
            nodesCount++;
        }         
    }

    void addNodeAtFirstPosition(int data){
        //step-1: create a newnode
        Node newNode = new Node(data);
        
        //step-2: //if list is empty then attach newly created node to the head
	    if( isListEmpty() ){
		    head = newNode;
		    //attach first node into the next part of newly created node added at last position
		    newNode.next = head;
            nodesCount++;
        }else{//step-3: if list is not empty
            //- start traversal of the list from first node
            Node trav = head;
            //step-4: traverse the list till last node
            while( trav.next != head ){
                trav = trav.next;
            }

            //attach cur first node into the next part of newly created node
            newNode.next = head;
            //attach newly created node to the head
            head = newNode;
            //update next part of last node by newly added node at first position
            trav.next = head;
            nodesCount++;
        }         
    }

    int getNodesCount(){
        return ( this.nodesCount );
    }

    void displayList( ){
        if(isListEmpty() )
            throw new RuntimeException("list is empty");
        else{//if list is not empty
            System.out.print("list is : ");
            //start tarversal of the list first node
            Node trav = head;
            
            //traverse the list till last node including it
            do{
                System.out.printf("%4d", trav.data);
                trav = trav.next;
            }while( trav != head );
            
            System.out.println();
            System.out.println("no. of nodes in a list are : "+getNodesCount());
        }
    }


    void deleteNodeAtFirstPosition( ){
        //step-1: check list is not empty
        if( isListEmpty() )
            throw new RuntimeException("list is empty");
        else{//if list is not empty
            //step-2: if list contains only one node
            if( head == head.next ){
                //make head as null
                head = null;
                nodesCount--;
            }else{//step-3: list contains more than one nodes
                //start tarversal from first node
                Node trav = head;
                //traverse the list till last node
                while( trav.next != head )
                    trav = trav.next;

                //attach cur second node to the head
                head = head.next;
                //update next part of last node by head
                trav.next = head;
                nodesCount--;
            }
        }
    }

    void deleteNodeAtLastPosition( ){
        //step-1: check list is not empty
        if( isListEmpty() )
            throw new RuntimeException("list is empty");
        else{//if list is not empty
            //step-2: if list contains only one node
            if( head == head.next ){
                //make head as null
                head = null;
                nodesCount--;
            }else{//step-3: list contains more than one nodes
                //start tarversal from first node
                Node trav = head;
                //traverse the list till second last node
                while( trav.next.next != head )
                    trav = trav.next;

                //attach addr of first node into the next part of cur second last node
    		    trav.next = head;
                nodesCount--;
            }
        }
    }


}//end of LinkedList class

public class SingCirLinkedListMain {
    public static void main(String[] args) {
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
            System.out.println( e.getMessage() );
        }

        //l1.addNodeAtFirstPosition(5);
        //l1.deleteNodeAtFirstPosition();
        l1.deleteNodeAtLastPosition();
        
        try{
            l1.displayList();
        }catch(RuntimeException e){
            System.out.println( e.getMessage() );
        }

    }    
}
