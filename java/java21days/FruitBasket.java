import java.util.*;

public class FruitBasket {
	public static void main(String[] args) {
		Vector<Fruit> cart = new Vector<Fruit>();
		Fruit f1 = new Fruit("Banana", 10, 1.50F);
		Fruit f2 = new Fruit("Orange", 150, 1.25F);
		Fruit f3 = new Fruit("Strawberry", 15, 0.50F);
		cart.add(f1);
		cart.add(f2);
		cart.add(f3);
		
		for (Fruit f : cart) {
			System.out.format("Fruit: %s%n", f.name);
			System.out.format("Quantity: %d%n", f.quantity);
			System.out.format("Price per " + f.name + ": %.2f%n", f.price);
			System.out.format("Total: %.2f%n%n", (f.price * f.quantity));
		}
	}
}

class Fruit {
	String name;
	int quantity;
	float price;
	
	public Fruit(String inName, int inQuantity, float inPrice) {
		name = inName;
		quantity = inQuantity;
		price = inPrice;
	}
}