public class Hash_List{

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
	public Hash_List(){
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
}
