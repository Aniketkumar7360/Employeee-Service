package user;
import db.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ProfileAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession sess = req.getSession(true);
       String userid = (String)sess.getAttribute("uid");
	   String name = req.getParameter("name");
       String dob = req.getParameter("dob");
       String mailid = req.getParameter("mailid");
       String gender = req.getParameter("gender");
       String mobile= req.getParameter("mobile");
       String address = req.getParameter("address");
       String securityqno = req.getParameter("squestion");
       String securityans = req.getParameter("securityans");
       String msg = UserDAO.getRef().updProfile(userid, name, dob, mailid, gender, mobile, address, securityqno, securityans);
       req.setAttribute("msg", msg);
       req.getRequestDispatcher("Profile.jsp").forward(req, resp);
   }
}
