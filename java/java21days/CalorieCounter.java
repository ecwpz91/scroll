public class CalorieCounter {
	float count;

	public CalorieCounter (float cal, float fat, float fiber) {
		if (fiber > 4)
			fiber = 4;
		count = (cal / 50) + (fat / 12) - (fiber / 5);
		assert count > 0 : "Adjusted calories < 0.";
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java CalorieCounter " +
					"calories fat fiber");
			System.exit(-1);
		}
		
		try {
			int calories = Integer.parseInt(args[0]);
			int fat = Integer.parseInt(args[1]);
			int fiber = Integer.parseInt(args[2]);
			CalorieCounter diet = new CalorieCounter(calories, fat,
					fiber);
			System.out.println("Adjusted calories: " + diet.count);
		} catch (NumberFormatException nfe) {
			System.out.println("All arguments must be numeric.");
			System.exit(-1);
		}
	}
}
