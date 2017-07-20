public class Driver {

	public static void main (String args[]) {
		String s;

		s = "\n***Foo.y = 4f - no variable instantiation for Foo class***";
		formatHeader(s);
		Foo.y = 4f; //there aen't any instances of the Foo class 
		System.out.printf("Foo: %s\n\n", Foo.print()); //cannot override Object
							   //static toString() method

		s = "\n*****f1 and f2 - varible instantiation for Foo class******";
		formatHeader(s);
		Foo f1 = new Foo(); //variable f1 reference to new Foo object
				    //y (static) is instantiated to deafult value
		System.out.printf("F1: %s\n", f1); //f1 dosen't carry over previoud
						 //class variable reference y (static)
		Foo f2 = new Foo(4, 20f); //variable f2 reference to new Foo object
					  //y (static) is instantiated to 20f
		System.out.printf("F2: %s\n\n", f2);

               	s = "\n***********************Foo.y = 10f;***********************";
		formatHeader(s);
		Foo.y = 10f; //class reference to variable y (static)
			     //both f1's and f2's class refence to variable y (static) is
			     //set to 10f
		System.out.printf("F1: %s\n", f1);
		System.out.printf("F2: %s\n\n", f2);

                s = "\n************************f1 setX(2)************************";
		formatHeader(s);
		f1.setX(2);
		System.out.printf("F1: %s\n", f1);
		System.out.printf("F2: %s\n", f2);

		System.out.println();
	}

	public static void formatHeader(String s) { //method to neatly format header
        	for (int i=0; i<58; i++) {
                        System.out.print("*");
                        if (i==57) {
                                System.out.println(s);
                                for (int j=0; j<58; j++)
                                        System.out.print("*");
                        }
                }
                System.out.println();
	}

}
