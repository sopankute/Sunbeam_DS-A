public class TreeRecursionDemo{

	void calculateRecursive(int n){

		if(n>0){
			calculateRecursive(n-1);
			int k = n * n;
			System.out.println(k);
			calculateRecursive(n-1);
		}
	}

	public static void main(String[] args){
		TreeRecursionDemo r = new TreeRecursionDemo();
		r.calculateRecursive(3);
	}
}
// output
// 1
// 4
// 1
// 9
// 1
// 4
// 1
