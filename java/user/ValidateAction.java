package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ValidateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String userid = req.getParameter("userid");
      String pass = req.getParameter("pass");
      String msg = db.UserDAO.getRef().checkId(userid, pass);
      if(msg.startsWith("Sorry"))
      {
    	 req.setAttribute("usermsg", msg);
    	 req.getRequestDispatcher("index.jsp").forward(req, res);
      }
      else
      {
    	  String ar[] = msg.split(":"); // wmode : N/Y
    	  if(ar[1].equals("N"))
    	  {
    		  HttpSession ses = req.getSession(true);
    	      ses.setAttribute("id", userid);
    	      req.setAttribute("msg", "Hello "+userid+", Plz enter ur OTP from ur Mail id");
    	  	  req.getRequestDispatcher("Verify.jsp").forward(req, res);
    	  }
    	  else
    	  {
    	    HttpSession ses = req.getSession(true); // if session exist then contd.. with that else design the new session. 
    	    ses.setAttribute("uid", userid); // set userid as session arrribute 
    	    ses.setAttribute("mode", ar[0]); //  set mode as session arrribute
            req.getRequestDispatcher("index.jsp").forward(req, res);
    	  }	    	  
      }
	}

}
