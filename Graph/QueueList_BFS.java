public class QueueList_BFS{

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


	public QueueList_BFS(){
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
}