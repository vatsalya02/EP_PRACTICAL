package SalesInsertion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;
import connection_sales.DButil_sales;
import bean.SalesBean;

public class Dao {
	public static int SalesInsert(SalesBean sales) throws ClassNotFoundException, SQLException {
		Connection con=DButil_sales.DBconnection();
		
		PreparedStatement stmt=con.prepareStatement("insert into Sales values(?,?,?)");
		stmt.setInt(1,sales.getItemid());
		stmt.setString(2,sales.getItemname());
		stmt.setInt(3,sales.getCost());
		int i=stmt.executeUpdate();
		con.close();
		return i;
	}
	public static void Salesdisplay(SalesBean sales) throws ClassNotFoundException, SQLException {
		Connection con=DButil_sales.DBconnection();		
	    PreparedStatement stmt=con.prepareStatement("select * from Sales");  
	    ResultSet rs=stmt.executeQuery();
	    while(rs.next()){
	    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));  
	    }  
		
	}
	public static void TotalCost(SalesBean sales) throws ClassNotFoundException, SQLException {
		Connection con=DButil_sales.DBconnection();		
	    PreparedStatement stmt=con.prepareStatement("select sum(cost) from Sales");  
	    ResultSet rs=stmt.executeQuery();  
	    while(rs.next()){  
	    System.out.println("Total cost"+rs.getInt(1));  
	    }  
		
	}

}
