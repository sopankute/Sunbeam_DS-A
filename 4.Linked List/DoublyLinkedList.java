public class DoublyLinkedList{
	
	class Node{
		int element;
		Node next;
		Node prev;
		public Node(int e, Node n, Node p){
			element = e;
			next = n;
			prev = p;
		}
	}	

	private Node head;
	private Node tail;
	private int size;
	public DoublyLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public void length(){
		System.out.println("Size of Doubly Linked List : "+size+"\n");
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void addNodeAtFirstPosition(int e){
		Node newest = new Node(e, null, null);

		if(isEmpty()){
			head = newest;
			tail = newest;
		}
		else{
			newest.next = head;
			head.prev = newest;
			head = newest;
		}
		size++;
	}

	public void addNodeAtSpecificPosition(int e, int position){
		if(position <= 0 || position >=size){
			System.out.println("Please Enter valid Position");
		}
		Node newest = new Node(e, null, null);
		Node p = head;

		int i=1;
		while(i < position -1){
			p = p.next;
			i++;
		}
		newest.next = p.next;
		p.next.prev = newest;
		p.next = newest;
		newest.prev = p;
		size++;
	}

	public void addNodeAtLastPosition(int e){
		Node newest = new Node(e, null, null);

		if(isEmpty()){
			head = newest;
			tail = newest;
		}
		else{
			tail.next = newest;
			newest.prev = tail;
			tail = newest;
		}
		size++;
	}

	public int deleteNodeAtFirstPosition(){
		if(isEmpty()){
			System.out.println("Doubly Linked List is Empty");
			return -1;
		}
		else{
			int e = head.element;
			head = head.next;
			size--;
			if(isEmpty())
				tail = null;
			else
				head.prev = null;
			return e;
		}
	}

	public int deleteNodeAtSpecificPosition(int position){

		if(position <= 0 || position >=size){
			System.out.println("Please Enter valid Position");
			return -1;
		}
		else{
			Node p = head;

			int i=1;
			while(i < position-1){
				p = p.next;
				i++;
			}
			int e = p.next.element;
			p.next = p.next.next;
			p.next.prev = p;
			size--;
			return e;
		}
	}

	public int deleteNodeAtLastPosition(){
		if(isEmpty()){
			System.out.println("Doubly Linked List is Empty");
			return -1;
		}
		else{
			int e = tail.element;
			tail = tail.prev;
			tail.next = null;
			size--;
			return e;
		}
	}
	public void display(){
		Node p = head;
		System.out.print("Element of Doubly Linked List : ");
		while(p != null){
			System.out.print(" "+p.element);
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();

		dl.addNodeAtLastPosition(45);
		dl.addNodeAtLastPosition(17);
		dl.addNodeAtLastPosition(28);
		dl.addNodeAtLastPosition(59);
		dl.addNodeAtLastPosition(36);
		dl.display();
		dl.length();

		dl.addNodeAtFirstPosition(23);
		dl.addNodeAtFirstPosition(64);
		dl.display();
		dl.length();

		dl.addNodeAtSpecificPosition(72,4);
		dl.addNodeAtSpecificPosition(83,4);
		dl.display();
		dl.length();

		System.out.println("Deleted Node At First : "+dl.deleteNodeAtFirstPosition());
		dl.display();
		dl.length();


		System.out.println("Deleted Node At Last : "+dl.deleteNodeAtLastPosition());
		dl.display();
		dl.length();


		System.out.println("Deleted Node At Specific : "+dl.deleteNodeAtSpecificPosition(5));
		dl.display();
		dl.length();
	}
}

// ouput :
// Element of Doubly Linked List :  45 17 28 59 36
// Size of Doubly Linked List : 5

// Element of Doubly Linked List :  64 23 45 17 28 59 36
// Size of Doubly Linked List : 7

// Element of Doubly Linked List :  64 23 45 83 72 17 28 59 36
// Size of Doubly Linked List : 9

// Deleted Node At First : 64
// Element of Doubly Linked List :  23 45 83 72 17 28 59 36
// Size of Doubly Linked List : 8

// Deleted Node At Last : 36
// Element of Doubly Linked List :  23 45 83 72 17 28 59
// Size of Doubly Linked List : 7

// Deleted Node At Specific : 17
// Element of Doubly Linked List :  23 45 83 72 28 59
// Size of Doubly Linked List : 6
