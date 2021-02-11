

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackDisplay
 */
@WebServlet("/FeedbackDisplay")
public class FeedbackDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FeedbackDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FeedbackBean b=(FeedbackBean) request.getAttribute("feedbackbean");
		PrintWriter pw=response.getWriter();
		pw.println("STUDENT FEEDBACK DETAILS");
		pw.println("overall teaching:"+b.getQ1());
		pw.println("subject is covered in class:"+b.getQ2());
		pw.println("English proficiency:"+b.getQ3());
		pw.println("will be on time:"+b.getQ4());
		pw.println("Any non relevant topics other than subject:"+b.getQ5());
		pw.println("Remarks:"+b.getRemarks());
		
	}

}
