public class StackListDemo{
	class Node{
		int element;
		Node next;

		public Node(int e, Node n){
			element = e;
			next = n;
		}
	}

	private Node top;
	private int size;

	public StackListDemo(){
		top = null;
		size = 0;
	}

	public void length(){
		System.out.println("Length of Stack : "+size);
	}

	public boolean isEmpty(){
		return size==0;
	}

	// public boolean isFull(){
	// 	return size == top;
	// }

	public void push(int e){
		Node newest = new Node(e, null);
		if(isEmpty()){
			top = newest;
		}
		else{
			newest.next = top;
			top = newest;
		}
		size++;
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is in UnderFlow");
			return -1;
		}
		int e = top.element;
		top = top.next;
		size--;
		return e;
	} 

	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is in UnderFlow");
			return -1;
		}
		return top.element;
	}

	public void display(){
		Node p = top;
		System.out.print("Stack Elements : ");
		while(p != null){
			System.out.print(p.element+" ");
			p = p.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		StackListDemo s = new StackListDemo();
		s.push(5);
		s.push(2);
		s.push(3);
		s.display();
		s.length();
		System.out.println("poped element : "+s.pop());
		System.out.println("IsEmpty : "+s.isEmpty());
		System.out.println("poped element : "+s.pop());
		System.out.println("IsEmpty : "+s.isEmpty());
		s.push(7);
		s.push(9);
		s.display();
		System.out.println("top element : "+s.peek());
		s.display();
	}
}

// output : 
// 3 2 5
// Length of Stack : 3
// poped element : 3
// IsEmpty : false
// poped element : 2
// IsEmpty : false
// 9 7 5
// top element : 9
// 9 7 5
