package complaint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserDAO;
public class ComplaintAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       String subject = req.getParameter("subject");
	       String message = req.getParameter("msg");
	       HttpSession ses = req.getSession();
	       String userid = (String) ses.getAttribute("uid");  
	       if(userid==null) userid="Guest"; // if session not exist 
	       String msg = UserDAO.getRef().addComplaint(userid, subject, message);
	       req.setAttribute("msg", msg); // set msg as request attribute 
	       req.getRequestDispatcher("Complaints.jsp").forward(req, resp);
	   }
}
