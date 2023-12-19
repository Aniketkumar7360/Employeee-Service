package user;

import java.sql.ResultSet;

import db.UserDAO;

public class Service {
   public ResultSet getProfile(String uid) throws Exception
   {
	   return UserDAO.getRef().getProfile(uid);
   }
}
