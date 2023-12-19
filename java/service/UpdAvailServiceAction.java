package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UpdAvailServiceAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sno = req.getParameter("sno");
		String remarks = req.getParameter("remarks");
		String msg = db.UserDAO.getRef().updAvailServiceRequest(sno, remarks);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("UserApplyforServices").forward(req, res);
	}

}
