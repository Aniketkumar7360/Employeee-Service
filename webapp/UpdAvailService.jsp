<%@page import="service.Service"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
  <style>
      .lbl { text-align: right;font-family: verdana; font-size:14px; font-weight: bold;  } 
      .frm { border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  <%
  String sno = request.getParameter("id");
   Service r = new Service();
   ResultSet rs = r.getAvailService(sno);
   rs.next();
    
  %>
  <div class="row">
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 ">
      <form action="UpdAvailServiceAction"  role="form" method="post" class="frm">
         <table class="table table-md" width="100%"> 
           <tbody>    
            <tr>
                <td colspan='4' style='text-align:center;'><big>Avail Service Record exists with Following Record.<big></td>
            </tr>
            <tr>
                <input type=hidden value="<%=sno%>" name=sno />
                <td class="lbl">Service Name</td><td><input type="text" value="<%=rs.getString(2)%>" name="info" class="form-control" readonly /></td>
            </tr>
            <tr>
                 <td class="lbl">Charges.</td><td><div class="input-group"><span class="input-group-addon">Rs.</span><input type="number" value="<%=rs.getString(3) %>" name="charges" class="form-control" readonly /></div></td>
            </tr>
            <tr>
                 <td class="lbl">Discount</td><td><div class="input-group"><div class="input-group"><input type="number"  value="<%=rs.getString(4) %>" name="discount" placeholder="Discount in %" class="form-control" readonly /><span class="input-group-addon">% Discount</span></div></td>
            </tr>
            <tr>
                 <td class="lbl">Total.</td><td><div class="input-group"><span class="input-group-addon">Rs.</span><input type="number" name="total"  value="<%=rs.getString(5) %>"  class="form-control" readonly /></div></td>
            </tr>
            <tr>
                 <td class="lbl">Request On.</td><td><input type="text" name="total"  value="<%=rs.getString(7) %>"  class="form-control" readonly /></div></td>
            </tr>
            <tr>
                 <td class="lbl">Remarks.</td><td><input type="text" name="remarks"  value="<%=rs.getString(6) %>"  class="form-control" /></div></td>
            </tr>
            <tr>
               <td colspan="4"><input type="submit" value="Update Service Request.." class="btn btn-lg btn-primary btn-block" /> </td>
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
      
 <%@include file="Footer.jsp" %>