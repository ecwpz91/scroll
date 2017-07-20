import java.util.StringTokenizer;

class Birthday {
	public static void main(String[] args) {
		StringTokenizer s;
		String bday, month, day, year;
		bday = "10/04/1990";
		s = new StringTokenizer(bday,"/");
		System.out.println("Month: " + s.nextToken());
		System.out.println("Day: " + s.nextToken());
		System.out.println("Year: " + s.nextToken());

		//OR
		month = bday.substring(0,2);
		day = bday.substring(3,5);
		year = bday.substring(6,10);
		System.out.println(month);
		System.out.println(day);
		System.out.println(year);

	}

}
