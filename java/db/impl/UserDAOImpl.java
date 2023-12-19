package db.impl;
import db.DB;
import db.UserDAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;

import org.apache.commons.fileupload.FileItem;
public class UserDAOImpl implements UserDAO
{
  @Override
  public String addUser(String userid, String name, String wmode, String dob, String mailid, String gender, String mobile, String address, String registeredIP, String pass, String securityqno, String securityans,String otp) {
     try
     {
       String str = String.format("{call addUser('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',?)}",userid,name,wmode,dob,mailid, gender, mobile, address, registeredIP, encpt(pass),securityqno,securityans,otp);
       System.out.println(str);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
       cs.execute();
       return cs.getString(1); // return out mode parameter value. 
     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
  }
  @Override
  public String checkId(String userid, String pass) {
     try
     {
       String str = String.format("{call checkId('%s','%s',?)}",userid,encpt(pass));
       System.out.println(str);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
       cs.execute();
       return cs.getString(1); // return out mode parameter value. 
     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
  }
  @Override
  public String verifyOTP(String userid, String otp) {
     try
     {
       String str = String.format("{call verifyOTP('%s','%s',?)}",userid,otp);
       System.out.println(str);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
       cs.execute();
       return cs.getString(1); // return out mode parameter value. 
     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
   }
   @Override
   public String forget(String userid) {
      try
      {
        String str = String.format("{call forget('%s',?)}",userid);
        System.out.println(str);
        CallableStatement cs = db.DB.getCon().prepareCall(str);
        cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
        cs.execute();
        String msg = cs.getString(1); // return out mode parameter value.
        if(!msg.startsWith("Sorry"))
        {
     	  String ar[] = msg.split(":");
    	  msg = decpt(ar[0])+":"+ar[1];
        }
        return msg;
     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
  }
  private String encpt(String str)
  {
	 char ar[] = str.toCharArray();
	 int ctr = 0;
	 for(int i=0;i<ar.length;i++)
	 {
		 if(ctr%2==0)
			ar[i] = (char)(ar[i]-3);
		 else
   	        ar[i] = (char)(ar[i]+3);
		ctr++;	
	 }
	 return new String(ar);
  }
  public String decpt(String str)
  {
	 char ar[] = str.toCharArray();
	 int ctr = 0;
	 for(int i=0;i<ar.length;i++)
	 {
		 if(ctr%2==0)
			ar[i] = (char)(ar[i]+3);
		 else
   	        ar[i] = (char)(ar[i]-3);
		ctr++;	
	 }
	 return new String(ar);
  }
  @Override
  public String changePass(String userid, String oldPass, String newpass) {
      try
      {
        String str = String.format("{call changePass('%s','%s','%s',?)}",userid,encpt(oldPass),encpt(newpass));
        System.out.println(str);
        CallableStatement cs = db.DB.getCon().prepareCall(str);
        cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
        cs.execute();
        return cs.getString(1);
     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
  }
  @Override
  public ResultSet getProfile(String userid) throws Exception
  {
	  CallableStatement cs = db.DB.getCon().prepareCall("{call getProfile(?)}");
	  cs.setString(1, userid);
	  return cs.executeQuery(); 
  }
  @Override
  public String updProfile(String userid, String name, String dob, String mailid, String gender, String mobile, String address, String securityqno, String securityans) 
  {
		try
		{
			   String str = String.format("{call updProfile('%s','%s','%s','%s','%s','%s','%s','%s','%s',?)}",userid,name,dob,mailid, gender, mobile, address,securityqno,securityans);
		       System.out.println(str);
		       CallableStatement cs = db.DB.getCon().prepareCall(str);
		       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
		       cs.execute();
		       return cs.getString(1); // return out mode parameter value. 
		}
		catch(Exception ex) {  return "Sorry exception is - "+ex; } 
	}
    @Override
    public ResultSet getUsers() throws Exception {
       return db.DB.getCon().prepareCall("{ call getUsers()}").executeQuery();
    }
    @Override
   	public String delUser(String userid) {
      try
      {
        String str = String.format("{call delUser('%s',?) } ",userid);
        CallableStatement cs = db.DB.getCon().prepareCall(str);
        cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
        cs.execute();
        return cs.getString(1); // return out mode parameter value. 
      }catch(Exception ex) { return ex.getMessage();  }
    }  
    @Override
    public String updUserStatus(String userid) {
       try
       {
           String str = String.format("{call updUserStatus('%s',?) } ",userid);
           CallableStatement cs = db.DB.getCon().prepareCall(str);
           cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
           cs.execute();
           return cs.getString(1); // return out mode parameter value. 
        }catch(Exception ex) { return ex.getMessage();  }
    }
   //    ----   Service Module Business Logics --------------------
  @Override
	public String addService(String name, String photoid, String info, String office, String provider, String charges, String discount,String total, String city) 
    {
	     try
	     {
	       String str = String.format("{call addUpdService('I',0,'%s',%s,'%s','%s','%s','%s','%s',%s,'%s',?)}",name,photoid,info,office,provider,charges,discount,total,city);
	       System.out.println(str);
	       CallableStatement cs = db.DB.getCon().prepareCall(str);
	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
	       cs.execute();
	       return cs.getString(1); // return out mode parameter value. 
	     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
    }
    @Override
    public String updService(String id, String name, String photoid, String info, String office, String provider, String charges, String discount,String total, String city)
    {
        try
	     {
	       String str = String.format("{call addUpdService('U',%s,'%s',%s,'%s','%s','%s','%s','%s',%s,'%s',?)}",id,name,photoid,info,office,provider,charges,discount,total,city);
	       System.out.println(str);
	       CallableStatement cs = db.DB.getCon().prepareCall(str);
	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
	       cs.execute();
	       return cs.getString(1); // return out mode parameter value. 
	     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
    }
    @Override
    public int addPhoto(FileItem ph) 
    {
        try
	     {
	       String str = String.format("{call addPhoto(?,?) } ");
	       CallableStatement cs = db.DB.getCon().prepareCall(str);
	       cs.setBinaryStream(1, ph.getInputStream());
	       System.out.println(ph.getInputStream());
	       cs.registerOutParameter(2,Types.NUMERIC); // register out mode parameter as varchar for return
	       cs.execute();
	       return cs.getInt(2); // return out mode parameter value. 
	     }catch(Exception ex) { System.out.println(ex); return 0;  }
    }
    @Override
    public ResultSet getPhoto(String id) throws Exception 
    {
       CallableStatement cs = DB.getCon().prepareCall("{call getPhoto(?) }");
       cs.setString(1, id);
       return cs.executeQuery();
    }
    @Override
    public ResultSet getAllServices(String userid) throws Exception 
    {
        CallableStatement cs = DB.getCon().prepareCall("{call getAllServices(?) }");
        cs.setString(1, userid); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedure execute & return procedure data as ResultSet
    }
    @Override
    public String delService(String id) 
    {
        try
	    {
	       String str = String.format("{call delService(%s,?) } ",id);
	       CallableStatement cs = db.DB.getCon().prepareCall(str);
	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
	       cs.execute();
	       return cs.getString(1); // return out mode parameter value. 
	     }catch(Exception ex) { return ex.getMessage();  }
   	}
    @Override
    public ResultSet getService(String id) throws Exception 
    {
        CallableStatement cs = DB.getCon().prepareCall("{call getService(?) }");
        cs.setString(1, id); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedure execute & return procedure data as ResultSet
    }
    @Override
    public ResultSet getServices() throws Exception 
    {
    		return DB.getCon().prepareCall("{call getServices()}").executeQuery();
    }
    @Override
    public ResultSet listofAllServices() throws Exception 
    {
    		return DB.getCon().prepareCall("{call listofAllServices()}").executeQuery();
    }
    @Override
    public String availService(String userid, String id) {
        try
	    {
	       String str = String.format("{call availService('%s',%s,?) } ",userid,id);
	       CallableStatement cs = db.DB.getCon().prepareCall(str);
	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
	       cs.execute();
	       return cs.getString(1); // return out mode parameter value. 
	     }catch(Exception ex) { return ex.getMessage();  }
   	}
    @Override
    public ResultSet getListOfAppliedAvailServices(String userid) throws Exception
    {
        CallableStatement cs = DB.getCon().prepareCall("{call listOfAppliedAvailServices(?) }");
        cs.setString(1, userid); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedure execute & return procedure data as ResultSet
    }
    public String deleteAvailService(String id)
    {
        try
	    {
	       String str = String.format("{call deleteAvailService(%s,?) } ",id);
	       CallableStatement cs = db.DB.getCon().prepareCall(str);
	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
	       cs.execute();
	       return cs.getString(1); // return out mode parameter value. 
	     }catch(Exception ex) { return ex.getMessage();  }
   		
    }
    @Override
    public ResultSet getUserApplyforServices(String userid) throws Exception
    {
        CallableStatement cs = DB.getCon().prepareCall("{call getUserApplyforServices(?) }");
        cs.setString(1, userid); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedure execute & return procedure data as ResultSet
    }
    @Override
    public ResultSet getAvailService(String sno) throws Exception {
        CallableStatement cs = DB.getCon().prepareCall("{call getAvailService(?) }");
        cs.setString(1, sno); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedure execute & return procedure data as ResultSet
    }
    @Override
    public String updAvailServiceRequest(String sno, String remarks) {
        try
   	    {
   	       String str = String.format("{call updAvailServiceRequest(%s,'%s',?) } ",sno,remarks);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
      	
    }
    // -----------------  Contact us Module ----------------------------
    @Override
    public String addContact(String name, String userid, String mailid, String mobile, String msg) {
        try
   	    {
   	       String str = String.format("{call addContact('%s','%s','%s','%s','%s',?) } ",name,userid,mailid,mobile,msg);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    
    @Override
    public ResultSet getContactInfo() throws Exception {
 		return DB.getCon().prepareCall("{call getContactInfo()}").executeQuery();
 	}
    @Override
    public String deleteContact(String sno) {
        try
   	    {
   	       String str = String.format("{call deleteContact(%s,?) } ",sno);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    //  ------------------- Feedback module --------------------------------------
    public String addFeedback(String name,String userid,String mailid,String mobile,String msg)
    {
        try
   	    {
   	       String str = String.format("{call addFeedback('%s','%s','%s','%s','%s',?) } ",name,userid,mailid,mobile,msg);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    	
    }
    public ResultSet getFeedbackReport() throws Exception
    {
		return DB.getCon().prepareCall("{call getFeedbackReport()}").executeQuery();
		    	
    }
    public String deleteFeedback(String sno)
    {
        try
   	    {
   	       String str = String.format("{call deleteFeedback(%s,?) } ",sno);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    // ---------------------------  Complaint module methods
    @Override
    public String addComplaint(String userid, String subject, String message) {
        try
   	    {
   	       String str = String.format("{call addComplaint('%s','%s','%s',?) } ",userid,subject,message);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    @Override
    public ResultSet complaintsReport() throws Exception {
    	return DB.getCon().prepareCall("{call complaintsReport()}").executeQuery();
    }
    @Override
    public String deleteComplaint(String id) {
        try
   	    {
   	       String str = String.format("{call deleteComplaint(%s,?) } ",id);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    @Override
    public ResultSet getComplaint(String id) throws Exception {
        CallableStatement cs = DB.getCon().prepareCall("{call getComplaint(?) }");
        cs.setString(1, id); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedure execute & return procedure data as ResultSet
    
    }
    @Override
    public String complaintResolve(String sno,String resolvemsg) {
        try
   	    {
   	       String str = String.format("{call complaintResolve(%s,'%s',?) } ",sno,resolvemsg);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
}
