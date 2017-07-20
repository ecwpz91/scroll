import java.util.*;

public class CodeKeeper {
	Vector<String> list;
	String[] codes = {"aplha", "lambda", "gamma", "delta", "zeta"};
	
	public CodeKeeper (String[] userCodes) {
		list = new Vector<String>();
		//load build-in codes
		for (int i=0; i<codes.length; i++)
			addCodes(codes[i]);
		
		//load new codes
		for (int i=0; i<userCodes.length; i++)
			addCodes(userCodes[i]);
		
		//display all codes
		for(String code: list) //Object output
			System.out.println(code);
	}
	
	private void addCodes(String code) {
		if (!list.contains(code))
			list.add(code);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		CodeKeeper ck = new CodeKeeper(args);
	}
}