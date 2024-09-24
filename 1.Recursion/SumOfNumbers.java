class SumOfNumbers{
	public static int sum(int n){
		return n*(n+1)/2;
	}
	public static int sumByIteration(int n){
		int total = 0, i=0;

		while(i<=n){
			total = total + i;
			i++;
		}
		return total;
	}
	public static int sumByRecursion(int n){
		if(n==0)
			return 0;
		return	sumByRecursion(n-1) + n;
	}
	public static void main(String args[]){
		System.out.println("Sum By formula: "+sum(5));
		System.out.println("Sum By Iteration: "+sumByIteration(5));
		System.out.println("Sum By Recursion: "+sumByRecursion(5));
	}
}