public class QueueArrayDemo{

	private int arr[];
	private int front;
	private int rear;
	private int size;

	public QueueArrayDemo(int n){
		arr = new int[n];
		front = 0;
		rear = 0;
		size = 0;
	}

	public void length(){
		System.out.println("The Size Of Queue : "+size);
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public boolean isFull(){
		return size == arr.length;
	}

	public void enqueue(int e){
		if(isFull()){
			System.out.println("Stack is Overflow");
			return;
		}
		else{
			arr[rear] = e;
			rear++;
			size++;
		}
	}

	public int dequeue(){
		if(isEmpty()){
			System.out.println("Stack is Underflow");
			return -1;
		}
		else{
			int e = arr[front];
			front++;
			size--;
			return e;
		}
	}

	public void display(){
		System.out.print("Queue Elements : ");
		for(int i=front; i<rear; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}


	public static void main(String[] args) {
		QueueArrayDemo q = new QueueArrayDemo(10);
		q.enqueue(5);
		q.enqueue(3);
		q.enqueue(1);
		q.display();
		q.length();
		System.out.println("Removed Element : "+q.dequeue());
		System.out.println("IsEmpty : "+q.isEmpty());
		System.out.println("Removed Element : "+q.dequeue());
		System.out.println("IsEmpty : "+q.isEmpty());
		q.enqueue(7);
		q.enqueue(5);
		q.enqueue(9);
		q.display();
		q.length();
	}
} 

// output : 
// Queue Elements : 5 3 1
// The Size Of Queue : 3
// Removed Element : 5
// IsEmpty : false
// Removed Element : 3
// IsEmpty : false
// Queue Elements : 1 7 5 9
// The Size Of Queue : 4