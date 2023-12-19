package service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Photo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String id = request.getParameter("id");
	   try
	   {
		  ResultSet rs = db.UserDAO.getRef().getPhoto(id);
		  if(rs.next()) // if record exist - means us id ke base pe database me hai... 
		  {
			 Blob b = rs.getBlob(1);
			 byte data[] = b.getBytes(1, (int)b.length()); // get photo data & stored in data var
			 response.getOutputStream().write(data);
		  }
	   }catch(Exception ex) { response.getWriter().println(ex.toString());}
	   
	}

}
