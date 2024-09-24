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
 public class StackApp1{
 	public static void reverse(StringBuffer str){
 		int n = str.length();
 		Stack1 s = new Stack1(n);
 		int i;
 		for(i=0; i<n; i++){
 			s.push(str.charAt(i));
 		}

 		for(i=0; i<n; i++){
 			char ch = (char)s.pop();
 			str.setCharAt(i, ch);
 		}
 	}
 	public static void main(String [] args){
 		StringBuffer sb = new StringBuffer("CDAC Mumbai");
 		reverse(sb);
 		System.out.println("reverse String : "+sb);		// reverse String : iabmuM CADC
 	}
 }