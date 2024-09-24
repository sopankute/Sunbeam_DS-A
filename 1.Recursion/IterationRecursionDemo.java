class IterationRecursionDemo{

	// Iterative approch
	void calculateIterative(int n){
		while(n>0){
			int k = n * n;
			System.out.println(k);
			n = n-1;
		}
	}
	
	// Recursive approch
	void calculateRecursive(int n){
		if(n>0){
			int k = n * n;
			System.out.println(k);
			calculateRecursive(n-1);
		}
	}
	public static void main(String[] args){
		IterationRecursionDemo r = new IterationRecursionDemo();
		r.calculateIterative(5);
		r.calculateRecursive(5);
	}
}