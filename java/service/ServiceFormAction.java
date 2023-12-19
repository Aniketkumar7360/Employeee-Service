package service;
import db.UserDAO;
import java.io.IOException;
import java.security.Security;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ServiceFormAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession ses = req.getSession(true);
       String provider = (String)ses.getAttribute("uid"); // get userid from Session 
       String name = req.getParameter("name");
       String pid = req.getParameter("pid");
       String info = req.getParameter("info");
       String office = req.getParameter("office");
       String charges = req.getParameter("charges");
       String discount = req.getParameter("discount");
       String total = req.getParameter("total");       
       String city = req.getParameter("city");
       String msg = UserDAO.getRef().addService(name, pid, info, office, provider, charges, discount,total, city);
       req.setAttribute("msg", msg);
       req.getRequestDispatcher("ServiceForm.jsp").forward(req, resp);
   }
}
