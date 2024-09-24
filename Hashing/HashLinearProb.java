public class HashLinearProb{
	private int ht_size;
	private int hashTable[];

	public HashLinearProb(){
		ht_size = 10;
		hashTable = new int[ht_size];
	}
	public int hashcode(int key){
		return key % ht_size;		// gives h(x)
	}
	public int linearProb(int element){
		int i = hashcode(element);
		int j = 0;
		while(hashTable[(i+j) % ht_size] != 0)
			j++;
		return (i+j) % ht_size;
	}
	public void insert(int element){
		int i = hashcode(element);
		if(hashTable[i] == 0)
			hashTable[i] = element;
		else{
			i = linearProb(element);
			hashTable[i] = element;
		}
	}
	public boolean search(int key){
		int i = hashcode(key);
		int j=0;
		while(hashTable[(i+j) % ht_size] != 0){
			if(hashTable[(i+j) % ht_size] == 0)
				return false;
			j++;
		}
		return true;
	}
	public void display(){
		System.out.print("Hashing Linear Probing Element :");
		for(int i=0; i<ht_size; i++)
			System.out.print(hashTable[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		HashLinearProb h = new HashLinearProb();
		h.insert(54);
		h.insert(78);
		h.insert(64);
		h.insert(92);
		h.insert(34);
		h.insert(86);
		h.insert(28);
		h.display();
		System.out.println("Element Found : "+h.search(86));
	}
}

// output :
// Hashing Linear Probing Element :0 0 92 0 54 64 34 86 78 28
// Element Found : true
