package feedback;
import db.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class FeedbackAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       String mailid = req.getParameter("mailid");
       String mobile = req.getParameter("mobile");
       String message = req.getParameter("msg");
       HttpSession ses = req.getSession();
       String userid = (String) ses.getAttribute("uid");  
       if(userid==null) userid="Guest"; // if session not exist 
       String msg = UserDAO.getRef().addFeedback(name, userid, mailid, mobile, message);
       req.setAttribute("msg", msg); // set msg as request attribute 
       req.getRequestDispatcher("Feedback.jsp").forward(req, resp);
   }
}
