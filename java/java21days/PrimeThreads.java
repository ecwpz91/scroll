public class PrimeThreads {

	public static void main(String[] args) {
		PrimeFinder[] finder = new PrimeFinder[args.length];
		for (int i=0; i<args.length; i++) {
			try {
				long count = Long.parseLong(args[i]);
				finder[i] = new PrimeFinder(count); //when a PrimeFinder object is created,
				//the object starts running its own thread (PrimeFinder constructor)
				System.out.println("Looking for prime " + count + ".");
			} catch (NumberFormatException nfe) {
				System.out.println("Error: " + nfe.getMessage());
				System.exit(-1);
			} catch (NegativeNumberException nne) {
				System.out.println("Error: " + nne.getMessage());
				System.exit(-1);
			}
		}
		
		boolean complete = false;
		while (!complete) { //checks to see whether any PrimeFinder thread has completed, indicated
			//by its finished instance variable equaling true
			complete = true;
			for (int j=0; j<finder.length; j++) {
				if (finder[j] == null) continue;
				if (!finder[j].finished) {
					complete = false;
				} else {
					System.out.println("Prime " + finder[j].target + " is " + finder[j].prime);
					finder[j] = null; //frees the object for garbage collection (preventing the 
					//object from being displayed more than once)
				}
			}
		}
		try {
			Thread.sleep(1000); //causes the while loop to pause for 1 second during each pass
			//through the loop, a slowdown in loops helps keep the Java interpreter from executing
			//statements at such a furious pacethat it becomes bogged down
		} catch (InterruptedException it) {
			//do nothing
		}
	}
}