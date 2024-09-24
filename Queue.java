class Queue{
	int size = 5;
	int[] arr = new int[size];
	int front, rear;

	Queue(){
		front = -1;
		rear = -1;
	}
	boolean isEmpty(){
		if(rear == -1 || front > rear)
			return true;
		else
			return false;
	}
	boolean isFull(){
		if(front == 0 && rear == size -1)
			return true;
		else 
    		return false;	
	}
	void enqueue(int x){
		if(isFull())
			System.out.println("Queue is full...");
		else{
			if(front == -1)
				front = 0;
			rear++;
			arr[rear] = x;
		}
	}
	int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty...");
			return 0;
		}
		else{
			int x = arr[front];
			if(front > rear){
				front = -1;
				rear = -1; 
			}
			else
				front++;
			System.out.println("\n"+x+" Deleted");
			return x;
		}
	}
	void disp(){
		if(isEmpty())
			System.out.println("Queue is Empty...");
		else{
			System.out.print("Queue Elements are : ");
			for(int i=front; i<=rear; i++){
				System.out.print(" "+arr[i]);
			}
		}
	}

	public static void main(String args[]){
		Queue q = new Queue();
		q.enqueue(12);
		q.enqueue(23);
		q.enqueue(34);
		q.enqueue(45);
		q.enqueue(56);
		q.dequeue();
		q.disp();
		q.dequeue();
		q.disp();
		// q.enqueue(67);
	}
}