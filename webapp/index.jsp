<%@page import="service.Service"%>
<%@page import="db.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
   <%
     int ctr = 0,ctr1=1;
     boolean flag = false;
     try {
       //UserDAO d = UserDAO.getRef();
      ///ResultSet rs = d.getServices();
       Service r = new Service();
       ResultSet rs = r.getServices();
       
       while(rs.next())
       {
    	 if(ctr%3==0)
    	 {  out.println("<div class=\"row\">");
    	 //   out.println("<div class='col-sm-1 col-xs-1 col-md-1 col-lg-1'></div>");
    	 //   out.println("<div class='col-sm-12 col-xs-12 col-md-12 col-lg-12'>");
         }   
    	 out.println("<div class='col-sm-12 col-xs-12 col-md-4 col-lg-4'>");
    	 out.println("<div style='padding:10px;border-radius:10px;background-color: #FAD7A0;margin-top:10px;'><div class='card' style='height:420px;'>");
    	 out.println("<img src=Photo?id="+rs.getString(3)+" class='img-thumbnail' width='100%' style='height:250px;'>");
    	 out.println("<div class='card-block'>");
    	 out.println("<h5 class='card-title'>"+rs.getString(4)+"<br>"+rs.getString(5)+"</h5>");
    	 out.println("<p>Charges: <s>"+rs.getString(6)+"</s> , Pay - "+rs.getString(8)+" with "+rs.getString(7)+"% Discount.</p>");
    	 
    	 if(uid==null)
    		out.println("<br><b><a href=# data-toggle='modal' data-target=\"#signin\">Sign In for More Details</a></b>");
    	else
    	    out.println("<p><span class=\"glyphicon glyphicon-user\"></span>"+rs.getString(11)+",<span class=\"glyphicon glyphicon-phone\"></span>"+rs.getString(12)+"<br><span class='glyphicon glyphicon-send'></span> "+rs.getString(13)+"</p><div align=right><a href=AvailService?id="+rs.getString(1)+">Avail Service</a></div>");
         out.println("</div></div>");
		 out.println("</div>");
		 out.println("</div>");
    	 if(ctr1%3==0)
    	 {
    		 out.println("</div>");
    	//	 out.println("</div>");
    	 }
    	 ctr++;
    	 ctr1++;
       }
     }
     catch(Exception ex) { out.println(ex.toString());}
     String msg = (String)request.getAttribute("msg"); // get msg from request attribute 
     if(msg!=null)  out.println("<script>alert(\""+msg+"\"); </script>"); // if msg exist then display in alert. 

   %>
  <%@include file="Footer.jsp" %>