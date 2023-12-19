<%@include file="Header1.jsp" %>
 <script>
    function validateMe()
    {
    	if(document.getElementById("mob").value.length!=10)
      	{
      		alert("Sorry Mobile Number should be Min 10 Digit, Plz Enter valid Mobile No");
      		return false;
      	}
    	else if(document.getElementById("msg").value.length<=15)
      	{
      		alert("Sorry Feedback Message should be Min 15 Charactors, Plz Enter valid Feedback message");
      		return false;
      	}
      	else return true;
    }
 </script>

<div style="margin-top:5px">
  <img src="images/feedback.jpg" style="width:100%;height:150px;margin-top:0px;border-radius:2px;box-shadow:0px 0px 1px black" />
</div>

<div style="width:100%;margin:auto;min-height:100px;border-radius:2px ;box-shadow:0px 0px 1px black; padding:20px;">
<table width="100%" class="table">  
<tbody><tr>  
<td width="50%"> 
<div style="width:100%;min-height:400px;color:Black   ">
<p style="margin-left:4%;margin-right:4%">
      <img src="images/feedback1.jpg" style="height:120px;width:180px;"></p>
      <p style="margin-left:46%;margin-top:-100px;margin-right:4%;  font-weight: bold;">Employment Dashboard & Services<br>VGI College NH-91 Dadri <br>
                              Uttar Pradesh - 203207 <br></p><br>
           
    <p style="margin-left:6%;margin-right:8%;">
     <b> For Enquiry</b> : +91-7360956303<br><br>
     <b>Office No</b> : +91-8266907137<br/><br/>
     <b>For Query :</b> +91-9430936367<br><br>
     <b> For Advertisement : </b>employmentdashboard2021@gmail.com<br><br>
     <b>  Email :</b> employmentdashboard2023@gmail.com<br><br>
     <b>  Website:</b><a href="#" target="_blank" class="home"> www.employmentdashboard.com </a>    
    </p>
    <p style="margin-left:6%;margin-right:4%">You Can Send us your views and your queries about our company:</p>
 </div> 
</td>
<td width="50%">
<div style="width:100%;min-height:400px;color:Black  ">
<form action="FeedbackAction" method="post" onsubmit="return validateMe()">
 <table class="table" width="100%">
 <tbody>
 <tr> <td style="text-align:right;">Name:</td><td><input type=text name=name class="form-control" placeholder="Enter Name here" required /> </td> </tr> 
 <tr><td style="text-align:right;">Email:</td><td><input type=email name=mailid class="form-control" placeholder="Enter ur Email Id" required/> </td> </tr>
 <tr><td style="text-align:right;">Contact No:</td><td><input id="mob" type=number name=mobile class="form-control" placeholder="Enter ur mobile" required/> </td> </tr>
 <tr><td style="text-align:right;">Your Message:</td><td><textarea id="msg" class="form-control" style="height:145px;" name=msg required> </textarea></td></tr> 
 <tr><td colspan="2"> <input type=submit value="Submit" class="btn btn-primary btn-block" /></td></tr>
 <tr><td colspan="2">
  <%
     String msg = (String)request.getAttribute("msg");
     if(msg!=null) 
    	 out.print(msg);
  %> </td></tr>
 
  </tbody></table>
</form>   
     
 </div> 
</td>
</tr>  
 </tbody></table>                     
</div>
<%@include file="Footer.jsp" %>