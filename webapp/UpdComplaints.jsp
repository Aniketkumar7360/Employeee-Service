<%@page import="complaint.GetComplaint"%>
<%@page import="db.UserDAO"%>
<%@page import="db.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
 <script>
 function validateMe()
 {
    if(document.getElementById("mob").value.length!=10)
 	{
 		alert("Sorry Mobile Number should be Min 10 Digit, Plz Enter valid Mobile No");
 		return false;
 	}
 	else return true;
 }
 </script>

<div style="margin-top:5px">
  <img src="images/complaints.png" style="width:100%;height:150px;margin-top:0px;border-radius:2px;box-shadow:0px 0px 1px black" />
</div>

<div style="width:100%;margin:auto;min-height:100px;border-radius:2px ;box-shadow:0px 0px 1px black; padding:20px;">
<table width="100%" class="table">  
<tbody><tr>  
<td width="50%"> 
<div style="width:100%;min-height:400px;color:Black   ">
<p style="margin-left:4%;margin-right:4%">
      <img src="images/complaints.jpg" style="height:120px;width:180px;"></p>
      <p style="margin-left:46%;margin-top:-100px;margin-right:4%;  font-weight: bold;">Employment Dashboard & Services<br>HIET College NH-24 Ghaziabad <br>
                              Uttar Pradesh - 201001 <br></p><br>
           
    <p style="margin-left:6%;margin-right:8%;">
     <b>Complaints No.</b> : +91-8587862266<br><br>
     <b>Office No</b> : +91-8587862266<br/><br/>
     <b>For Query :</b> +91-8587862266<br><br>
     <b> For Advertisement : </b>employmentdashboard2021@gmail.com<br><br>
     <b>  Email :</b> employmentdashboard2021@gmail.com<br><br>
     <b>  Website:</b><a href="#" target="_blank" class="home"> www.employmentdashboard.com </a>    
    </p>
    <p style="margin-left:6%;margin-right:4%">You Can Send us your views and your queries about our company:</p>
 </div> 
</td>
<td width="50%">
<div style="width:100%;min-height:400px;color:Black  ">
<form action="UpdComplaintAction" method="post" onsubmit="return validateMe()">
 <table class="table" width="100%">
 <%
    String id = request.getParameter("id");
    ResultSet rs = GetComplaint.getComplaint(id);
    rs.next(); 
 %>
 <tbody>    <input type=hidden value="<%=rs.getString(1) %>" name=sno />
 <tr> <td style="text-align:right;">User Name:</td><td><input type=text name=name class="form-control" value="<%=rs.getString(2) %>" required /> </td> </tr> 
 <tr> <td style="text-align:right;">Complaint Subject:</td><td><input type=text name=subject class="form-control" value="<%=rs.getString(3) %>"  placeholder="Enter Name Compaints Subject" required /> </td> </tr> 
 <tr><td style="text-align:right;">Complaint Message:</td><td><textarea class="form-control" name=complaintmsg required><%=rs.getString(4) %></textarea></td></tr> 
 <tr><td style="text-align:right;">Resolve Message:</td><td><textarea class="form-control" style="height:145px;" name=resolvemsg required> </textarea></td></tr> 
 <tr><td colspan="2"> <input type=submit value="Update Complaint" class="btn btn-primary btn-block" /></td></tr>
 
  </tbody></table>
</form>   
     
 </div> 
</td>
</tr>  
 </tbody></table>                     
</div>
<%@include file="Footer.jsp" %>