package complaint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UpdComplaintAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  String sno = req.getParameter("sno");
		  String resolvemsg = req.getParameter("resolvemsg");
		  String msg = db.UserDAO.getRef().complaintResolve(sno, resolvemsg);
		  req.setAttribute("msg", msg);
		  req.getRequestDispatcher("ComplaintsReport").forward(req, res);
	   }
}
