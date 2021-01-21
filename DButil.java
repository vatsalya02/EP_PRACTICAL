package connection;
import java.sql.*;
import java.lang.ClassNotFoundException;
public class DButil {
	final static String forNameURL="com.mysql.cj.jdbc.Driver";
	final static String dBURL="jdbc:mysql://localhost:3306/epdatabase";
	final static String username="root";
	final static String password="root";
	public static Connection DBconnection() throws SQLException, ClassNotFoundException {
		
		Class.forName(forNameURL);
		Connection con=DriverManager.getConnection(dBURL,username,password);
		return con;	
	}
	
	
}