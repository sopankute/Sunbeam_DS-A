public class HeadRecursionDemo{

	void calculateRecursive(int n){

		if(n>0){
			calculateRecursive(n-1);	// recursive call made first
			int k = n * n;
			System.out.println(k);
		}
	}

	public static void main(String[] args){
		HeadRecursionDemo r = new HeadRecursionDemo();
		r.calculateRecursive(5);
	}
}
// output
// 1
// 4
// 9
// 16
// 25