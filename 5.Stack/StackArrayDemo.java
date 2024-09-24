
public class StackArrayDemo{
	final static int SIZE = 100;
	private int top;
	private int[] arr = new int[SIZE];
		public StackArrayDemo(){
			top = -1;
		}
		boolean isEmpty(){
			return (top < 0);
		}
		boolean push(int x){
			if(top >= (SIZE-1)){
				System.out.println("Stack is OverFlow...");
				return false;
			}
			else{
				arr[++top] = x;
				System.out.println("Push : "+x);
				return true;
			}
		}
		int pop(){
			if(top < 0){
				System.out.println("Stack is Empty...");
				return 0;
			}
			else{
				int x = arr[top--];
				return x;
			}
		}
		int peek(){
			if(top < 0){
				System.out.println("Stack is Empty...");
				return 0;
			}
			else{
				int x = arr[top];
				return x;
			}
		}
		public void disp(){
			System.out.print("Stack Elements : ");
			for(int i=top; i>-1; i--){
				System.out.print(" "+arr[i]);
			}
		}
	public static void main(String[] args){
		StackArrayDemo s = new StackArrayDemo();
		s.push(11);
		s.push(22);
		s.push(33);
		s.push(44);
		System.out.println(s.isEmpty());
		System.out.println("poped element : "+s.pop());
		System.out.println("poped element : "+s.pop());
		System.out.println("Top element : "+s.peek());
		System.out.print("Stack element : ");
		s.disp();
	}
}

// output : 
// Push : 11
// Push : 22
// Push : 33
// Push : 44
// false
// poped element : 44
// poped element : 33
// Top element : 22
// Stack element :  22 11