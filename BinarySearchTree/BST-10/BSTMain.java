import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BST{

    static class Node{
        int data;
        Node left;//reference of type Node class which refers to left child of a node if it is having
        Node right;//reference of type Node class which refers to right child of a node if it is having
        boolean visited;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.visited = false;
            //added flag logic for nonRecusrivePostOrder() method -> initially each node is not visited
        }
    
    }//end of Node class
    //sizeof(Node class object) = 12 bytes - on 32 bit compiler

    private Node root;//reference of type Node class which refers to root node in a BST if it is not empty

    BST(){
        this.root = null;
    }

    boolean isBSTEmpty(){
        return ( this.root == null );
    }

    void addNode(int data){
        //step-1: create a newnode
        Node newNode = new Node(data);

        //step-2: if bst is empty => attach newly created node to the root
        if( isBSTEmpty() ){
            root = newNode;
        }else{//step-3: if bst is not empty
            //start traversal from root node
            Node trav = root;
            
            //traverse bst and find an appropriate position of that node
            while( true ){

                if( data < trav.data ){//node will be a part of left subtree of cur node
                    if( trav.left == null ){//if cur node is not having left subtree
                        trav.left = newNode;//attach newly created node as a left child of cur node
                        break;
                    }else{//if cur node is having left subtree
                        trav = trav.left;//goto its left subtree
                    }
                }else{//if( data >= trav.data) => node will be a part of right subtree of cur node
                    if( trav.right == null ){//if cur node is not having left subtree
                        trav.right = newNode;//attach newly created node as right child of cur node
                        break;
                    }else{//if cur node is having right subtree
                        trav = trav.right;//goto its right subtree
                    }
                }
            }//end of while loop
        }
    }

    void recAddNode(Node trav, int data){
        //base condition
        if( trav == null )
            return;
        
        if( data < trav.data ){//node will be a part of left subtree of cur node
            if( trav.left == null ){//if left subtree of cur node is null
                trav.left = new Node(data);//create a newNode and attach it as a left child of cur node
                return;
            }else//if cur node is having left subtree
                recAddNode(trav.left, data);//goto its left subtree
        }else{//if( data >= trav.data ) => node will be a part of right subtree of cur node
            if( trav.right == null ){//if right subtree of cur node is null
                trav.right = new Node(data);//create a newNode and attach it as a right child of cur node
                return;
            }else//if cur node is having left subtree
                recAddNode(trav.right, data);//goto its right subtree
        }
    }

    //wrapper function
    void recAddNode(int data){
        if( isBSTEmpty() ){
            root = new Node(data);    
        }else{//if BST is not empty
            recAddNode(root, data);//initialization
        }
    }

    //recursive approach:
    void preOrder(Node trav){
        //base condition
        if( trav == null )
            return;

        //VLR
        System.out.printf("%4d", trav.data);//visit cur node
        preOrder(trav.left);//goto visit its left subtree
        preOrder(trav.right);//goto visit its right subtree 
    }

    //wrapper function
    void preOrder( ){
        if( isBSTEmpty() ){
            throw new RuntimeException("bst is empty !!!");
        }else{
            System.out.print("preorder : ");
            preOrder(root);//initialization
            System.out.println();
        }
    }

    //recursive approach:
    void inOrder(Node trav){
        //base condition
        if( trav == null )
            return;

        //LVR
        inOrder(trav.left);//goto visit its left subtree
        System.out.printf("%4d", trav.data);//visit cur node
        inOrder(trav.right);//goto visit its right subtree 
    }

    //wrapper function
    void inOrder( ){
        if( isBSTEmpty() ){
            throw new RuntimeException("bst is empty !!!");
        }else{
            System.out.print("inorder  : ");
            inOrder(root);//initialization
            System.out.println();
        }
    }

    //recursive approach:
    void postOrder(Node trav){
        //base condition
        if( trav == null )
            return;

        //LRV
        postOrder(trav.left);//goto visit its left subtree
        postOrder(trav.right);//goto visit its right subtree 
        System.out.printf("%4d", trav.data);//visit cur node
    }

    //wrapper function
    void postOrder( ){
        if( isBSTEmpty() ){
            throw new RuntimeException("bst is empty !!!");
        }else{
            System.out.print("postorder: ");
            postOrder(root);//initialization
            System.out.println();
        }
    }

    void nonRecPreOrder( ){
        if( isBSTEmpty() )
            throw new RuntimeException("BST is empty !!!");
        
        //start traversal of BST from root node
        Node trav = root;
        Stack<Node> s = new Stack<Node>();
        System.out.print("preorder : ");

        while( trav != null || !s.empty() ){//outer while loop
            
            while( trav != null ){//innner while loop
                //visit the cur node
                System.out.printf("%4d", trav.data);
                //push its right child onto the stack if it is having
                if( trav.right != null )
                    s.push(trav.right);
                //goto its left subtree
                trav = trav.left; 
            }
        
            //if stack is not empty
            if( !s.empty() ){
                //pop node from the stack and catch it into trav
                trav = s.peek(); s.pop();
            }
        }//end of outer while loop
        System.out.println();
    }

    void nonRecInOrder( ){
        if( isBSTEmpty() )
            throw new RuntimeException("BST is empty !!!");
        
        //start traversal of BST from root node
        Node trav = root;
        Stack<Node> s = new Stack<Node>();
        System.out.print("inorder  : ");

        while( trav != null || !s.empty() ){//outer while loop
            
            while( trav != null ){//innner while loop
                //push cur node onto the stack
                s.push(trav);
                //goto its left subtree
                trav = trav.left; 
            }
        
            //if stack is not empty
            if( !s.empty() ){
                //pop node from the stack and catch it into trav
                trav = s.peek(); s.pop();
                //visit the cur node
                System.out.printf("%4d", trav.data);
                //goto its right subtree
                trav = trav.right;
            }
        }//end of outer while loop
        System.out.println();
    }

    void nonRecPostOrder( ){
        if( isBSTEmpty() )
            throw new RuntimeException("BST is empty !!!");
        
        //start traversal of BST from root node
        Node trav = root;
        Stack<Node> s = new Stack<Node>();
        System.out.print("postorder: ");

        while( trav != null || !s.empty() ){//outer while loop
            
            while( trav != null ){//innner while loop
                //push cur node onto the stack
                s.push(trav);
                //goto its left subtree
                trav = trav.left; 
            }
        
            //if stack is not empty
            if( !s.empty() ){
                //pop node from the stack and catch it into trav
                trav = s.peek(); s.pop();

                if( trav.right != null && trav.right.visited == false ){
                    //push cur node onto the stack
                    s.push(trav);
                    //goto the right subtree
                    trav = trav.right;
                }else{
                    //visit the cur node mark it as visited
                    System.out.printf("%4d", trav.data);
                    trav.visited = true;
                    //make trav as null explictly -> so that control go directly to pop next node from stack
                    trav = null;
                }
            }
        }//end of outer while loop
        System.out.println();
    }

    void dfsTraversal(){
        if(isBSTEmpty() )
            throw new RuntimeException("BST is empty !!!");
        
        //start traversal from root node
        Node trav = root;
        Stack<Node> s = new Stack<Node>();

        //step-1: push root node onto the stack
        s.push(trav);

        System.out.print("dfs traversal is : ");        
        while( !s.empty() ){
            //step-2: pop node from the stack, catch it into trav and visit it
            trav = s.peek(); s.pop();
            System.out.printf("%4d", trav.data);
            
            //step-3: push right child of cur node onto the stack if it is having
            if( trav.right != null )
                s.push(trav.right);

            //step-4: push left child of cur node onto the stack if it is having
            if( trav.left != null )
                s.push(trav.left);

        }//step-5: repeat step-2, step-3 & step-4 till stack not becomes empty
        System.out.println();
    }

    void bfsTraversal(){

        if(isBSTEmpty() )
            throw new RuntimeException("BST is empty !!!");
        
        //start traversal from root node
        Node trav = root;
        Queue<Node> q = new LinkedList<Node>();

        //step-1: insert root node into the queue
        q.offer(root);

        System.out.print("bfs traversal is : ");        
        while( !q.isEmpty() ){
            //step-2: pop/delete node from the queue, catch it into trav and visit it
            trav = q.poll();
            System.out.printf("%4d", trav.data);
            
            //step-3: push/insert left child of cur node into the queue if it is having
            if( trav.left != null )
                q.offer(trav.left);

            //step-4: push/insert right child of cur node into the queue if it is having
            if( trav.right != null )
                q.offer(trav.right);

        }//step-5: repeat step-2, step-3 & step-4 till queue not becomes empty
        System.out.println();
    }

    /*  
        searchNode() function searches for a node whose data part matches with "data".
        on success -> it returns true and as an out param in ref[ 0 ] it returns ref of parent node
        and in ref[ 1 ] it returns reference node which is to be deleted.
        on failure -< it return false, ref[ 0 ] & ref[ 1 ] will be null 
        searchNode() function uses logic of binary search => O(log n).
    */
    boolean searchNode(int data, Node [] ref){
        //start travesal from root node
        Node trav = root;
        ref[ 0 ] = null;

        while( trav != null ){

            if( data == trav.data ){
                ref[ 1 ] = trav;
                return true;
            }

            ref[ 0 ] = trav;

            if( data < trav.data )//goto to search key into left subtree
                trav = trav.left;
            else
                trav = trav.right;//goto search key into right subtree 
        }

        //if node is not found in a BST
        ref[ 0 ] = null;
        ref[ 1 ] = null;
        return false;
    }


    boolean deleteNode(int data){
        Node [] ref = { null, null };

        //step-2: search a node
        //if node is not found in a BST => return false
        if( ! searchNode(data, ref) )
            return false;

        //if node is found in a BST => delete node from BST
        Node temp = ref[ 1 ];
        Node parent = ref[ 0 ];

        //node is found but if parent = null ==> node is found at root position
        if( parent == null ){
            System.out.println("node is found at root pos => temp.data : "+temp.data);
        }else{//node is found which is not at root position
            System.out.println("parent.data : "+parent.data+" temp.data : "+temp.data);
        }
        
        //logic of deletion of a node
        //case-1: if node which is to be deleted is having left subtree as well as right subtree
        if( temp.left != null && temp.right != null ){
            //traverse till inorder succ of temp
            Node succ = temp.right;
            parent = temp;//parent will follow succ

            while( succ.left != null ){
                parent = succ;
                succ = succ.left;
            }
            //assign data of succ to temp
            temp.data = succ.data;
            //assign succ to temp which is to be deleted node
            temp = succ;
        }

        //case-2: if node that we want to delete is having empty left subtree
        if( temp.left == null ){
            if( temp == root )//if temp is a root node
                root = temp.right;//its right child becomes root
            else if( temp == parent.left )//if temp is a left child of its parent
                parent.left = temp.right;
            else//if( temp == parent.right ) i.e. if temp is a right child of its parent
                parent.right = temp.right;
        }else{//case-3: if node that we want to delete is having empty right subtree
            if( temp == root )//if temp is a root node
                root = temp.left;//its right child becomes root
            else if( temp == parent.left )//if temp is a left child of its parent
                parent.left = temp.left;
            else//if( temp == parent.right ) i.e. if temp is a right child of its parent
                parent.right = temp.left;
        }

        return true;
    }

    int max(int a, int b){
        return ( ( a > b ) ? a : b );
    }

    int height(Node trav){
        if( trav == null )
            return -1;

        return ( max( height(trav.left), height(trav.right) ) +  1 );

    }

    int height(){
        if( isBSTEmpty() )
            return -1;

        return ( height(root) );//initialization
    }

    public Node leftRotation(Node axis, Node parent){
        if( axis == null || axis.right == null )
            return null;
        
        Node newaxis = axis.right;
        axis.right = newaxis.left;
        newaxis.left = axis;

        if( axis == root )//if axis is root
            root = newaxis;
        else if( axis == parent.left )//if axis is left child of its parent
            parent.left = newaxis;
        else////if axis is right child of its parent
            parent.right = newaxis;
        
        return newaxis;
    }

    public Node rightRotation(Node axis, Node parent){
        if( axis == null || axis.left == null )
            return null;
        
        Node newaxis = axis.left;
        axis.left = newaxis.right;
        newaxis.right = axis;

        if( axis == root )//if axis is root
            root = newaxis;
        else if( axis == parent.left )//if axis is left child of its parent
            parent.left = newaxis;
        else//if axis is right child of its parent
            parent.right = newaxis;
        
        return newaxis;
    }

    public void balance(Node trav, Node parent){
        //base condition
        if( trav == null )
            return;
        //calculate balance factor of cur node
        int bf = height(trav.left) - height(trav.right);

        //if node is imbalanced
        while( bf < -1 || bf > +1 ){
            if( bf < -1 ){//if node is left imbalanced => apply left rotation
                trav = leftRotation(trav, parent);
                bf += 2;//increment balance factor of a node by 2
            }else{//if( bf > +1 ) => if node is right imbalanced => apply right rotation
                trav = rightRotation(trav, parent);
                bf -= 2;////decrement balance factor of a node by 2
            }
        }
        
        //control comes here only if cur node is balanced i.e. if bf is either -1 OR 0 Or +1.
        balance(trav.left, trav);//balance left subtree of cur node
        balance(trav.right, trav);//balance right subtree of cur node

    }

    //wrapper function
    public void balance( ){
        if( !isBSTEmpty( ) )
            balance(root, null);//initialization
    }


}//end of BST class


public class BSTMain {
    public static void main(String[] args) {
        //create an empty BST
        BST t1 = new BST();            
        BST t2 = new BST();

        //Input Order for BST : 50 20 90 85 10 45 30 100 15 75 95 120 5 50
        /*        
        t1.addNode(50);
        t1.addNode(20);
        t1.addNode(90);
        t1.addNode(85);
        t1.addNode(10);
        t1.addNode(45);
        t1.addNode(30);
        t1.addNode(100);
        t1.addNode(15);
        t1.addNode(75);
        t1.addNode(95);
        t1.addNode(120);
        t1.addNode(5);
        t1.addNode(50);
        */
        t1.addNode(10);
        t1.addNode(20);
        t1.addNode(30);
        t1.addNode(40);
        t1.addNode(50);
        t1.addNode(60);
        t1.addNode(70);


        try{
            t1.preOrder();
            t1.nonRecPreOrder();
            t1.inOrder();
            t1.nonRecInOrder();
            t1.postOrder();
            t1.nonRecPostOrder();
            t1.dfsTraversal();
            t1.bfsTraversal();
        }catch(RuntimeException e){
            System.out.println( e.getMessage() );
        }

        System.out.println("height of a t1 is : "+t1.height() );

        /*
        //deletion operation on BST:
        //step-1: accept data part of a node which is to be deleted
        Scanner sc = new Scanner(System.in);
        System.out.print("enter data part of a node which is to be delete : ");
        int data = sc.nextInt();

        if( t1.deleteNode(data) )
            System.out.println("node having data part : "+data+" is found in a BST and deleted ....");
        else
            System.out.println("node having data part : "+data+" is not found ....");
        */
        
        t1.balance();

        try{
            t1.preOrder();
            t1.nonRecPreOrder();
            t1.inOrder();
            t1.nonRecInOrder();
            t1.postOrder();
            t1.nonRecPostOrder();
            t1.dfsTraversal();
            t1.bfsTraversal();
        }catch(RuntimeException e){
            System.out.println( e.getMessage() );
        }
        
        System.out.println("height of a t1 is : "+t1.height() );

        /*
        //Input Order for BST : 50 20 90 85 10 45 30 100 15 75 95 120 5 50
        t2.recAddNode(50);
        t2.recAddNode(20);
        t2.recAddNode(90);
        t2.recAddNode(85);
        t2.recAddNode(10);
        t2.recAddNode(45);
        t2.recAddNode(30);
        t2.recAddNode(100);
        t2.recAddNode(15);
        t2.recAddNode(75);
        t2.recAddNode(95);
        t2.recAddNode(120);
        t2.recAddNode(5);
        t2.recAddNode(50);

        try{
            t2.preOrder();
        }catch(RuntimeException e){
            System.out.println( e.getMessage() );

        }
        */
    
    }
}
