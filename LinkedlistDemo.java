public class LinkedlistDemo{
	
	class Node{
		int element;
		Node next;

		public Node(int e, Node n){
			element = e;
			next = n;
		}
	}

	private Node head;
	private Node tail;
	private int size;

		public LinkedlistDemo(){
			head = null;
			tail = null;
			size = 0;
		}

		public void length(){
			System.out.println("The Size of Linked List : "+size+"\n");
		}

		public boolean isEmpty(){
			return size == 0;
		}

		public void addNodeAtFirstPosition(int e){
			Node newest = new Node(e, null);

			if(isEmpty()){
				head = newest;
				tail = newest;
			}
			else{
				newest.next = head;
				head = newest;
			}
			size++;
		}

		public int deleteNodeAtLastPosition(){
			if(isEmpty()){
				System.out.println("Linked list is Empty...");
				return -1;
			}
			else{
				Node p = head;
				int i=1;
				while(i < size-1){
					p = p.next;
					i++;
				}
				tail = p;
				p = p.next;
				int e = p.element;

				tail.next = null;
				size--;
				return e;
			}
		}	
		public void searchElement(int key){
			Node p = head;
			int i = 1;
			while(p != null){
				if(p.element == key)
					System.out.println("The "+key+" element at "+i+" index");
				p = p.next;
				i++;
			}
		}
		public void display(){
			Node p = head;

			int i = 0;
			System.out.print("Linked List Element : ");
			while(p != null){
				System.out.print(" "+p.element);
				p = p.next;
			}
			System.out.println();
		}

	public static void main(String[] args) {
		LinkedlistDemo l = new LinkedlistDemo();

		l.addNodeAtFirstPosition(56);
		l.addNodeAtFirstPosition(47);
		l.addNodeAtFirstPosition(68);
		l.addNodeAtFirstPosition(32);
		l.addNodeAtFirstPosition(18);
		l.addNodeAtFirstPosition(79);
		l.display();
		System.out.println("Deleted Node At Last : "+l.deleteNodeAtLastPosition());
		l.length();


		l.display();
		l.searchElement(68);
		l.length();
	}
}