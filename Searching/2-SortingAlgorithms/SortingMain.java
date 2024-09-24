public class SortingMain {
    
    public static void displayArrayElements(int [] arr){
        System.out.print("array ele's are: ");
        for( int index = 0 ; index < arr.length ; index++ ){
            System.out.printf("%4d", arr[ index ] );
        }
        System.out.println();
    }

    /* as instructions inside this function going to execute fixed number of times i.e. this function takes constant amount of time
    hence running time of swap() function => O(1) */
    public static void swap(int [] arr, int i, int  j){
        int temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }
    
    public static void selectionSort(int [] arr){
        int iterations=0;
        int comparisons=0;

        for( int sel_pos = 0 ; sel_pos < arr.length-1 ; sel_pos++ ){//outer for loop for iterations
            iterations++;
            for( int pos = sel_pos + 1 ; pos < arr.length ; pos++ ){//inner for loop is for pos
                comparisons++;
                //if ele at sel_pos > ele at pos => swap them
                if( arr[ sel_pos ] > arr[ pos ] )
                    swap(arr, sel_pos, pos );
            }
        }

        System.out.println("no. of iterations are: "+iterations);
        System.out.println("no. of comparisons are: "+comparisons);
    }

    public static void main(String[] args) {
        //int [] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int [] arr = { 40, 80, 90, 50, 10, 20, 30, 80, 70, 100 };
        //int [] arr = { 30, 20, 60, 50, 10, 40 };

        System.out.print("bfore sorting: "); 
        displayArrayElements(arr);
        selectionSort(arr);
        System.out.print("after sorting: "); 
        displayArrayElements(arr);


    }   
}
