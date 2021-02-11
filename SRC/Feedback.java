

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fq1=request.getParameter("q1");
		String fq2=request.getParameter("q2");
		String fq3=request.getParameter("q3");
		String fq4=request.getParameter("q4");
		String fq5=request.getParameter("q5");
		String fremarks=request.getParameter("remarks");
		FeedbackBean fb=new FeedbackBean();
		fb.setQ1(fq1);
		fb.setQ2(fq2);
		fb.setQ3(fq3);
		fb.setQ4(fq4);
		fb.setQ5(fq5);
		fb.setRemarks(fremarks);
		FeedbackDAO dao = new FeedbackDAO();
		try {
			int i=dao.Feedback(fb);
			if(i>0) {
				 RequestDispatcher rd=request.getRequestDispatcher("FeedbackDisplay");
				  request.setAttribute("feedbackbean",fb); 
				  rd.forward(request, response);
			}
			else{ 
				  RequestDispatcher rd=request.getRequestDispatcher("error.html");
				  rd.include(request, response); 
				  } 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
