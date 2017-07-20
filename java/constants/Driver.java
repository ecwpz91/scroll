public class Driver {

	public static void main(String[] args) {
		int y = 4;
		String num = (double) y + ""; //takes care of loss of precision

		System.out.println("***Add PI***");
		System.out.println(Constants.addPI(num) + "\n");

	}
}
