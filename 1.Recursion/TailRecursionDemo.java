public class TailRecursionDemo{

	void calculateRecursive(int n){

		if(n>0){
			int k = n * n;
			System.out.println(k);
			calculateRecursive(n-1);
		}
	}

	public static void main(String[] args){
		TailRecursionDemo r = new TailRecursionDemo();
		r.calculateRecursive(5);
	}
}
// output
// 25
// 16
// 9
// 4
// 1
