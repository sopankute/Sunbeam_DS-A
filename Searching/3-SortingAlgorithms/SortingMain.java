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


    public static void main(String[] args) {
        int [] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        //int [] arr = { 40, 80, 90, 50, 10, 20, 30, 80, 70, 100 };
        //int [] arr = { 30, 20, 60, 50, 10, 40 };

        System.out.print("bfore sorting: "); displayArrayElements(arr);
        //selectionSort(arr);
        
        //bubbleSort(arr);
        //efficientBubbleSort(arr);
        insertionSort(arr);

        System.out.print("after sorting: "); displayArrayElements(arr);


    }   
}
