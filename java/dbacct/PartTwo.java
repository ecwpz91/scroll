import java.sql.*;

/**
 * The PartTwo class is an object that maintains abstraction from the Driver class
 * in order to process queries that enables a department manager with the ability to
 * add new employees to the COMPANY database using JDBC with Java as the host language.
 * @author msurbey
 * @version 1.0
 */
public class PartTwo {
    //Variable declaration - do not modify
    private Connection con;
    private Statement stmt;
    private String userName;
    private String password;
    // End of variables declaration

    /**
     * Constructs JDBC with Java as the host language object in order to process problem specific queries. 
     */
    public PartTwo(String un, String pw) throws ClassNotFoundException, SQLException {
            userName = un;
            password = pw;
            startConnection();
    }

    /**
     * Loads Oracle JDBC drivers and establishes a connection to Oracle Database 10g Enterprise Edition Release 10.2.0.2.0.
     */
    private void startConnection() throws ClassNotFoundException, SQLException {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g",userName,password);
            con.setAutoCommit(false); //Disables auto-commit.
    }

    /**
     * Queries the COMPANY database for employees who work in the Research Department.
     * @return ResultSet of employees who work in the Research Department.
     */
    private ResultSet researchDepartment() throws SQLException {
            stmt = con.createStatement();
            return stmt.executeQuery("SELECT lname, ssn FROM employee WHERE dno IN (SELECT dnumber FROM department WHERE dname = 'Research')");

    }

    /**
     * Public method for researchDepartment().
     * @return ResultSet of employees who work in the Research Department.
     */
    public ResultSet getResearchDept() throws SQLException {
            return researchDepartment();
    }

    /**
     * Queries the COMPANY database for employees who work in departments located in Houston and on the project 'ProductZ.'
     * @return ResultSet of employees who work in departments located in Houston and on the project 'ProductZ.'
     */
    private ResultSet houstonProdZ() throws SQLException {
            stmt = con.createStatement();
            return stmt.executeQuery("SELECT lname, ssn, sum(hours) HOURS FROM employee, works_on WHERE ssn = essn AND pno IN (SELECT pnumber " +
                    "FROM project WHERE pname = 'ProductZ') AND dno IN (SELECT dnum FROM project WHERE plocation = 'Houston') GROUP BY lname, ssn");
    }

    /**
     * Public method for houstonProdZ();
     * @return ResultSet of employees who work in departments located in Houston and on the project 'ProductZ.'
     */
    public ResultSet getHoustonProdZ() throws SQLException {
            return houstonProdZ();
    }

    /**
     * Closes the connection to Oracle Database 10g Enterprise Edition Release 10.2.0.2.0. 
     */
    private void closeConnection() throws SQLException {
            stmt.close();
            con.close();
    }

    /**
     * Public method for closeConnection().
     */
    public void closeCon() throws SQLException {
            closeConnection();
    }
}
