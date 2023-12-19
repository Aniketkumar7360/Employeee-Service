// Abstract Design Patterns 
package db;
import java.sql.ResultSet;
import org.apache.commons.fileupload.FileItem;
public interface UserDAO {
   // --------------------------Admin Module --------------------------	
   public String addUser(String userid,String name,String wmode,String dob,String mailid,String gender,String mobile,String address,String registeredIP,String pass,String securityqno,String securityans,String otp);    
   public String checkId(String userid,String pass);    
   public String verifyOTP(String userid,String otp);
   public String forget(String userid);
   public String changePass(String userid,String oldPass,String newpass);
   public ResultSet getProfile(String userid) throws Exception ;
   String updProfile(String userid,String name,String dob,String mailid,String gender,String mobile,String address,String securityqno,String securityans);
   ResultSet getUsers() throws Exception;
   String delUser(String userid);
   public String decpt(String str);
   String updUserStatus(String userid);
   // -------------------- Service Module --------------------------
   public String addService(String name,String photoid,String info,String office,String provider,String charges,String discount,String total,String city);
   public String updService(String id,String name,String photoid,String info,String office,String provider,String charges,String discount,String total,String city);
   public int addPhoto(FileItem ph);
   public ResultSet getPhoto(String id) throws Exception;
   public ResultSet getAllServices(String userid) throws Exception;
   public String delService(String id);
   public ResultSet getService(String id) throws Exception;
   public String availService(String userid,String id);
   public ResultSet getListOfAppliedAvailServices(String userid) throws Exception;
   public String deleteAvailService(String id);
   public ResultSet getUserApplyforServices(String userid) throws Exception;
   public ResultSet getAvailService(String sno) throws Exception;
   public ResultSet listofAllServices() throws Exception;
   public String updAvailServiceRequest(String sno,String remarks);
  // -------- Main Panel -----------------------------------------------
   public ResultSet getServices() throws Exception;
   // ----------- Contact us --------------------------------
   public String addContact(String name,String userid,String mailid,String mobile,String msg);
   public ResultSet getContactInfo() throws Exception;
   public String deleteContact(String sno);
   // ----------- Feedback Module --------------------------------
   public String addFeedback(String name,String userid,String mailid,String mobile,String msg);
   public ResultSet getFeedbackReport() throws Exception;
   public String deleteFeedback(String sno);
   // ----------------- Complaints Module -----------------
   public String addComplaint(String userid,String subject,String message);
   public ResultSet complaintsReport() throws Exception;
   public String deleteComplaint(String id);
   public ResultSet getComplaint(String id) throws Exception;
   public String complaintResolve(String sno,String resolvemsg);
   public static UserDAO getRef()
   {
      return new db.impl.UserDAOImpl();
   }
   
}

/*
   project - 2 Parts - 
     1. Public View - accessible for all - har koi dekh sakta hai - HTML Page + Images + css + JS 
     2. private View - only for developer use. - java classes + interface (Action part + Model part) - private view 
*/