package user;
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
public class RegisterAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userid = req.getParameter("userid");
       String pass = req.getParameter("pass");
       String wmode = req.getParameter("wmode");
       String name = req.getParameter("name");
       String dob = req.getParameter("dob");
       String mailid = req.getParameter("mailid");
       String gender = req.getParameter("gender");
       String mobile= req.getParameter("mobile");
       String address = req.getParameter("address");
       String registeredIP = req.getRemoteAddr();
       String securityqno = req.getParameter("squestion");
       String securityans = req.getParameter("securityans");
       String otp = ""+(int)(Math.random()*1000000);
       String msg = UserDAO.getRef().addUser(userid, name,wmode, dob, mailid, gender, mobile, address, registeredIP, pass, securityqno, securityans,otp);
       req.setAttribute("msg", msg);
       if(msg.startsWith("Sorry"))
         req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
       else
       {
    	  HttpSession ses = req.getSession(true);
    	  ses.setAttribute("id",userid); 
          try {  
            String[] EMAILADDR = {mailid,"aniketksingh9430@gmail.com"}; 
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.port", "465");  // 457
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            // props.put("mail.smtp.starttls.enable", true);
            Session mailses = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication("employeeaddres70@gmail.com","npeounlewxtgozvx");//Please Provide The Sender Address
                }
            });
            mailses.setDebug(true);
            Message msgg = new MimeMessage(mailses); // Multipurpose Internet Mail Extension 
            InternetAddress addressFrom = new InternetAddress("employeeaddress70@gmail.com");
            msgg.setFrom(addressFrom);
            InternetAddress[] ADDRESS_TO = new InternetAddress[EMAILADDR.length];
            for (int i = 0; i < EMAILADDR.length; i++) {
              ADDRESS_TO[i] = new InternetAddress(EMAILADDR[i]);
         }
         msgg.setRecipients(Message.RecipientType.BCC, ADDRESS_TO);
        // Setting the Subject and Content Type
         msgg.setSubject("Hello "+userid+", ur OTP for Registration "+otp);
         msgg.setContent("Hello "+userid+", this OTP for Registration proces of Employeement Deshboard Panel - "+otp, "text/html");
         Transport.send(msgg); // mail send... 
        } catch(Exception e){ req.setAttribute("msg",e.toString());}
        req.getRequestDispatcher("Verify.jsp").forward(req, resp);
       }
   }
}
