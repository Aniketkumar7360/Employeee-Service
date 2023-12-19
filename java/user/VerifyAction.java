package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class VerifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String otp = req.getParameter("otp");
      HttpSession ses = req.getSession(true);
      String userid = (String)ses.getAttribute("id");
      String msg = db.UserDAO.getRef().verifyOTP(userid, otp);
      req.setAttribute("usermsg", msg); 
      ses.setAttribute("id", null);
      req.getRequestDispatcher("index.jsp").forward(req, res);
   }

}
