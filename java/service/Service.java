package service;

import java.sql.ResultSet;

import db.UserDAO;

public class Service {
	public ResultSet getServices() throws Exception
	{
	  return  UserDAO.getRef().getServices();	
	}
	public ResultSet getService(String id) throws Exception
	{
	  return  UserDAO.getRef().getService(id);	
	}
	public ResultSet getAvailService(String sno) throws Exception
	{
	  return UserDAO.getRef().getAvailService(sno);	
	}
	

}
