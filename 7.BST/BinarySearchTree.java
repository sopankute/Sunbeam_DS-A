public class BinarySearchTree{

	class Node{
		int element;
		Node left;		// Refers to left child of a node if it is having
		Node right;		// Refers to left child of a node if it is having
		public Node(int e, Node l, Node r){		// parameterized constructor
			element = e;
			left = l;
			right = r;
		}
	}

	Node root; // Reference of type Node class which refers to root node in a BST if it is not empty
	public BinarySearchTree(){	//	constructor
		root = null;
	}

	public boolean isEmpty(){
		return root == null;
	}

	// Iterative Approch
		// temp_root - will be assigned the reference of the root of BST
	public void insertNode(Node temp_root, int e){
		// used to store reference of Parent node to which inserting new Node
		Node temp = null; 	
		// to search place where node has to be inserted and while()travel up to temp_root becomes null
		while(temp_root != null){	
			temp = temp_root;

			if(e == temp_root.element)	// to avoid duplicate element 
				System.out.println("The element you inserted is present in BST");
			else if(e < temp_root.element)		
				temp_root = temp_root.left;		// if true - refers the left node to temp_root
			else if(e > temp_root.element)
				temp_root = temp_root.right;	// if false - refers the right node to temp_root

				// and temp refers to parent node	
		}
		Node newNode = new Node(e, null, null);

		if(isEmpty()){	// check BST is not empty
			root = newNode;
		}
		else		
			if(e < temp.element)
				temp.left = newNode;
			else	
				temp.right = newNode;
	}

	// Recursive Approch

	public Node recInsertNode(Node temp_root, int e){

		if(temp_root != null){			// to find approprite place to insert node
			if(e < temp_root.element)
				temp_root.left = recInsertNode(temp_root.left, e);
			else if(e > temp_root.element)
				temp_root.right = recInsertNode(temp_root.right, e);

		}
		else{	
			// temp_root --> null
			Node newNode = new Node(e, null ,null);
			temp_root = newNode;
		}
		return temp_root;
	}

	public void recInOrder(Node temp_root){
		if(temp_root != null){	// if it is not empty then subtree has
			recInOrder(temp_root.left);
			System.out.print(temp_root.element+" ");
			recInOrder(temp_root.right);
		}
	}

	public void recPreOrder(Node temp_root){
		if(temp_root != null){	// if it is not empty then subtree has
			System.out.print(temp_root.element+" ");
			recPreOrder(temp_root.left);
			recPreOrder(temp_root.right);
		}
	}

	public void recPostOrder(Node temp_root){
		if(temp_root != null){	// if it is not empty then subtree has
			recPostOrder(temp_root.left);
			recPostOrder(temp_root.right);
			System.out.print(temp_root.element+" ");
		}
	}

	// Iterative approch
	public boolean searchNode(int key){

		Node temp_root = root;
		while(temp_root != null){
			if(key == temp_root.element)
				return true;
			else if(key < temp_root.element)
				temp_root = temp_root.left;
			else if(key > temp_root.element)
				temp_root = temp_root.right;
		}
		return false;
	}

	// Recursive Approch
	public boolean recSearchNode(Node temp_root, int key){
		if(temp_root != null){
			if(key == temp_root.element)
				return true;
			else if(key < temp_root.element)
				return recSearchNode(temp_root.left, key);
			else if(key > temp_root.element)
				return recSearchNode(temp_root.right, key);
		}
		return false;
	}

	public boolean deleteNode(int e){
		Node p = root;
		Node pp = null;	// reference to parent of parent node
		while(p != null && p.element != e){
			pp = p;
			if(e < p.element)
				p = p.left;
			else
				p = p.right;
		}
		if(p == null)
			return false;
		if(p.left != null && p.right != null){
			Node s = p.left;
			Node ps = p;
				while(s.right != null){
					ps = s;
					s = s.right;
				}
			p.element = s.element;
			p = s;
			pp = ps;
		}
		Node c = null;
		if(p.left != null)
			c = p.left;
		else
			c = p.right;
		if(p==root)
			root = null;
		else
			if(p == pp.left)
				pp.left = c;
			else
				pp.right = c;

		return true;	

	}
	
	public int countNodes(Node temp_root){
		if(temp_root != null){
			int x = countNodes(temp_root.left);
			int y = countNodes(temp_root.right);
			return x+y+1;
		}
		return 0;
	}

	public int heightOfBST(Node temp_root){
		if(temp_root != null){
			int x = countNodes(temp_root.left);
			int y = countNodes(temp_root.right);
			if(x > y)
				return x+1;
			else
				return y+1;
		}
		return 0;
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNode(bst.root, 34);
		bst.insertNode(bst.root, 23);
		bst.insertNode(bst.root, 45);
		bst.insertNode(bst.root, 12);
		bst.insertNode(bst.root, 56);
		bst.insertNode(bst.root, 79);
		bst.insertNode(bst.root, 67);

		System.out.print("Inorder traversal : ");
		bst.recInOrder(bst.root);
		System.out.println("\nNo Of Nodes in BST : "+bst.countNodes(bst.root));
		System.out.println("Height of BST : "+(bst.heightOfBST(bst.root)-1));

		System.out.print("\nPreorder traversal : ");
		bst.recPreOrder(bst.root);
		System.out.println("\nNo Of Nodes in BST : "+bst.countNodes(bst.root));
		System.out.println("Height of BST : "+(bst.heightOfBST(bst.root)-1));

		System.out.print("\nPostorder traversal : ");
		bst.recPostOrder(bst.root);
		System.out.println();
		
		// System.out.println(bst.searchNode(56));		// true
		// System.out.println(bst.searchNode(99));		// false

		// System.out.println(bst.recSearchNode(bst.root, 67));	// true
		// System.out.println(bst.recSearchNode(bst.root, 99));	// false

		bst.deleteNode(56);
		System.out.print("Postorder traversal : ");
		bst.recPostOrder(bst.root);
		System.out.println("\nNo Of Nodes in BST : "+bst.countNodes(bst.root));
		System.out.println("Height of BST : "+(bst.heightOfBST(bst.root)-1));

		// bst.root = bst.recInsertNode(bst.root, 34);
		// bst.recInsertNode(bst.root, 23);
		// bst.recInsertNode(bst.root, 45);
		// bst.recInsertNode(bst.root, 12);
		// bst.recInsertNode(bst.root, 56);
		// bst.recInsertNode(bst.root, 79);
		// bst.recInsertNode(bst.root, 67);
		// System.out.print("Recursive insert Inorder traversal : ");
		// bst.recInOrder(bst.root);
		// System.out.println();
	}

}

// ouput : 1 
// Inorder traversal : 12 23 34 45 56 67 79
// No Of Nodes in BST : 7
// Height of BST : 4
//
// Preorder traversal : 34 23 12 45 56 79 67
// No Of Nodes in BST : 7
// Height of BST : 4
// 
// Postorder traversal : 12 23 67 79 56 45 34
// After deletion - 56
// Postorder traversal : 12 23 67 79 45 34
// No Of Nodes in BST : 6
// Height of BST : 3
// ouput : 2
// Recursive insert Inorder traversal : 12 23 34 45 56 67 79
