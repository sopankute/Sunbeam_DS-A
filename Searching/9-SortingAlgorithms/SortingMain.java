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

    public static void bubbleSort(int [] arr){
        int iterations=0;
        int comparisons=0;

        for( int it = 0 ; it < arr.length-1 ; it++ ){//outer for loop is for iterations
            iterations++;
            for( int pos = 0 ; pos < arr.length-1-it ; pos++ ){//inner for loop for pos
                comparisons++;
                //if prev pos ele > its next pos ele => if ele's are not in order
                if( arr[ pos ] > arr[ pos+1 ] ){
                    swap(arr, pos, pos+1 );
                }
            }
        }

        System.out.println("no. of iterations are : "+iterations);
        System.out.println("no. of comparisons are: "+comparisons);
    }

    public static void efficientBubbleSort(int [] arr){
        int iterations=0;
        int comparisons=0;
        boolean flag = true;

        for( int it = 0 ; it < arr.length-1 && flag == true ; it++ ){//outer for loop is for iterations
            iterations++;
            flag = false;

            for( int pos = 0 ; pos < arr.length-1-it ; pos++ ){//inner for loop for pos
                comparisons++;
                //if prev pos ele > its next pos ele => if ele's are not in order
                if( arr[ pos ] > arr[ pos+1 ] ){
                    swap(arr, pos, pos+1 );
                    flag = true;
                }
            }
        }

        System.out.println("no. of iterations are : "+iterations);
        System.out.println("no. of comparisons are: "+comparisons);
    }

    public static void insertionSort(int [] arr){

        int iterations=0;
        int while_cnt=0;

        for( int i = 1 ; i < arr.length ; i++ ){//for loop for iterations
            iterations++;
            int key = arr[ i ];
            int j = i-1;
            
            /* if index is valid && compare value of key with an ele at that index */
            while( j >= 0 && key < arr[ j ] ){
                //shift ele towards its right hand side by 1 pos
                arr[ j+1 ] = arr[ j ];
                j--;//goto prev ele

                while_cnt++;
            }
        
            //insert key at its appropriate pos
            arr[ j+1 ] = key;
        }

        System.out.println("no. of iterations are : "+iterations);
        System.out.println("while_cnt : "+while_cnt);
       
    }

    public static void quickSort(int [] arr, int left, int right){
        //base condition
        if( left >= right ){//either partition contains only 1 ele or partition is invalid -> stop apply partitionining
            return;
        }

        //if partition is valid i.e. if its size is greater than 1 => we can apply partitioning
        //setp-1: select pivot ele
        int pivot = arr[ left ];
        System.out.println("pivot : "+pivot);
        //shift ele's which are smaller than pivot towards left hand side, whereas shift ele's which
        //are greater than pivot towards right hand side
        int i = left;
        int j = right;

        while( i < j ){
            
            while( i <= right && arr[ i ] <= pivot ){
                i++;//goto next ele
            }

            while( arr[ j ] > pivot ){
                j--;//goo prev ele
            }

            //if i & j have not crossed => swap them
            if( i < j ){
                swap(arr, i, j);
            }

        }//end of outer while loop
        
        //swap pivot ele with jth pos ele
        swap(arr, left, j);

        //apply partitioning on left partition
        quickSort(arr, left, j-1);//modification

        //apply partitioning on right partition
        quickSort(arr, j+1, right);//modification
    }

    public static void merge(int [] arr, int left, int mid, int right){
        int size = right-left+1;
        //allocate memory dynamically for temp array having size "size" 
        int [] temp = new int[ size ];
        int i = left;//first ele of left subarray
        int j = mid+1;//first ele of right subarray
        int k = 0;

        //merge two already sorted subarray's into a single array i.e. into temp array in a sorted manner
        while( i <= mid && j <= right ){
            if( arr[ i ] < arr[ j ] )//if ele in LSA is smaller then it will copied first into temp array
                temp[ k++ ] = arr[ i++ ]; 
            else//if ele in RSA is smaller then it will copied first into temp array
                temp[ k++ ] = arr[ j++ ];
        }

        //copy all remaining ele's from LSA into temp as it is
        while( i <= mid ){
            temp[ k++ ] = arr[ i++ ];
        }   
        
        //copy all remaining ele's from RSA into temp as it is
        while( j <= right ){
            temp[ k++ ] = arr[ j++ ];
        }   

        //copy temp array into an original array
        k=0;
        i=left;
        while( i <= right ){
            arr[ i++ ] = temp[ k++ ];
        }
        
    }

    public static void mergeSort(int [] arr, int left, int right){
        //base condition
        if( left >= right )
            return;

        //if( left < right )
        int mid = (left+right)/2;
        mergeSort(arr, left, mid);//divide left subarray further recursively
        mergeSort(arr, mid+1, right);//divide right subarray further recursively

        merge(arr, left, mid, right);
    }


    public static void main(String[] args) {
        //int [] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        
        int [] arr = { 50, 90, 20, 100, 20, 40, 10, 80, 30, 70 };
        
        //int [] arr = { 30, 20, 60, 50, 10, 40 };

        System.out.print("bfore sorting: "); 
        displayArrayElements(arr);
        //selectionSort(arr);
        
        //bubbleSort(arr);
        //efficientBubbleSort(arr);
        //insertionSort(arr);
        //quickSort(arr, 0, arr.length-1);//initialization
        mergeSort(arr, 0, arr.length-1);//initialization


        System.out.print("after sorting: "); 
        displayArrayElements(arr);


    }   
}
