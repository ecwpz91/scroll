/*
 * A prime number is a natural number greater than 1 that has
 * no positive divisors other than 1 and itself. This program finds the prime at a
 * specific location, for instance the 1st prime is 2... Or the 10th prime is 29...
 * ect...
 */

public class PrimeFinder implements Runnable {
	public long target; //indicates when the specified prime in the sequence has been found
	//target is the position in which there is a prime, i.e. the 1st prime position is number
	//2
	public long prime; //holds the last prime number found by the class
	public boolean finished; //indicates when a target has been reached
	private Thread runner; //holds the Thread object that this class runs in
	
	PrimeFinder(long inTarget) throws NegativeNumberException {
		if (inTarget < 0) {
			NegativeNumberException nne = new NegativeNumberException("Prime numbers cannot " +
					"be negative: \"" + inTarget + "\"");
			throw nne;
		}
		target = inTarget;
		if (runner == null) {
			runner = new Thread(this);
			runner.start(); //calls the run() of PrimeFinder / threaded class
		}
	}
	
	public void run() { //does most of the work of the thread, most computing-intensive tasks 
		long numPrimes = 0; //number of primes that have been found
		long candidate = 2; //the number that might possibly be a prime (2 is the first possible
		//prime number)
		while (numPrimes < target) { //continues until the right number of primes have been found
			if (isPrime(candidate)) { //checks to see if the candidate is prime
				//if the candidate is prime then:
				numPrimes++; //number of primes increases by 1
				prime = candidate; //the prime instance variable is set to this prime number
			}
			candidate++; //else, the candidate is increase by one and the loop starts over
		}
		finished = true; //indicates that the PrimeFinder object has found the right prime number
		//and is finished searching
	} //thread is no longer doing any work
	
	boolean isPrime(long checkNumber) { //method determines whether or not a number is prime
		double root = Math.sqrt(checkNumber);
		for (int i=2; i<=root; i++)
			if (checkNumber % i == 0) //if the number is evenly divisible by 2 or any higher number
				// (leaving a remainder of 0), it is not a prime number
				return false;
		return true;
	}
}