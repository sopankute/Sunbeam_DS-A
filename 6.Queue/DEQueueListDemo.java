public class DEQueueListDemo{

	// Create Node
	class Node{
		int element;
		Node next;

		public Node(int e, Node n){
			element = e;
			next = n;
		}
	}

	private Node front;		
	private Node rear;	
	private int size;


	public DEQueueListDemo(){
		front = null;
		rear = null;
		size = 0;
	}

	public void length(){
		System.out.println("No of elements in Queue : "+size);
	}

	public boolean isEmpty(){
		return size==0;
	}

	public void addFirst(int e){
		Node newest = new Node(e, null);

			if(isEmpty()){
				front = newest;
				rear = newest;
			}
			else{
				// assign reference 1st node inside of head to next new node to be add first
				newest.next = front;	
				front = newest;			// assign reference of new node to head
			}

		size++;
	}

	public void addLast(int e){
		Node newest = new Node(e, null);
			if(isEmpty())
				front = newest;
			else
				rear.next = newest;

			rear = newest;
			size++;
	}

	public int removeFirst(){
		if(isEmpty()){
			System.out.println("List is Empty");
			return -1;
		}
		int e = front.element;
		front = front.next;
		size--;

		if(isEmpty())
			rear = null;
		return e;

	}

	public int removeLast(){

		if(isEmpty()){
			System.out.println("List is Empty");
			return -1;
		}

		Node p = front;	
		int i=1;
		while(i < size - 1){
			p = p.next;
			i++;
		}

		rear = p;
		p = p.next;
		int e = p.element;

		rear.next = null;
		size--;
		return e;
	}

	public int searchElement(int key){
		Node p = front;

		int index = 1;
		while(p != null){
			if(p.element == key)
				return index;
			p = p.next;
			index++;
		}
		return -1;
	}

	public int getFirst(){
		if(isEmpty()){
			System.out.println("UnderFlow");
			return -1;
		}
		return front.element;
	}

	public int getLast(){
		if(isEmpty()){
			System.out.println("UnderFlow");
			return -1;
		}
		return rear.element;
	}

	public void display(){
		Node p = front;
		System.out.print("double Ended queue Element : ");
		while(p != null){		// run util p = null

			System.out.print(p.element+" ");
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DEQueueListDemo l = new DEQueueListDemo();
		l.addLast(3);
		l.addLast(7);
		l.addLast(1);
		l.addLast(8);
		l.display();
		l.length();
		l.addLast(2);
		l.addLast(3);
		l.addLast(6);
		l.display();
		l.length();
		l.addFirst(4);
		l.display();
		l.length();

		int element1 = l.removeLast();
		System.out.println("removed Last Element : "+element1);
		l.display();
		l.length();

		int element2 = l.removeFirst();
		System.out.println("removed Last Element : "+element2);
		l.display();
		l.length();

		int position = l.searchElement(1);
		System.out.println("element At Index : "+position);
	}
}

// output :
// double Ended queue Element : 3 7 1 8
// No of elements in Queue : 4
// double Ended queue Element : 3 7 1 8 2 3 6
// No of elements in Queue : 7
// double Ended queue Element : 4 3 7 1 8 2 3 6
// No of elements in Queue : 8
// removed Last Element : 6
// double Ended queue Element : 4 3 7 1 8 2 3
// No of elements in Queue : 7
// removed Last Element : 4
// double Ended queue Element : 3 7 1 8 2 3
// No of elements in Queue : 6
// element At Index : 3
