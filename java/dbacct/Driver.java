import java.sql.*;
import java.util.Scanner;

public class Driver {
    
    public static void main (String[] args) {
            try {
                //Variable declaration
                Scanner userInput = new Scanner(System.in);
                ResultSet results;
                String dbacct, password;

                //Attain database credentials
                System.out.print("Enter database account: ");
                dbacct = userInput.next();
                
                try {
                    //java -cp ojdbc14.jar Driver
                    password = new String(System.console().readPassword("Enter password: "));
                } catch (NullPointerException npe) {
                    System.out.print("Enter password: ");
                    password = userInput.next();
                }

                //
                PartTwo pTwo = new PartTwo(dbacct,password);

                results = pTwo.getResearchDept(); //stores results of query
                System.out.println("Employees who work in the Research Department: ");
                System.out.println("LNAME           SSN");
                System.out.println("--------------- ---------");
                while (results.next()) { //iterates through results
                        String last = results.getString(1);
                        int ssn = results.getInt(2);
                        for(int i=last.length();i<=15;i++)
                                last += " ";
                        System.out.println(last + ssn);
                }
                System.out.println();

                results = pTwo.getHoustonProdZ(); //stores results of query
                System.out.println("Employees who work in departments located in Houston\n" +
                        "and on the project 'ProductZ:'");
                System.out.println("LNAME           SSN            HOURS");
                System.out.println("--------------- --------- ----------");
                while (results.next()) { //iterates through results
                        String last = results.getString(1);
                        int ssn = results.getInt(2);
                        for(int i=last.length();i<=15;i++)
                                last += " "; 
                        int hours = results.getInt(3);
                        String hrStr = hours + "";
                        for(int i=hrStr.length();i<=10;i++)
                                hrStr = " " + hrStr;
                        System.out.println(last + ssn + hrStr);
                }

                pTwo.closeCon(); //closes database connection

        } catch (ClassNotFoundException e) {
                System.out.println("The driver could not be loaded (failed)");

        } catch (SQLException e) {
                System.out.println(e);

        }
    }
}
