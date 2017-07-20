public class InstanceCounter {
	private static int numInstances = 0; //private class variable
	//declared static because is relevant to the class as a whole
	//not just one instance, and private because it can only be retrieved
	//with an access mutator.
	
	/*
	 * protected because only this class and perhaps its subclasses are interested
	 * in the numInstances value.
	 */
	protected static int getCount() {
		return numInstances;
	}
	
	/*
	 * no setter because the value of the variable should be incremented only when
	 * a new instance is created.
	 */
	private static void addInstance() {
		numInstances++;
	}
	
	//constructor
	InstanceCounter() {
		InstanceCounter.addInstance();
	}
	
	public static void main(String[] args) {
		System.out.println("Starting with " + InstanceCounter.getCount() +
				" instances.");
		
		for (int i=0; i<500; i++)
			new InstanceCounter();
		
		System.out.println("Created " + InstanceCounter.getCount() + 
				" instances.");
	}

}
