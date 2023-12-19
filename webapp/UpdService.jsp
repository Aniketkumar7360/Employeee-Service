<%@page import="service.Service"%>
<%@page import="db.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
  <style>
      .lbl { text-align: right;font-family: verdana; font-size:14px; font-weight: bold;  } 
      .frm { border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  <script>
     function photoSave()
     {
        document.forms[0].action="PhotoAction";
        document.forms[0].enctype="multipart/form-data";
        document.forms[0].submit();
     }
     function totalRs() // casting calculate
     {        //      bodypartse,1stformse.charges var ka value
    	 pr = parseInt(document.forms[0].charges.value); // charges value get
    	 dis = parseInt(document.forms[0].discount.value);
    	 tot = pr-((dis/100)*pr); // total price after discount
     	 document.forms[0].total.value=""+tot;
     }
  </script>
  <%
  String pid = (String)request.getAttribute("pid");
  String name = (String)request.getAttribute("name");
  if(name==null) 
	  name = pid = "";
  String id = request.getParameter("id");
  //ResultSet rs = UserDAO.getRef().getService(id);
   Service r = new Service();
   ResultSet rs = r.getService(id);
       
  if(rs.next()) {
  {
	 name = rs.getString(2);
	 pid = rs.getString(3);
  }
	  
  %>
  <div class="row">
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 ">
      <form action="UpdServiceAction"  role="form" method="post" class="frm">
         <table class="table table-md" width="100%"> 
           <tbody>    
            <tr>
                <td colspan='4' style='text-align:center;'><big>Service Record exists with Following Record.<big></td>
            </tr>
            <tr>
                <input type=hidden value="<%=rs.getString(1)%>" name=id />
                <input type=hidden value="<%=pid%>" name=pid />
                <td class="lbl">Name</td><td><input type="text" value="<%=name%>" name="name" placeholder="Plz Enter Service Name" class="form-control" required /></td>
                <td class="lbl">Photo</td><td><input type="file" name="ph" class="form-control" onchange="photoSave()" disabled /></td>
            </tr>
            <tr>
               <td class="lbl">Info</td><td colspan=3><textarea name=info class="form-control"><%=rs.getString(4)%></textarea></td>
            </tr>
            
            <tr>
               <td class="lbl">Office Address</td><td colspan=3><textarea name=office class="form-control"><%=rs.getString(5) %></textarea></td>
            </tr>
            <tr>
               <td class="lbl">City</td><td><select name="city" required class="form-control" />
                                      <option value="">Select City</option>
                      <%
                         String ar[] = {"Ghaziabad","Noida","Greator Noida","New Delhi"};
                         for(String n : ar)
                         {
                        	if(n.equals(rs.getString(10))) 
                                out.println("<option value='"+n+"' selected>"+n+"</option>");
                        	else
                        	    out.println("<option value='"+n+"'>"+n+"</option>");
                         }
                      %>                
                                   </select>
                               </td>
                 <td class="lbl">Charges.</td><td><div class="input-group"><span class="input-group-addon">Rs.</span><input type="number" value="<%=rs.getString(7) %>" name="charges" class="form-control" required /></div></td>
            </tr>
            <tr>
                 <td class="lbl">Discount</td><td><div class="input-group"><div class="input-group"><input type="number"  value="<%=rs.getString(8) %>" name="discount" placeholder="Discount in %" class="form-control" onblur="totalRs()" /><span class="input-group-addon">% Discount</span></div></td>
                 <td class="lbl">Total.</td><td><div class="input-group"><span class="input-group-addon">Rs.</span><input type="number" name="total"  value="<%=rs.getString(9) %>"  class="form-control" readonly /></div></td>
            </tr>
            <tr>
               <td colspan="4"><input type="submit" value="Update Service" class="btn btn-lg btn-primary btn-block" /> </td>
            </tr>    
            <tr>
               <td colspan="4"><%
                 String msg = (String)request.getAttribute("msg");
                 if(msg!=null) out.print("<b>"+msg+"</b>");
               %></td>
            </tr>    
            
           </tbody>
         </table> 
         </form>  
      </div>
      <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
       <%
        if(!pid.equals(""))
          out.println("<img src=Photo?id="+pid+" class='img-thumbnail'>") ;
       }
       %>
      </div>
      
 <%@include file="Footer.jsp" %>