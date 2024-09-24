
public class LinkedList{

	// Create Node
	class Node{
		int element;
		Node next;

		public Node(int e, Node n){
			element = e;
			next = n;
		}
	}

	private Node head;		// class type variable to point List
	private Node tail;		// class type variable to point last Node
	private int size;

	// Empty List
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public int length(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public void addFirst(int e){
		Node newest = new Node(e, null);

			if(isEmpty()){
				head = newest;
				tail = newest;
			}
			else{
				// assign reference 1st node inside of head to next new node to be add first
				newest.next = head;	
				head = newest;			// assign reference of new node to head
			}

		size++;
	}

	public void addAtSpecific(int e, int position){

		if(position <= 0 || position >= size){
			System.out.println("Invalid Position");
			// return ;								// else optional
		}
		else{
			Node newest = new Node(e, null);
			Node p = head;						// for traversing elements of list

				int i=1;
				while(i < position - 1){
					p = p.next;
					i++;
				}

			newest.next = p.next;	// 1- create link bet newest node and next node
			p.next = newest;		// 2- create link bet newest node and prev node
			size++;
		}
	}

	public void addLast(int e){
		Node newest = new Node(e, null);
			if(isEmpty())
				head = newest;
			else
				tail.next = newest;

			tail = newest;
			size++;
	}

	public int removeFirst(){
		if(isEmpty()){
			System.out.println("List is Empty");
			return -1;
		}
		int e = head.element;
		head = head.next;
		size--;

		if(isEmpty())
			tail = null;
		return e;

	}


	public int removeAtSpecific(int position){

		if(position <= 0 || position >= size){
			System.out.println("Invalid Position");
			return -1;								
		}

		Node p = head;

		int i = 1;
		while(i < position -1){
			p = p.next;
			i++;
		}

		int e = p.next.element;
		p.next = p.next.next;
		size--;

		return e;
	}

	public int removeLast(){

		if(isEmpty()){
			System.out.println("List is Empty");
			return -1;
		}

		Node p = head;	
		int i=1;
		while(i < size - 1){
			p = p.next;
			i++;
		}

		tail = p;
		p = p.next;
		int e = p.element;

		tail.next = null;
		size--;
		return e;
	}

	public int searchElement(int key){
		Node p = head;

		int index = 1;
		while(p != null){
			if(p.element == key)
				return index;
			p = p.next;
			index++;
		}
		return -1;
	}

	public void insertSortedOrder(int e){
		Node newest = new Node(e, null);
		if(isEmpty()){
			head = newest;
		}
		else{
			Node p = head;
			Node q = head;

			while(p != null && e > p.element ){
				q = p;
				p = p.next;
			}
			if(p == head){
				newest.next = head;
				head = newest;
			}
			else{
				newest.next = q.next;
				q.next = newest;
			}
		}
		size++;
	}

	public void display(){
		Node p = head;
		// System.out.print("Linked List Element : ");
		while(p != null){		// run util p = null

			System.out.print(p.element+"-->");
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.addLast(3);
		l.addLast(7);
		l.addLast(1);
		l.addLast(8);
		l.display();
		System.out.println("Size : "+l.length());
		l.addLast(2);
		l.addLast(3);
		l.addLast(6);
		l.display();
		System.out.println("Size : "+l.length());
		l.addFirst(4);
		l.display();
		System.out.println("Size : "+l.length());
		l.addAtSpecific(5,3);
		l.display();
		System.out.println("Size : "+l.length());

		int element = l.removeFirst();
		System.out.println("Removed Element : "+element);	// 4
		l.display();
		System.out.println("Size : "+l.length());			// 8

		int element1 = l.removeLast();
		System.out.println("removed Last Element : "+element1);
		l.display();
		System.out.println("Size : "+l.length());


		int element2 = l.removeAtSpecific(6);
		System.out.println("removed Element At Specific : "+element2);
		l.display();
		System.out.println("Size : "+l.length());

		int position = l.searchElement(1);
		System.out.println("element At Index : "+position);


		// l.insertSortedOrder(19);
		// l.insertSortedOrder(11);
		// l.insertSortedOrder(17);
		// l.insertSortedOrder(15);
		// l.insertSortedOrder(13);
		// l.display();				// Linked List Element : 11 13 15 17 19   Sorted Order
	}
}

// output :
// Linked List Element : 3 7 1 8
// Size : 4
// Linked List Element : 3 7 1 8 2 3 6
// Size : 7
// Linked List Element : 4 3 7 1 8 2 3 6
// Size : 8
// Linked List Element : 4 3 5 7 1 8 2 3 6
// Size : 9
// Removed Element : 4
// Linked List Element : 3 5 7 1 8 2 3 6
// Size : 8
// removed Last Element : 6
// Linked List Element : 3 5 7 1 8 2 3
// Size : 7
// removed Element At Specific : 2
// Linked List Element : 3 5 7 1 8 3
// Size : 6
// element At Index : 4

