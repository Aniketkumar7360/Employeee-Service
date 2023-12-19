package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class DeleteAvailService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  String id = req.getParameter("id");
		  String msg = db.UserDAO.getRef().deleteAvailService(id);
		  req.setAttribute("msg", msg);
		  HttpSession ses = req.getSession(true);
		  String mode = (String)ses.getAttribute("mode");
		  if(mode.equals("SERVICE"))
		  	   req.getRequestDispatcher("UserApplyforServices").forward(req, res);	
		  else if(mode.equals("ADMIN"))
		  	   req.getRequestDispatcher("AppliedAvailService").forward(req, res);	
		  else 
		  	   req.getRequestDispatcher("AppliedAvailService").forward(req, res);	
    }
}
