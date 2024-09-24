class LinearSearch{
	public int linearSearch(int arr[], int n, int key){
		int index = 0;
		while(index < n){
			if(arr[index] == key)
				return index;
			index++;
		}
		return -1;
	}	
	public static void main(String args[]){
		LinearSearch l = new LinearSearch();
		int[] A = {84, 21, 57, 69, 73, 23};
		int result = l.linearSearch(A, 6, 73);
		System.out.println("Result : "+result);		// 4
	}
}