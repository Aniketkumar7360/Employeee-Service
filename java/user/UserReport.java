package user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSetMetaData;
public class UserReport extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     req.getRequestDispatcher("Header1.jsp").include(req, res); // include the Header page in servlets.	
	     PrintWriter out = res.getWriter();
	     HttpSession ses = req.getSession(true);
	     String umode = (String)ses.getAttribute("mode");
	     if(umode==null) umode="";
	     if(!umode.equals("ADMIN"))
	     {
	    	out.println("<h2>Sorry U have no Privileges for View User List, Plz Login as Administrator user..</h2>");
	    	out.close();
	     }
	     out.println("<div class=\"col-xs-1 col-sm-1 col-md-1 col-lg-1\"></div>");
	     out.println("<div class=\"col-xs-10 col-sm-10 col-md-10 col-lg-10\"></div>");
	     out.println("<table class=\"table table-striped table-hover\">");
	     out.println("<hread>");
	     out.println("<tr>");
	     try
	     {
	    	ResultSet rs = db.UserDAO.getRef().getUsers(); 
	        ResultSetMetaData mt = rs.getMetaData(); // get meta data for col infi
	        for(int i=1;i<=mt.getColumnCount();i++)
	            out.print("<th>"+mt.getColumnName(i).toUpperCase()+"</th>");
	        out.println("<th>Action</tr>");
	        out.println("</thead><tbody>");
	        while(rs.next())
	        {
	        	out.println("<tr>");
	        	for(int i=1;i<=mt.getColumnCount();i++)
	        	{
	        		if(i==2)
	        		    out.print("<td>"+db.UserDAO.getRef().decpt(rs.getString(i))+"</td>");
	        		else
	        			out.print("<td>"+rs.getString(i)+"</td>");
	        	}	
	  	       	out.println("<td><a href=UpdUserStatus?id="+rs.getString(1)+"><span class='glyphicon glyphicon-edit'></span></a> | <a href=DeleteUser?id="+rs.getString(1)+"><span class='glyphicon glyphicon-trash'></span</a>");
	            out.println("</tr>");
	        }
	        out.println("</tbody>");
	        out.println("</table>");
	        String msg = (String)req.getAttribute("msg");
	        if(msg!=null)
	        	out.print(msg);
	        
	     }catch(Exception ex) {}
	     req.getRequestDispatcher("Footer.jsp").include(req, res);	
	     
	  }

	}
