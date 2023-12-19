package feedback;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeleteFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  String id = req.getParameter("id");
	  String msg = db.UserDAO.getRef().deleteFeedback(id);
	  req.setAttribute("msg", msg);
	  req.getRequestDispatcher("FeedbackReport").forward(req, res);
	}

}
