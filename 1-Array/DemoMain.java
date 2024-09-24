import java.util.Scanner;

public class DemoMain {
    
    //non-recursive function
    public static int factorial(int num){
        int fact = 1;

        while( num != 0 ){
            fact *= num--;//fact = fact * num--; 
        }
        
        return fact;
    }

    //recursive function
    public static int recFactorial(int num){
        //base condition
        if( num == 0 )
            return 1;

        return ( num * recFactorial(num-1) );//modification
        //recFactorial() -> function call => calling function & called function are same
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the value of num : ");
        int num = sc.nextInt();

        System.out.println("factorial of "+ num+ " is : "+factorial(num) );
        System.out.println("factorial of "+ num+ " is : "+recFactorial(num) );//initialization
    }    
}
