class SelectionSorting{

	public void SelectionSort(int arr[], int n){
		int iterations = 0;
		int comparision = 0;

		for(int i=0; i<arr.length-1; i++){
			iterations++;
			// int position = i;

			for(int j=i+1; j<arr.length; j++){
				comparision++;
				if(arr[j] < arr[i]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
			System.out.println("No of Iterations : "+iterations);
			System.out.println("No of comparision : "+comparision+"\n");
	}

	public void display(int arr[], int n){
		for(int i=0; i<n; i++)
			System.out.print(" "+arr[i]);
		System.out.println("\n");
	}

	public static void main(String args[]){
		SelectionSorting s = new SelectionSorting();
		int[] array = {40, 80, 90, 50, 10, 20, 30, 80, 70, 100};

		System.out.println("Array Before Sorting : ");
		s.display(array, array.length-1);
		s.SelectionSort(array, array.length-1);

		System.out.println("Array After Sorted : ");
		s.display(array, array.length-1);
	}
}

// output : 
// Array Before Sorting :
//  40 80 90 50 10 20 30 80 70

// No of Iterations : 9
// No of comparision : 45

// Array After Sorted :
//  10 20 30 40 50 70 80 80 90

