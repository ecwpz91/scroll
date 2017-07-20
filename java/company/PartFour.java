import java.sql.*;

/**
 * The FourTwo class is an object that maintains abstraction from the Driver class
 * in order to process queries that enables a department manager with the ability to
 * add new employees to the COMPANY database using JDBC with Java as the host language.
 * @author msurbey
 * @version 1.0
 */

public class PartFour {

        private static Connection con;
	private static Statement stmt;
        private static String username;
        private static String password;
        
        /**
         * Constructs JDBC with Java as the host language object in order to process problem specific queries. 
         */
        public PartFour(String un, String pw) throws ClassNotFoundException, SQLException {
		username = un;
		password = pw;
                startConnection();
        }

        /**
         * Loads Oracle JDBC drivers and establishes a connection to Oracle Database 10g Enterprise Edition Release 10.2.0.2.0.
         */
        private void startConnection() throws ClassNotFoundException, SQLException {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g",username,password);
		con.setAutoCommit(false); //Disables auto-commit.
        }

	/**
	 * Queries the COMPANY database for employees who managers.
	 * @return ResultSet of employees who are maangers.
	 */
	private static ResultSet managerSSN() throws SQLException {
		stmt = con.createStatement();
		return stmt.executeQuery("SELECT mgrssn FROM department");

	}

	/**
	 * Public method for managerSSN().
	 * @return ResultSet og employees who are managers.
	 */
	protected static ResultSet getManagerSSN() throws SQLException {
		return managerSSN();
	}

	/**
	 * Inserts a new employee into the COMPANY database.
	 */
	protected static void insertEmployee(String fname, String minit, String lname, String ssn, String bdate, String address, String sex, String salary, String superssn, String dno, String email) throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO employee " + 
			"VALUES ('" + fname +"','" + minit + "','" + lname + "','" + ssn + "','" + bdate + "','" + address + "','" + sex + "','" + salary + "','" + superssn + "','" + dno + "','" + email + "')");
	}

	/**
	 * Inserts a new dependent into the COMPANY databse.
	 */
	protected static void insertDependent(String essn, String dependentName, String sex, String bdate, String relation) throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO dependent " +
			"VALUES ('" + essn + "','" + dependentName + "','" + sex + "','" + bdate + "','" + relation + "')");
	}

	protected static void insertWorksOn(String essn, String pno, String hours) throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO works_on " +
			"VALUES ('" + essn + "','" + pno + "','" + hours + "')");
	}

        /**
         * Closes the connection to Oracle Database 10g Enterprise Edition Release 10.2.0.2.0. 
         */
        private static void closeConnection() throws SQLException {
		stmt.close();
                con.close();
        }

        /**
         * Public method for closeConnection().
         */
        protected static void closeCon() throws SQLException {
                closeConnection();
        }
}
