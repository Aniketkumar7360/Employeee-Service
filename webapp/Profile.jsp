<%@page import="db.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
  <style>
      .lbl { text-align: right;font-family: verdana; font-size:14px; font-weight: bold;  } 
      .frm { border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  <div class="row">
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" >
      <form action="ProfileAction" role="form" method="post" class="frm" style="padding-left:50px;padding-right:50px;">
         <table class="table table-md" width="100%"> 
           <tbody>    
            <tr>
                <td colspan='4' style='text-align:center;'><big><%=uid %> User Profile<big></td>
            </tr>
            <%
            // ResultSet rs = UserDAO.getRef().getProfile(uid);
            user.Service r = new user.Service();
            ResultSet rs = r.getProfile(uid);
             rs.next();
            %>
            <tr>
                <td class="lbl">Name</td><td><input type="text" name="name" value="<%=rs.getString(1) %>" class="form-control" required /></td>
                <td class="lbl">D.O.B.</td><td><input type="date" name="dob"  value="<%=rs.getString(2) %>" max="2000-12-31" min="1947-08-15" class="form-control" required /></td>
            </tr>
            <tr>
                 <td class="lbl">Mail Id</td><td><input type="email" name="mailid"  value="<%=rs.getString(3) %>" class="form-control" required /></td>
                 <td class="lbl">Mobile</td><td><input type="text" name="mobile"  value="<%=rs.getString(5) %>" class="form-control" required /></td>
            </tr>
            <tr>
                <td class="lbl">Security Question</td><td colspan="3">
                      <select name=squestion class="form-control"/>
                        <option value="">Please Select your Security Question for Password Recovery.</option>
                        <%
                           String ar[] = {"What is your First School name?","What is your Pets name?","What is your Birth Place?","What's your Mother's name?","What was the name of your first Mobile Number?","Where Did you travel for the first time?","What was your first car?","What's your dream job?"};
                           for(int i=1;i<=ar.length;i++)
                           {
                        	  if(rs.getInt(7)==i) // securityqno value 
                        		out.println("<option value='"+i+"' selected>"+ar[i-1]+"</option>");
                        	  else
                        	 	out.println("<option value='"+i+"'>"+ar[i-1]+"</option>");
                           }
                        %>
                       </select>
                </td>
            </tr>
            
            <tr>
                <td class="lbl">Security Ans.</td><td><input type="text" name="securityans"   value="<%=rs.getString(8) %>" placeholder="Plz Enter ur Security Answer" class="form-control" /></td>
                <td class="lbl">Gender</td><td><select name="gender" required class="form-control" />
                                      <option value="">I m a .....</option>
                                      <%
                                      if(rs.getString(4).equals("Male"))
                                      	out.println("<option value='Male' selected>Male.</option>  <option value='Female'>Female.</option>");
                                      else
                                      	out.println("<option value='Male'>Male.</option>  <option value='Female' selected>Female.</option>");
                                    
                                      %>
                                      <option value="Male">Male.</option>
                                      <option value="Female">Female.</option>
                                   </select>
                               </td>
            </tr>
            <tr>
               <td class="lbl">Address</td><td colspan=3><textarea name=address class="form-control"> <%=rs.getString(6) %></textarea></td>
            </tr>
            <tr>
               <td colspan="4"><input type="submit" value="Update Profile" class="btn btn-lg btn-primary btn-block" /> </td>
            </tr>    
            <tr>
               <td colspan="4"><%
                 String msg = (String)request.getAttribute("msg");
                 if(msg!=null) out.print(msg);
               %></td>
            </tr>    
            
           </tbody>
         </table> 
         </form>  
      </div>
 <%@include file="Footer.jsp" %>