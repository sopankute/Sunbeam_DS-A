class Stack{
	static final int MAX = 5;
	int top;
	int[] arr = new int[MAX];

	Stack(){
		top = -1;
	}
	boolean isEmpty(){
		return (top < 0);	// true or false
	}
	boolean isFull(){
		return (top >= (MAX - 1));		// true or false
	}
	boolean push(int x){
		if(top >= (MAX - 1)){
			System.out.println("Stack Overflow");
			return false;
		}
		else{
			arr[++top] = x;
			// top++;
			// arr[top] = x;
			System.out.println("Pushed : "+x);
			return true;
		}
	}
	int pop(){
		if(top < 0){
			System.out.println("UnderFlow");
			return 0;
		}
		else{
			int x = arr[top--];
			// top--;
			return x;
		}
	}

	public static void main(String[] args){
		Stack s = new Stack();
		s.push(11);
		s.push(22);
		s.push(33);
		s.push(44);
		s.push(55);
		System.out.println("Poped : "+s.pop());
		System.out.println("Poped : "+s.pop());
		System.out.println("Poped : "+s.pop());
		s.push(66);
		s.push(77);
		System.out.println("Poped : "+s.pop());
		s.push(88);
	}
}