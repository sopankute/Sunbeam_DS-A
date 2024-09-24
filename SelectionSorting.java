public class SelectionSorting{

	public void selectionSort(int [] arr){
        int iterations=0;
        int comparisons=0;

        for(int i=0; i<arr.length-1; i++){
			iterations++;

			for(int j=i+1; j<arr.length; j++){
				comparisons++;
				if(arr[j] < arr[i]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

        System.out.println("No. of Iterations : "+iterations);
        System.out.println("No. of Comparisons : "+comparisons+"\n");
    }

     public void display(int [] arr){
        for( int index = 0 ; index < arr.length ; index++ ){
            System.out.print("  "+arr[index]);
        }
        System.out.println("\n");
    }
	public static void main(String[] args) {
		SelectionSorting s = new SelectionSorting();

		int[] array = {67, 12, 45, 35, 89, 26, 51, 7, 93};

		System.out.print("Array Element Before Sorting : ");
		s.display(array);
		s.selectionSort(array);
		System.out.print("Array Element After Sorting : ");		
		s.display(array);
	}
}