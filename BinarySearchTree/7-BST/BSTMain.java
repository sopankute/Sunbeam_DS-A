class BST{

    static class Node{
        int data;
        Node left;//reference of type Node class which refers to left child of a node if it is having
        Node right;//reference of type Node class which refers to right child of a node if it is having
    
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
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
            System.out.print("preorder traversal is : ");
            preOrder(root);//initialization
            System.out.println();
        }
    }

}//end of BST class


public class BSTMain {
    public static void main(String[] args) {
        //create an empty BST
        BST t1 = new BST();            

        //Input Order for BST : 50 20 90 85 10 45 30 100 15 75 95 120 5 50
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

        try{
            t1.preOrder();
        }catch(RuntimeException e){
            System.out.println( e.getMessage() );
        }
        

    }
}
