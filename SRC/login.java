import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public login() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String semail = request.getParameter("emailid");
		String psd = request.getParameter("pd");	
		
		try {
			Connection con=DBUtill.DBconnection();		
			PreparedStatement ps = con.prepareStatement("select email,password from Registration where email=? and password=?");
			ps.setString(1,semail);
            ps.setString(2,psd);
            ResultSet rs = ps.executeQuery();
            String dbemail,dbpassword;
			
			if(rs.next()) 
			{
				dbemail = rs.getString("email");
				dbpassword = rs.getString("password");
				
			
			if (semail.equals(dbemail) && psd.equals(dbpassword)) {
				request.getRequestDispatcher("feedback.html").include(request,response);
						
				}
			}
				else {
					request.getRequestDispatcher("login.html").include(request,response);
					
					
				}
			
			con.close();
		
		}
		catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} // sb have details of client

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
