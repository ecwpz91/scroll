public class Driver { 

	public static void main(String[] args) {
		Node a;
		Node b;
		Node c;

		a = new Node();
		b = new Node(4);
		c = new Node(15);

		a.setNext(b);
		b.setNext(c);
		c.setNext(a);

		Node p = a; //temporary pointer
		System.out.printf("The starting value is %s.\n", p);

		while (p.getNext().getValue() != 0) {
			System.out.printf("%s\n", p.getNext());
			p = p.getNext(); //moves the temporary pointer
		}

		System.out.printf("The ending values is %s.\n\n", p.getNext());

		p = null; //closes the loop
	}

}
