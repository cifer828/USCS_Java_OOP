package lab0a;


import static org.junit.Assert.*;
import org.junit.Test;
public class TestNumbers {
	Numbers n  =  new Numbers();
	
	@Test
	public void testSayWhat() {
		//write an   assertEquals statement here to test sayWhat() method 
		//passing '5' as its parameter and checking if it returns odd
		
		//write an assertEquals statement here to test sayWhat() method passing '4' as 
		//its parameter and checking if it returns even
		assertEquals("Test prime", "odd", n.sayWhat(5) );
		assertEquals("Test prime", "even", n.sayWhat(4) );
	}
	
	@Test
	public void testPrime() {
		assertEquals("Test prime", true, n.isPrime(5) );
	}
	
	@Test
	public void testnthPrime() {
		assertEquals("Test prime", 5, n.nthPrime(3) );
	}
}