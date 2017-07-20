import java.util.Random;

public class Apple implements Runnable {
	private String name;
	private int time;
	private Random r;

	public Apple(String s) { 
		r = new Random();
		name = s;
		time = r.nextInt(999);
	}

	public void run() {
		try {

			System.out.println("Hello world.");
			System.out.printf("%s is sleeping for %d\n", name, time);
			Thread.sleep(time); //does nothing but waits
			//allows for other things to happen
			System.out.printf("%s is done\n", name);

		} catch (Exception e) {}
	}

}
