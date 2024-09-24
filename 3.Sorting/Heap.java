public class Heap{

	private int data[];
	private int maxsize;
	private int cSize;

	public Heap(){
		maxsize = 10;
		data = new int[maxsize];
		cSize = 0;
		for(int i=0; i < data.length; i++)
			data[i] = -1;					// data is initialized to -1
	}

	public void length(){
		System.out.println("Size of Heap : "+cSize);
	}

	public boolean isEmpty(){
		return cSize == 0;
	}

	public void insert(int e){
		if(cSize == maxsize){
			System.out.println("No Space...");
		}
		else{
			cSize++;
			int h_index = cSize;

			while(h_index > 1 && e > data[h_index / 2]){
				data[h_index] = data[h_index/2];
				h_index = h_index / 2;
			}

			data[h_index] = e;
		}

	}

	public int deleteMax(){
		if(isEmpty()){
			System.out.println("Heap is Empty...");
			return -1;
		}
		int e = data[1];
		data[1] = data[cSize];
		data[cSize] = -1;
		cSize--;
		int i = 1;
		int j = i * 2;
		while(j <= cSize){
			if(data[j] < data[j+1])
				j++;
			if(data[i] < data[j]){
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;

				i=j;
				j = i * 2;
			}
			else
				break;
		}
		return e;
	}

	public int max(){
		if(isEmpty()){
			System.out.println("Heap is empty...");
			return -1;
		}
		return data[1];
	}

	public void display(){
		System.out.print("Heap Elements are : ");
		for(int i=0; i<data.length; i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}