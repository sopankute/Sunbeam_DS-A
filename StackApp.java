class Stack1{
	private int top;
	private int size;
	private long[] arr;

	Stack1(int l){
		top = -1;
		size = l;
		arr = new long[size];
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public boolean isFull(){
		return (top >= (size-1));
	}

	public void push(long x){
		arr[++top] = x;

		// top = top + 1;	// top++
		// arr[top] = x;
	}

	public long pop(){
		return arr[top--];

		// top = top - 1;	// top--
		// long x = arr[top];
		// return x;
	}

	public long peek(){
		return arr[top];
	}

	public void display(){
		System.out.print("Stack element :");
		for(int i=0; i<size; i++){
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}
}
public class StackApp{
	public static void main(String args[]){
		Stack1 s = new Stack1(6);
		s.push(12);
		s.push(13);
		s.push(17);
		s.push(19);
		s.push(24);
		s.display();	// 12 13 17 19 24 0
		System.out.println("Poped element : "+s.pop());
		s.display();	// 12 13 17 19 24 0
		s.push(52);		
		s.display();	// 12 13 17 19 52 0
		System.out.println("Poped element : "+s.pop());
		s.display();	// 12 13 17 19 52 0
		s.push(26);		
		s.display();	// 12 13 17 19 26 0 
		System.out.println("Peeked element : "+s.peek());
		s.display();	// 12 13 17 19 26 0 
		s.push(34);		
		s.display();	// 12 13 17 19 26 34 
	}
}
/*
output : 
	(int i=0; i<size; i++)
Stack element : 12 13 17 19 24 0
Poped element : 24
Stack element : 12 13 17 19 24 0
Stack element : 12 13 17 19 52 0
Poped element : 52
Stack element : 12 13 17 19 52 0
Stack element : 12 13 17 19 26 0
Peeked element : 26
Stack element : 12 13 17 19 26 0
Stack element : 12 13 17 19 26 34


	(int i=0; i<=top; i++)
Stack element : 12 13 17 19 24
Poped element : 24
Stack element : 12 13 17 19
Stack element : 12 13 17 19 52
Poped element : 52
Stack element : 12 13 17 19
Stack element : 12 13 17 19 26
Peeked element : 26
Stack element : 12 13 17 19 26
Stack element : 12 13 17 19 26 34