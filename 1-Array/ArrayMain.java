import java.util.Scanner;

class Array{
    int [] arr;
    int size;

    Array(){
        this.size = 5;
        arr = new int[ this.size ];
        for( int index = 0 ; index < arr.length ; index++ ){
            arr[ index ] = 0;
        }
    }

    Array(int size){
        this.size = size;
        arr = new int[ this.size ];
        for( int index = 0 ; index < arr.length ; index++ ){
            arr[ index ] = 0;
        }
    }

    void acceptArrayElements( ){
        Scanner sc = new Scanner(System.in);
        for( int index = 0 ; index < arr.length ; index++ ){
            System.out.print("enter arr[ "+index+" ] : ");
            arr[ index ] = sc.nextInt();
        }
    }

    void displayArrayElement( ){
        System.out.print("array elements are : ");
        for( int index = 0 ; index < arr.length ; index++ ){
            System.out.printf("%4d", arr[ index ]);
        }
        System.out.println();
    }

    //non-recursive function
    int arraySum( ){
        
        int sum = 0;

        for( int index = 0 ; index < arr.length ; index++ ){
            sum += arr[ index ];
        }
        return sum;
    }

    //recursive function
    int recArraySum(int index){
        //base condition
        if( index == arr.length )
            return 0;

        return ( arr[ index ] + recArraySum(index+1) );//modification
    }
    
    /*
    recArraySum(index+1) => recursive function call
    calling function    : recArraySum()
    called function     : recArraySum() 

    rec function call is function call for which calling function and called function are same
    */

}


public class ArrayMain {
    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.acceptArrayElements();
        arr.displayArrayElement();        
        // System.out.println("sum of array ele is : "+arr.arraySum());
        System.out.println("sum of array ele is : "+arr.recArraySum(0) );//initialization
        /*
            recArraySum() => function call => first time function calling to rec function
            calling function : main()
            called function  : recArraySum()
        */

    }    
}
