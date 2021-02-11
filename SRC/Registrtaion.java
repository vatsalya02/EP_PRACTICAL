import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registrtaion")
public class Registrtaion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Registrtaion() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id=Integer.parseInt(request.getParameter("regno"));//are Strings 
		 String sname=request.getParameter("name"); 
		 String semail=request.getParameter("email");
		 String pd=request.getParameter("pswd");
		 int y=Integer.parseInt(request.getParameter("year"));
		 int sec=Integer.parseInt(request.getParameter("section"));
		  RegistrationBean rb1=new RegistrationBean();
		  rb1.setId(id); 
		  rb1.setName(sname);
		  rb1.setEmail(semail);
		  rb1.setPassword(pd);
		  rb1.setYear(y);
		  rb1.setSection(sec);
		  PrintWriter pw=response.getWriter();
		  DAO dao = new DAO();
		  try { 
			  int i=dao.StudentInsert(rb1);
			  if(i>0)
			  {
				  request.getRequestDispatcher("login.html").include(request,response);
			  } 
			  else{ 
				  RequestDispatcher rd1=request.getRequestDispatcher("error.html");
				  rd1.include(request, response); 
				  } 
		 } 
		 catch (ClassNotFoundException e) 
		  { // TODO Auto-generated catch block 
			 e.printStackTrace();
			 
		  } 
		  catch (SQLException e)
		  { //TODO Auto-generated catch block 
			  e.printStackTrace(); }//sb have details of client
			 
		 }
	}
