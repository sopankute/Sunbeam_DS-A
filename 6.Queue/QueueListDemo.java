public class QueueListDemo{

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


	public QueueListDemo(){
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

	public void enqueue(int e){
		Node newest = new Node(e, null);
		if(isEmpty())
			front = newest;
		else
			rear.next = newest;
		rear = newest;
		size++;
	}

	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is in UnderFlow");
			return -1;
		}
		int e = front.element;
		front = front.next;
		size--;

		if(isEmpty())
			rear = null;
		return e;
	}

	public void display(){
		System.out.print("Element of Queue : ");
		Node p = front;
		while(p != null){
			System.out.print(p.element+" ");
			p = p.next;
		}
		System.out.println();

	}
	public static void main(String[] args) {
		QueueListDemo q = new QueueListDemo();

		q.enqueue(4);
		q.enqueue(1);
		q.enqueue(9);
		q.enqueue(5);
		q.display();
		q.length();
		System.out.println("Deleted element : "+q.dequeue());
		System.out.println("IsEmpty : "+q.isEmpty());
		System.out.println("Deleted element : "+q.dequeue());
		System.out.println("IsEmpty : "+q.isEmpty());
		q.enqueue(4);
		q.enqueue(8);
		q.enqueue(5);
		q.enqueue(3);
		q.display();
		q.length();
	}
}

// output :
// Element of Queue : 4 1 9 5
// No of elements in Queue : 4
// Deleted element : 4
// IsEmpty : false
// Deleted element : 1
// IsEmpty : false
// Element of Queue : 9 5 4 8 5 3
// No of elements in Queue : 6
