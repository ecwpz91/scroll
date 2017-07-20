import java.util.*;

public class ComicBooks {
	
	public ComicBooks() {}
	
	public static void main(String[] args) {
		//set up has table
		Hashtable<String, Float> quantity = new Hashtable<String, Float>();
		float price0 = 5.00F;
		quantity.put("pristine mint", price0);
		float price1 = 3.00F;
		quantity.put("mint", price1);
		float price2 = 2.00F;
		quantity.put("near mint", price2);
		float price3 = 1.50F;
		quantity.put("very fine", price3);
		float price4 = 1.00F;
		quantity.put("fine", price4);
		float price5 = 0.50F;
		quantity.put("good", price5);
		float price6 = 0.25F;
		quantity.put("poor", price6);
		float price7 = 0.10F;
		quantity.put("coverless", price7);
		
		//set up collection
		Comic[] comix = new Comic[5];
		comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 9240.00F);
		comix[0].setPrice((Float) quantity.get(comix[0].condition)); //condition is the hash
		//code, the get() returns an object that has to be cast to a Float (the Float argument
		//is unboxed as a float value automatically through unboxing)
		comix[1] = new Comic("Incredible Hulk","181", "near mint", 1325.00F);
		comix[1].setPrice((Float) quantity.get(comix[1].condition));
		comix[2] = new Comic("Cerebus", "1A", "good", 45.00F);
		comix[2].setPrice((Float) quantity.get(comix[2].condition));
		comix[3] = new Comic("Steve The Pirate", "1A", "pristine mint", 10000.00F);
		comix[3].setPrice((Float) quantity.get(comix[3].condition));
		comix[4] = new Comic("Mike The Noob", "100A", "coverless", 10.00F);
		comix[4].setPrice((Float) quantity.get(comix[4].condition));
		
		
		
		//print out collection
		for (int i=0; i<comix.length; i++) {
			System.out.println("Title: " + comix[i].title);
			System.out.println("Issue: " + comix[i].issueNumber);
			System.out.println("Condition: " + comix[i].condition);
			System.out.format("Price: $%,.2f%n%n", comix[i].price);
		}	
	}
}

class Comic { //helper class
	String title;
	String issueNumber;
	String condition;
	float basePrice;
	float price;
	
	public Comic(String inTitle, String inIssueNumber, String inCondition, 
			float inBasePrice) {
		title = inTitle;
		issueNumber = inIssueNumber;
		condition = inCondition;
		basePrice = inBasePrice;
	}
	
	void setPrice(float factor) {
		price = basePrice * factor;
	}
}