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
public class ForgetAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userid = req.getParameter("userid");
       String msg = UserDAO.getRef().forget(userid);
       if(msg.startsWith("Sorry"))
       {
    	    req.setAttribute("usermsg", msg);
    	    req.getRequestDispatcher("index.jsp").forward(req, resp);
       }
       else
       {
    	  String ar[] = msg.split(":"); 
    	  try {  
            String[] EMAILADDR = {ar[1],"manojrajora.agile@gmail.com"}; 
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            Session mailses = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication("employmentdashboard2021","dashboard2021");//Please Provide The Sender Address
                }
            });
            mailses.setDebug(true);
            Message msgg = new MimeMessage(mailses); // Multi purpose Internet Mail Extension 
            InternetAddress addressFrom = new InternetAddress("employmentdashboard2021@gmail.com");
            msgg.setFrom(addressFrom);
            InternetAddress[] ADDRESS_TO = new InternetAddress[EMAILADDR.length];
            for (int i = 0; i < EMAILADDR.length; i++) {
              ADDRESS_TO[i] = new InternetAddress(EMAILADDR[i]);
         }
         msgg.setRecipients(Message.RecipientType.BCC, ADDRESS_TO);
        // Setting the Subject and Content Type
         msgg.setSubject("Hello "+userid+",This Mail send on your request for forget Password.");
         msgg.setContent("Hello "+userid+", this mail send on request for password recovery & ur password is - "+ar[0], "text/html");
         System.out.println("Hello "+userid+", this mail send on request for password recovery & ur password is - "+ar[0]);
         Transport.send(msgg);
         req.setAttribute("msg","your Successfully send on ur Mail Id..");
        } catch(Exception e){ req.setAttribute("msg",e.toString());}
        req.getRequestDispatcher("index.jsp").forward(req, resp);
       }
   }
}
