class BinarySearch{
	public int searchByIterative(int arr[], int n, int key){
		int L = 0, R = n-1;

		while(L<=R){
			int mid = (L+R) / 2;

			if(key == arr[mid])
				return mid;
			else if(key < arr[mid])
				R = mid - 1;
			else if(key > arr[mid])
				L = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();

		int []array = {2, 3, 4, 5, 6, 7, 8, 9};			// must be required sorted array
		int result = bs.searchByIterative(array, 8, 6);
		if(result == -1)
			System.out.println("Element is not found");
		else
			System.out.println("Element is found at : "+result+" index");	// 4
	}
}