import java.util.Scanner;

public class SearchingMain {

    public static int comparisons = 0;

    public static void displayArrayElements(int [] arr){
        System.out.print("array elements are : ");
        for( int index = 0 ; index < arr.length ; index++ ){
            System.out.printf("%4d", arr[ index ] );
        }
        System.out.println();
    }

    //non-recursive function:
    public static boolean linearSearch(int [] arr, int key){
        for( int index = 0 ; index < arr.length ; index++ ){
            comparisons++;
            if( key == arr[ index ] )//if key matches with an array element => key is found => return true
                return true;
        }
        //if key do not matches with any array element => key is not found in an array => return false
        return false;
    }

    public static boolean recLinearSearch(int [] arr, int key, int index){
        //base condition
        if( index == arr.length )//if key do not matches with any of array ele => key is not exists
            return false;

        comparisons++;
        if( key == arr[ index ] )//if key mathces with any of array element => key is found
            return true;

        return ( recLinearSearch(arr, key, index+1) );//modification
    }
    //non-recursive:
    public static boolean binarySearch(int [] arr, int key){
        int left=0;
        int right = arr.length-1;

        while( left <= right ){
            //step-2: calculate mid position
            int mid = (left+right)/2;

            //step-3: compare value of key with an ele which is at mid pos
            comparisons++;
            if( key == arr[ mid ] )//if key matches with ele at mid pos
                return true;

            //if key do not matches with mid pos ele -> we will search key either into the left subarray or into the right subarray
            if( key < arr[ mid ] )
                right = mid-1;//goto search key into the left subarray
            else
                left = mid+1;//goto search key into the right subarray
        }//step-4: repeat step-2 & step-3 till either key is  not found or max till subarray is valid

        //if key do not matches with any array element => key does not exists
        return false;
    }

    public static boolean recBinarySearch(int [] arr, int key, int left, int right){
        //base condition
        if( left > right )//if subarray is invalid => key does not exists
            return false;

        int mid = (left+right)/2;
        comparisons++;
        if( key == arr[ mid ] )//if key matches with ele at mid pos
            return true;
        
        //if key do not matches with ele at mid pos =>
        if( key < arr[ mid ] )//goto search key into the left subarray
            return ( recBinarySearch(arr, key, left, mid-1) );//modification
        else
            return ( recBinarySearch(arr, key, mid+1, right) );//modification
    }

    public static void main(String[] args) {
        int [] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        //int [] arr = { 40, 80, 90, 50, 10, 20, 30, 80, 70, 100 };

        displayArrayElements(arr);
        //step-1: accept key from user
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the value of key : ");
        int key = sc.nextInt();

        //if( linearSearch(arr, key) )
        //if( recLinearSearch(arr, key, 0) )//initialization
        
        //if( binarySearch(arr, key) )

        if( recBinarySearch(arr, key, 0, arr.length-1) )//initialization
            System.out.println(key+" is found in an array, no. of comparisons are : "+comparisons);
        else
            System.out.println(key+" is not found in an array, no. of comparisons are : "+comparisons);

    }    
}
