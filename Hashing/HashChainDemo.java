
public class HashChainDemo{
	
	private int ht_size;
	private Hash_List hashtable[];

	public HashChainDemo(){
		ht_size = 10;
		hashtable = new Hash_List[ht_size];
		for(int i=0; i<ht_size; i++)
			hashtable[i] = new Hash_List();
	}

	public int hashcode(int key){
		return key % ht_size;
	}

	public void insert(int element){
		int i = hashcode(element);
		hashtable[i].insertSortedOrder(element);
	}

	public boolean searchElement(int key){
		int i = hashcode(key);
		return hashtable[i].searchElement(key) != -1;
	}

	public void display(){
		for(int i=0; i<ht_size; i++){
			System.out.print("["+i+"]");
			hashtable[i].display();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HashChainDemo h = new HashChainDemo();
		h.insert(54);
		h.insert(78);
		h.insert(64);
		h.insert(92);
		h.insert(34);
		h.insert(86);
		h.insert(28);
		h.display();

		System.out.println("Element Found : "+h.searchElement(86));
	}
}

// output :
// [0]
// [1]
// [2]92-->
// [3]
// [4]34-->54-->64-->
// [5]
// [6]86-->
// [7]
// [8]28-->78-->
// [9]

// Element Found : true
