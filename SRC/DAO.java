import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	public int StudentInsert(RegistrationBean sb) throws ClassNotFoundException,SQLException{
		Connection con=DBUtill.DBconnection();
		String sql="insert into Registration values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,sb.getId());
		ps.setString(2,sb.getName());
		ps.setString(3,sb.getEmail());
		ps.setString(4,sb.getPassword());
		ps.setInt(5,sb.getYear());
		ps.setInt(6,sb.getSection());
		int i=ps.executeUpdate();
		return i;
		
	}
}
