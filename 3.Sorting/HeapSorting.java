
public class HeapSorting{
	

	public void heapsort(int arr[], int n){
		Heap h = new Heap();
		for(int i=0; i<n; i++)
			h.insert(arr[i]);
		int k = n-1;

		for(int i=0; i<n; i++){
			arr[k] = h.deleteMax();
			k--;
		}
	}

	public void display(int arr[], int n){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		HeapSorting s = new HeapSorting();
		int []array = {63, 250, 835, 125, 947, 651, 28, 173,};
		System.out.print("Before Sorting : ");
		s.display(array, 8);
		s.heapsort(array, 8);
		System.out.print("After Sorting : ");
		s.display(array, 8);
	}
}