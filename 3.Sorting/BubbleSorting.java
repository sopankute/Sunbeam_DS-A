public class BubbleSorting{
	
	public void bubbleSort(int arr []){
		int iterations=0;
        int comparisons=0;

		for(int i=arr.length-1; i>=0; i--){
			iterations++;
			for(int j=0; j<i; j++){
				comparisons++;
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println("no. of iterations are : "+iterations);
        System.out.println("no. of comparisons are: "+comparisons+"\n");
	}

	public void disp(int arr[]){
		for(int i=0; i<arr.length-1; i++)
			System.out.print(" "+arr[i]);
		System.out.println("\n");
	}

	public static void main(String[] args) {
		BubbleSorting bs = new BubbleSorting();
		int[] array = {40, 80, 90, 50, 10, 20, 30, 80, 70, 100};

		System.out.println("Array Before Sorted : ");
		bs.disp(array);
		bs.bubbleSort(array);

		System.out.println("Array after Sorted : ");
		bs.disp(array);
	}
}

// oupput :
// Array Before Sorted :
//  40 80 90 50 10 20 30 80 70

// no. of iterations are : 10
// no. of comparisons are: 45

// Array after Sorted :
//  10 20 30 40 50 70 80 80 90
