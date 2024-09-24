public class MergeSorting{

	// Recursive method
	public void mergeSort(int arr[], int left, int right){
		if(left < right){
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);		// left subset
			mergeSort(arr, mid+1, right);	// right subset
			merge(arr, left, mid, right);	// to combine subsets
		}
	}

	public void merge(int arr1[], int left, int mid, int right){
		int i = left;
		int j = mid+1;
		int k = left;
		int[] arr2 = new int[right+1];

 		while(i<=mid && j<=right){
			if(arr1[i]<arr1[j]){
				arr2[k] = arr1[i];
				i++;
			}
			else{
				arr2[k] = arr1[j];
				j++;
			}

			k++;
		}
		while(i<=mid){
			arr2[k] = arr1[i];
			i++;
			k++;
		}
		while(j<=right){
			arr2[k] = arr1[j];
			j++;
			k++;
		}

		for(i=left; i<right+1; i++)
			arr1[i] = arr2[i];

	}

	public void display(int arr[]){
		for(int i=0; i<arr.length; i++)
			System.out.print(" "+arr[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		MergeSorting m = new MergeSorting();
		int[] array = {40, 80, 90, 50, 10, 20, 30, 80, 70, 100};

		System.out.println("Array Before Sorting : ");
		m.display(array);
		m.mergeSort(array, 0, array.length-1);

		System.out.println("Array After Sorting : ");
		m.display(array);
	}
}

// output :
// Array Before Sorting :
//  40 80 90 50 10 20 30 80 70 100
// Array After Sorting :
//  10 20 30 40 50 70 80 80 90 100
