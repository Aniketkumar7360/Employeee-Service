package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserDAO;
public class ChangePassAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(true);
		String userid = (String)ses.getAttribute("uid");
		String oldPass = req.getParameter("oldpass");
		String newpass = req.getParameter("newpass");
		String msg = UserDAO.getRef().changePass(userid, oldPass, newpass);
		req.setAttribute("msg", msg);
		if(msg.startsWith("Sorry"))
		  	req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);
		else
		{
			ses.invalidate(); // session end..
		  	req.getRequestDispatcher("index.jsp").forward(req, resp);
		} 	
			
	}

}
