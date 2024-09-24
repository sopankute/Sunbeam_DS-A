import java.io.*;
import java.util.*;

public class Array1{
	public static void main(String[] args){
		int arr[] = new int[100];
		int i, n=10;

		arr[0] = 23;
		arr[1] = 15;
		arr[2] = 76;
		arr[3] = 98;
		arr[4] = 65;
		arr[5] = 34;
		arr[6] = 2;
		arr[7] = 63;
		arr[8] = 41;
		arr[9] = 53;

		for(i=0; i<n; i++)
			System.out.print(arr[i]+"  ");

		// Searching elements
		int key = 41;
		for(i=0; i<n; i++){
			if(arr[i] == key)
				break;
		}
		if(i == n)	// 3 == 10 - false
			System.out.println("\n"+key+" is Not Found");
		else
			System.out.println("\n"+key+ " is Found");

		// Delete Elements
		key = 34;
		for(i=0; i<n; i++){
			if(arr[i] == key)
				break;
		}
		for(int j=i; j<n; j++){
			arr[j] = arr[j+1];
		}
		n--;
		System.out.println(key+" has beed deleted.");
		for(i=0; i<n; i++)
			System.out.print(arr[i]+"  ");
	}
}
// output : 
// 		23  15  76  98  65  34  2  63  41  53
// 		41 is Found
// 		34 has beed deleted.
// 		23  15  76  98  65  2  63  41  53


