package complaint;

import java.sql.ResultSet;

import db.UserDAO;

public class GetComplaint {
   public static ResultSet getComplaint(String id) throws Exception
   {
	   return UserDAO.getRef().getComplaint(id);
   }
}
