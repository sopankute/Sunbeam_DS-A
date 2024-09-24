public class InsertionSorting{

	public void insertionSort(int arr[]){
		int iterations = 0;
		int count = 0;
		for(int i=1; i<arr.length; i++){	// assume 1st element is sorted
			int key = arr[i];				// select element at arr[1] as key
			int position = i;				// positoin = 1
			iterations++;
															       // arr[1]
			while(position > 0 && key < arr[position-1]){ 	// 1>0 && key   < arr[0]
				arr[position] = arr[position-1];			// arr[1] = arr[0]	- shift towards right side
				position--;
				count++;
			}
			arr[position] = key;							// again arr[0] = key
		}
		System.out.println("No Of iterations : "+iterations);
		System.out.println("No Of while count : "+count+"\n");
	}

	public void disp(int arr[]){
		for(int i=0; i<arr.length-1; i++)
			System.out.print(" "+arr[i]);
		System.out.println("\n");
	}
	public static void main(String[] args) {
		InsertionSorting is = new InsertionSorting();
		int[] array = {40, 80, 90, 50, 10, 20, 30, 80, 70, 100};

		System.out.println("Array Before Sorting : ");
		is.disp(array);
		is.insertionSort(array);

		System.out.println("Array After Sorting : ");
		is.disp(array);
	}
}

// output :
// Array Before Sorting :
//  40 80 90 50 10 20 30 80 70

// No Of iterations : 9
// No Of while count : 18

// Array After Sorting :
//  10 20 30 40 50 70 80 80 90
