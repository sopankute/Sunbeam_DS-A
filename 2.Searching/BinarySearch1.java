class BinarySearch1{
	public int searchByRecursive(int arr[], int key, int L, int R){
		if(L>R)
			return -1;
		else{
			int mid = (L+R)/2;

			if(key == arr[mid])
				return mid;
			else if(key < arr[mid])
				return searchByRecursive(arr, key, L, mid-1);
			else if(key > arr[mid])
				return searchByRecursive(arr, key, mid+1, R);
		}
		return -1;
	}
	public static void main(String args[]){
		BinarySearch1 bs1 = new BinarySearch1();

		int []array = {2, 3, 4, 6, 7, 9};		// Sorted array
		int result = bs1.searchByRecursive(array, 6, 0, array.length-1);

		if(result == -1)
			System.out.println("Key is not found");
		else
			System.out.println("Key is found at : "+result+" index");	// Key is found at : 3 index
	}
}