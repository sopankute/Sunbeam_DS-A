public class CircularLinkedList{

	class Node{
		int element;
		Node next;
		public Node(int e, Node n){
			element = e;
			next = n;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	public CircularLinkedList(){
		head = null;
		tail = null;
		size = 0; 
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void length(){
		System.out.println("Size of List : "+size+"\n"); 
	}

	public void addNodeAtFirstPosition(int e){
		Node newest = new Node(e, null);
		if(isEmpty()){
			newest.next = newest;
			head = newest;
			tail = newest;
		}
		else{
			tail.next = newest;	// last node has first reference in next  
			newest.next = head;	// newest.next has reference of first node in head
			head = newest;		// assign newest node to head
		}
		size++;
	}

	public void addNodeAtSpecificPosition(int e, int position){

		if(position < 0 || position >= size)
			System.out.println("Invalid Position... ");
		else{
			Node newest = new Node(e, null);
			Node p = head;
			int i=1;
			while(i < position-1){
				p = p.next;
				i++;
			}
			newest.next = p.next;
			p.next = newest;
			size++;
		}
	}

	public void addNodeAtLastPosition(int e){
		Node newest = new Node(e, null);
		if(isEmpty()){
			newest.next = newest;	// assign reference to itself if it's empty list
			head = newest;			// then assign to head
		}
		else{
			newest.next = tail.next;	// assign prev next reference to next of newest node
			tail.next = newest;			// then put newest reference at tail.next of prev node
		}
		tail = newest;
		size++;
	}

	public int deleteNodeAtFirst(){
		if(isEmpty()){
			System.out.println("Circular List is Empty...");
			return -1;
		}
		else{
			int e = head.element;
			tail.next = head.next;
			head = head.next;
			size--;
			if(isEmpty()){
				head = null;
				tail = null;
			}
			return e;
		}
	}
	public int deleteNodeAtSpecificPosition(int position){
		Node p = head;

		int i=1;
		while(i < position-1){
			p = p.next;
			i++;
		}
		int e = p.next.element;
		p.next = p.next.next;
		size--;
		return e;
	}
	public int deleteNodeAtLast(){
		if(isEmpty()){
			 System.out.println("Circular linked list is Empty...");
			 return -1;
		}
		else{
			Node p = head;
			int i=1;
			while(i < size-1){
				p = p.next;
				i++;
			}
			tail = p;
			p = p.next;			// p points to the last node which is to be deleted
			tail.next = head;	// last node point to first node 
			int e = p.element;	// retreive the element at which p points to last node 
			size--;
			return e;
		}
	}
	public void display(){
		Node p = head;
		int i=0;
		System.out.print("Linked List Element : ");
		while(i < size){
			System.out.print(" "+p.element);
			p = p.next;
			i++;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		CircularLinkedList cl = new CircularLinkedList();

		cl.addNodeAtLastPosition(46);
		cl.addNodeAtLastPosition(35);
		cl.addNodeAtLastPosition(24);
		cl.addNodeAtFirstPosition(57);
		cl.addNodeAtLastPosition(13);
		cl.display();
		cl.length();

		cl.addNodeAtSpecificPosition(68, 4);
		cl.display();
		cl.length();

		System.out.println("Deleted Node At First is : "+cl.deleteNodeAtFirst());
		cl.display();
		cl.length();

		System.out.println("Deleted Node At Last is : "+cl.deleteNodeAtLast());
		cl.display();
		cl.length();

		System.out.println("Deleted Node At Specific is : "+cl.deleteNodeAtSpecificPosition(3));
		cl.display();
		cl.length();
	}
}

// ouput :
// Linked List Element :  57 46 35 24 13
// Size of List : 5

// Linked List Element :  57 46 35 68 24 13
// Size of List : 6

// Deleted Node At First is : 57
// Linked List Element :  46 35 68 24 13
// Size of List : 5

// Deleted Node At Last is : 13
// Linked List Element :  46 35 68 24
// Size of List : 4

// Deleted Node At Specific is : 68
// Linked List Element :  46 35 24
// Size of List : 3

