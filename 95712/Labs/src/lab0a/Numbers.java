package lab0a;


public class Numbers {
	public static void main(String[] args) {
		Numbers n =  new Numbers();
		System.out.println(n.sayWhat(5));
		System.out.println(n.nthPrime(4));
	}

	//fix this method
	public String sayWhat(int number) {
		if (number % 2 == 0)
			return "even";
		else
			return "odd";
	}

	//fix this method
	public boolean isPrime(int number) {
		for (int i  =  2;   i  <= Math.sqrt(number); i++) {   
			//can you improve this loop??
			if   (number %  i  ==   0) return false;
		}
		return true;
	}
	
	public int nthPrime(int n) {
		int cur = 0;
		int curPrime = 1;
		while(cur < n) {
			if (isPrime(++curPrime))
				cur++;
		}
		return curPrime;
	}
}
