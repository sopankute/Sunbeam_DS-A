public class QuickSorting{

	public void quickSort(int arr[], int low, int high){
		if(low < high){
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}
	public int partition(int arr[], int low, int high){
		int pivot = arr[low];
		int i = low+1;
		int j = high;
		do{

			while(i<=j && arr[i] <= pivot)
				i++;
			while(i<=j && arr[j] > pivot)
				j--;
			if(i<=j)
				swap(arr, i, j);
		}while(i<j);
		swap(arr, low, j);
		return j;
	}
	public void swap(int arr[], int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public void display(int arr[]){
		for(int i=0; i<arr.length; i++)
			System.out.print(" "+arr[i]);
		System.out.println("\n");
	}
	public static void main(String[] args) {
		QuickSorting q = new QuickSorting();
		int [] array = { 50, 90, 20, 100, 20, 40, 10, 80, 30, 70 };

		System.out.println("Array Before Sorting : ");
		q.display(array);
		q.quickSort(array, 0, array.length-1);

		System.out.println("Array After Sorted : ");
		q.display(array);
	}
}

// output :
// Array Before Sorting :
//  50 90 20 100 20 40 10 80 30 70

// Array After Sorted :
//  10 20 20 30 40 50 70 80 90 100
