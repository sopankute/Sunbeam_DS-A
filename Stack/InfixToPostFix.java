import java.util.Scanner;
class PostFix
{
	int size;
	char [] arr;
	int top;
	public PostFix(int size)
	{
		this.size = size;
		arr = new char[size];
		top = -1;
	}
	public boolean isFull()
	{
		return top==size-1;
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
	public char push(char ch)
	{
		if(isFull())
			System.out.println("Stack is full");
		
		else
			arr[++top] = ch;
		return 0;
	}
	public char peek()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			return arr[top];
		return '*';
	}
	public char pop()
	{
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			return arr[top--];
		return 0;
	}
	public void printStack()
	{
		for(char ch : arr)
			System.out.println(ch+" ");
	}
	public int preceedence(char ch)
	{
		if(ch == '^' || ch == '$')
			return 4;
		if(ch == '*' || ch == '/')
			return 3;
		if(ch == '+' || ch == '-')
			return 2;
		if(ch == '(' || ch == '[' || ch == '{')
			return 1;
		return -1;
	}
}
public class InfixToPostFix{
	public static void main(String[] args) 
	{
		PostFix pf = new PostFix(10);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Infix expression : ");
		String infix = sc.nextLine();
		String postfix="";
		int len = infix.length();

		for(int i=0;i<len;i++)
		{
			char ch = infix.charAt(i);
			switch(ch)
			{
				case '{':
				case '[':
				case '(':
						pf.push(ch);
						break;
				case ')':
				case ']':
				case '}':
						char peek = (char)pf.peek();
						while((ch == ')' && pf.peek()!='(') || (ch == ']' && pf.peek()!='[') || (ch == '}' && pf.peek()!='{'))
							postfix += pf.pop();
						char p = pf.pop();	
						break;
				case '+':
				case '-':
				case '*':
				case '/':
						while(!(pf.isEmpty()) && pf.preceedence(ch)<=pf.preceedence(pf.peek()))
							postfix += pf.pop();
						pf.push(ch);
						break;
				default :
						postfix += ch;
						break;		
			}
		}
		System.out.println(postfix);
	}
}