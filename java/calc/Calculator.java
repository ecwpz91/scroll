import java.util.regex.*;
import java.util.*;
import java.io.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculator {
	// These are the 8 token types. We suggest you do them in this order
    // because some tokens (like / vs // or /* ) look alike and must
    // be checked in the right order.
	public static final int INLINE_COMMENT = 0;
	public static final int WINGED_COMMENT = 1;
	public static final int EQUALS = 2;
	public static final int NUMBER = 3;
	public static final int UNARY_OPERATOR = 4;
	public static final int BINARY_OPERATOR= 5;
	public static final int PI = 6;
	public static final int E = 7;
    public static final int WHITESPACE = 8;

	// This is an array of names for each of the token types, which might be convenient for you to
	// use to print out stuff.  It's not necessary to use this to complete the project.
	public static final String[] NAME = new String[] {"inline comment", "winged comment", 
		"equals", "number", "unary operator", "binary operator","pi", "e", "whitespace"};
	
    // This is your array of regular expressions, one per token type.
    // You'll need to specify these.
	public static final String[] REGULAR_EXPRESSION = new String[] {
            // inline comments 
            "//.*\\n",
            
            // winged comments
			"/\\*.*\\*/",      
            
            // equals
            "=",
            
            // numbers
            "(\\+|-)?[0-9]*\\.?[0-9]+",    // Numbers are standard Java/C/C++ numbers.  That means that they
                                // can (but don't have to) start with a + or  -, and can be floating-point, 
                                // including having an exponent (which can also start with a + or -).
                                // NOTE: .2 is a valid number, as is 0.2, and 2. (ending with the period!)
                                // is also fine.  Also the exponent marker can be upper or lower case.
                                
            // unary operators
            "(\\+|-|\\*|/|^)",    // Implement at least:  + - * / ^   (^ is "to the power of")
            
            // binary operators
            "(sin|cos|tan|sqrt|inv|log|Sin|Cos|Tan|Sqrt|Inv|Log)",    // Implement at least:  sin cos tan sqrt inv log   (log is log base e, inv is 1/x)
            
            // pi
            "(pi|Pi|pI|PI)",    // should be pi, Pi, pI, or PI
            
            // e
            "(e|E)",    // should be e or E
            
            // whitespace
            "\\p{Space}+"
			
	};

	private int matchingIndex;
	private int position;
	private Matcher[] m;
	
	public Calculator(String input) {
        // IMPLEMENT ME (ABOUT 5 LINES)
		matchingIndex = 0;
		position = 0;
		m = new Matcher[REGULAR_EXPRESSION.length];
		Pattern p;
		for (int i=0; i<m.length; i++) {
			p = Pattern.compile(REGULAR_EXPRESSION[i], Pattern.DOTALL);
			m[i] = p.matcher(input);
		}
	}
	
    // Returns the index into the token type array corresponding to the current token
    public int getMatchingIndex() { 
        // IMPLEMENT ME (ONE LINE)
    	return matchingIndex;
    }
    
    // Returns the current position in the string after the current token has been tokenized
	public int getPosition() {
        // IMPLEMENT ME (ONE LINE)
		return position;
	}
        
    // Returns the next token
	public String nextToken() {
        // IMPLEMENT ME (ABOUT 10 LINES)
		for (int i=0; i<m.length; i++) {
			if (m[i].find(position)) {
					if (m[i].start() == position) {
						matchingIndex = i;
						position = m[i].end();
						return m[i].group().trim();
					}
			}
		}
		
		return null;
	}
    
    // This function should print all the elements of a stack bottom to top.
    // It's not necessary to implement this function but you may find it helpful
    // In implementing main() below.
    public static void printStack(ArrayList<Double> stack) {
        // IMPLEMENT ME?  (ABOUT 3 LINES)
    	System.out.print("RESULT: " + stack.get(0));
    	if (stack.size() > 1)
    		System.out.print("\tRemaining Stack: ");
    		for (int i=1; i<stack.size(); i++)
    			System.out.print(stack.get(i));
    	System.out.println();
    }
	
	// Here's the main you have to implement,  It reads STDIN into a StringBuffer,
    // creates a stack and a calculator, then lexes through the string, manipulating
    // the stack as appropriate.  In practically any error case you should print out
    // a helpful error message and try to keep going when reasonable, ~130 lines.
	public static void main(String[] args) throws IOException {
		//program's initial post
		for (int i=0; i<16; i++) {
			System.out.print("*");
			if (i==15) {
				System.out.print("\n*RPN Calculator*\n");
				for (int j=0; j<16; j++)
					System.out.print("*");
				System.out.println();
			}
		}
		
		System.out.println("Ctrl+d to exits and calculates results.");
		
		//user input through STDIN
		int character;
		StringBuffer sb = new StringBuffer();
		System.out.print(">> ");
		while ((character = System.in.read()) != -1) { //-1 is ASCII for end-of-transmission (Ctrl+d)
				sb.append((char) character);
				if (character == 10)
					System.out.print(">> ");
		}
		System.out.println();
		
		//lexing through user input
		ArrayList<Double> stk = new ArrayList<Double>();
		Calculator calc = new Calculator(sb.toString());
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
	    String str = calc.nextToken();
		while (str != null) {
			if (calc.getMatchingIndex() == 2) {
				
	
			} else if (calc.getMatchingIndex() == 3) {
				if (str.length() > 0) {
					if (stk.size() >= 1) {
						Double[] temp = new Double[stk.size()+1];
						for (int i=0; i<stk.size(); i++)
							temp[i+1] = stk.get(i);
						temp[0] = Double.parseDouble(str);
						
						stk.clear();
						for (int i=0; i<temp.length; i++)
							stk.add(temp[i]);
					} else
						stk.add(Double.parseDouble(str));	
				}
			} else if (calc.getMatchingIndex() == 4) {
				if (str.length() > 0) {
					try {
						double result = new Double(engine.eval(stk.get(0) + str + stk.get(1)).toString());
						Double[] temp = new Double[stk.size()-1];
						temp[0] = result;	
						if(temp.length>1)
							for (int i=1; i<stk.size()-1; i++)
								temp[i] = stk.get(i+1);
						
						stk.clear();
						for (int i=0; i<temp.length; i++)
							stk.add(temp[i]);
					} catch (Exception e) {
						System.out.println("Arithmetic error, check input.");
					}
				}
			} else if (calc.getMatchingIndex() == 5) {
				if (str.length() > 0) {
					try {
						double result = new Double(engine.eval("Math." + str.toLowerCase() + "(" + stk.get(0).toString() + ")").toString());
						stk.set(0, result);
					} catch (Exception e) {
						System.out.println("Arithmetic error, check input.");
					}
				}
			} else if (calc.getMatchingIndex() == 6) {
				if (str.length() > 0) {
					if (stk.size() >= 1) {
						Double[] temp = new Double[stk.size()+1];
						for (int i=0; i<stk.size(); i++)
							temp[i+1] = stk.get(i);
						temp[0] = (double) Math.PI;
						
						stk.clear();
						for (int i=0; i<temp.length; i++)
							stk.add(temp[i]);
					} else
						stk.add((double) Math.PI);
				}	
			} else if (calc.getMatchingIndex() == 7) {
				if (str.length() > 0) {
					if (stk.size() >= 1) {
						Double[] temp = new Double[stk.size()+1];
						for (int i=0; i<stk.size(); i++)
							temp[i+1] = stk.get(i);
						temp[0] = (double) Math.E;
						
						stk.clear();
						for (int i=0; i<temp.length; i++)
							stk.add(temp[i]);
					} else
						stk.add((double) Math.E);
				}
			}
			
			str = calc.nextToken();
		}
		
		System.out.println("***Stack at end***");
		Calculator.printStack(stk);
	}
}