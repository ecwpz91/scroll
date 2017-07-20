/* CS-211-001
 * -------------------------------------------------------------------------------
 * Name: Michael Surbey / G#: G00495157 / Assignment: Project1 / Date: 10-11-2011 
 * -------------------------------------------------------------------------------
 * Honor Code Statement: I recieved no assistance on this assignment that
 * violates the ethical guidelines set forth by the professor and class syllabus.
 * -------------------------------------------------------------------------------
 * References:
 * http://www.shiffman.net/teaching/a2z/regex/
 * http://www.regular-expressions.info/reference.html
 *
 * -------------------------------------------------------------------------------
 * Comments:
 *
 * -------------------------------------------------------------------------------
 * Psedocode:
 *
 * -------------------------------------------------------------------------------
 * NOTE: width of source code is < 80 characters to facilitate printing
 * -------------------------------------------------------------------------------
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class Validator {

	public static void main(String[] args) {

		try {

			BufferedReader inputFile = new BufferedReader (new FileReader("input.txt"));
			String line = null; //line corresponds to one string in the file

				boolean firstname;
				boolean lastname;
				boolean address;
				boolean username;
				boolean password;

				String regex;
				Pattern p;
				Matcher m;

				//String LASTNAME;

			//while there lines left in the input file
			while ((line=inputFile.readLine())!=null) {

				String LASTNAME;

				Scanner scan = new Scanner (line);
				String validFormat = scan.findInLine("\\w+\\s\".*\"\\s\\#$");
		
				if (validFormat != null) {

					firstname = validFormat.startsWith("FIRSTNAME");
					lastname = validFormat.startsWith("LASTNAME");
					address = validFormat.startsWith("ADDRESS");
					username = validFormat.startsWith("USERNAME");
					password = validFormat.startsWith("PASSWORD");

					if (firstname == true) {

						//Find the index of the two " " quotes
						int firstQuote = validFormat.indexOf("\"");
						int secondQuote = validFormat.indexOf("\"", firstQuote + 1);

						//Substring to evaluate if it meets the required pattern criteria
						String substring = validFormat.substring(firstQuote + 1, secondQuote);

						//Facilitates proper printing format 
						String printString = validFormat.substring(0,secondQuote + 1);

						if (substring.length() <= 20 && substring.length() > 0) {

							//Pattern criteria
							regex = "^[A-Z][A-Za-z\\s]*$";
							p = Pattern.compile(regex);
							m = p.matcher(substring);

							if (m.find()) {

								//System.out.println(m.group());
								System.out.println("VALID " + printString);

							} else {

								System.out.println("XXXXX " + printString + ", MALFORMED STRING");

							}

						} else {

							System.out.println("XXXXX " + printString + ", MALFORMED STRING");

						}

      					} else if (lastname == true) {

						int firstQuote = validFormat.indexOf("\"");
						int secondQuote = validFormat.indexOf("\"", firstQuote + 1);

						String substring = validFormat.substring(firstQuote + 1, secondQuote);

						String printString = validFormat.substring(0, secondQuote + 1);
	
						if (substring.length() <= 20 && substring.length() > 0) {

							int spaceCount = 0;
							int letterCount = 0;

							for (int i=0; i<substring.length(); i++) {

								char character = substring.charAt(i);

								if (character == ' ') {

									spaceCount += 1;
									int index = i+1;

									if (index < substring.length()) {

										char letter = substring.charAt(index);
										boolean isLetter = Character.isUpperCase(letter);

										if (isLetter == true) {

											letterCount += 1;

										}

									}

								}

							}

							if (spaceCount == letterCount) {

								regex = "^[A-Z][A-Za-z\\s]*$";	
								p = Pattern.compile(regex);
								m = p.matcher(substring);

								if (m.find()) {

									LASTNAME = substring;
									System.out.println("VALID " + printString);

								} else {

									System.out.println("XXXXX " + printString + ", MALFORMED STRING");

								}

							} else {

								System.out.println("XXXXX " + printString + ", MALFORMED STRING");

							}

						} else {

							System.out.println("XXXXX " + printString + ", MALFORMED STRING");

						}

					} else if (address == true) {

						int firstQuote = validFormat.indexOf("\"");
						int secondQuote = validFormat.indexOf("\"", firstQuote + 1);

						String substring = validFormat.substring(firstQuote + 1, secondQuote);

						String printString = validFormat.substring(0, secondQuote + 1);

						regex = "^[1-9]\\d*\\s+[A-Za-z]+\\s+[A-Za-z]+([A-Za-z]+\\s+)*?(\\sAPT|#|Apt" +
							"\\s[1-9]\\d*)?,\\s[A-Za-z]+\\s+([A-Za-z]+\\s+)?([A-Za-z]+\\s+)?[A-Z]" +
							"{2}\\s\\d{5}$";
						p = Pattern.compile(regex);
						m = p.matcher(substring);

						if (m.find()) {

							System.out.println("VALID " + printString);

						} else {

							System.out.println("XXXXX " +  printString + ", MALFORMED STRING");

						}

					} else if (username == true) {

						int firstQuote = validFormat.indexOf("\"");
						int secondQuote = validFormat.indexOf("\"", firstQuote + 1);

						String substring = validFormat.substring(firstQuote + 1, secondQuote);

						String printString = validFormat.substring(0, secondQuote + 1);

						if (substring.length() >= 5 && substring.length() <= 15) {

							int totalCount = 0;
							int andCount = 0;
							int orCount = 0;

							for (int i=0; i<substring.length(); i++) {

								char character = substring.charAt(i);

								if (character == '&') {

									totalCount += 1;
									int andIndex = i+1;

									if (andIndex < substring.length()) {

										char andLetter = substring.charAt(andIndex);

										if (andLetter != '&') {

											andCount += 1;

										}

									}

								} else if (character == '|') {

									totalCount += 1;
									int orIndex = i+1;

									if (orIndex < substring.length()) {

										char orLetter = substring.charAt(orIndex);
										
										if (orLetter != '|') {

											orCount += 1;

										}

									}

								}
										
							}

							int totalAndOr = andCount + orCount;

							if (totalCount == totalAndOr) {

								//char[] userCharArray = LASTNAME.toCharArray();

								//System.out.println(LASTNAME);

								//for (int i=0; i<userCharArray.length; i++) {

									//System.out.println(i);

								//}

								regex = ".*";
								p = Pattern.compile(regex);
								m = p.matcher(substring);

								if (m.find()) {

									//System.out.println(m.group());
									System.out.println("VALID " + printString);

								} else {

									System.out.println("XXXXX " +  printString + ", MALFORMED STRING");

								}

							} else {

								System.out.println("XXXXX " +  printString + ", MALFORMED STRING");

							}
					
						} else {

							System.out.println("XXXXX " + printString + ", MALFORMED STRING");

						}

					} /*else if (password == true) {

						int firstQuote = validFormat.indexOf("\"");
						int secondQuote = validFormat.indexOf("\"", firstQuote + 1);

						String substring = validFormat.substring(firstQuote + 1, secondQuote);

						String printString = validFormat.substring(0, secondQuote + 1);

						if (substring.length() >= 5 && substring.length() <= 15) {
						
							int totalCount = 0;
							int andCount = 0;
							int orCount = 0;

							for (int i=0; i<substring.length(); i++) {

								char character = substring.charAt(i);

								if (character == '&') {

									totalCount += 1;
									int andIndex = i+1;

									if (andIndex < substring.length()) {

										char andLetter = substring.charAt(andIndex);

										if (andLetter != '&') {

											andCount += 1;

										}

									}

								} else if (character == '|') {

									totalCount += 1;
									int orIndex = i+1;

									if (orIndex < substring.length()) {

										char orLetter = substring.charAt(orIndex);
										
										if (orLetter != '|') {

											orCount += 1;

										}

									}

								}
										
							}

							int totalAndOr = andCount + orCount;

							if (totalCount == totalAndOr) {


								regex = ".+";
								p = Pattern.compile(regex);
								m = p.matcher(substring);

								if (m.find()) {

									//System.out.println(m.group());
									System.out.println("VALID " + printString);

								} else {

									System.out.println("XXXXX " +  printString + ", MALFORMED STRING");

								}

							} else {

								System.out.println("XXXXX " + printString + ", MALFORMED STRING");

							}

						} else {

							System.out.println("XXXXX " + line + ", UNRECOGNIZED FIELD");

						}

					}*/

				} else {

					System.out.println("XXXXX " + line + ", MALFORMED INPUT LINE");

				}

			}

		} catch (IOException e) {

			System.err.println("Error with file");

		}

	}

}
