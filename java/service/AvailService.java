package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AvailService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String id = req.getParameter("id"); // get service id from query String 
      HttpSession ses = req.getSession(true);
      String userid = (String)ses.getAttribute("uid");  // get service avail user from session - bcos jo session login hai - wo hi service avail kar raha hai. 
      String msg = db.UserDAO.getRef().availService(userid, id);
     // System.out.println(msg);
      req.setAttribute("msg", msg);
      req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
