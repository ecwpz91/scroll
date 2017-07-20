//threads allow for multiple things to run at the same time

public class Driver {

	public static void main (String[] args) {

		//threads run at the same time
		Thread t1 = new Thread(new Apple("Green"));
		Thread t2 = new Thread(new Apple("Red"));
		Thread t3 = new Thread(new Apple("Yellow"));

		//Need to start the objects
		t1.start();
		t2.start();
		t3.start();

	}

}
