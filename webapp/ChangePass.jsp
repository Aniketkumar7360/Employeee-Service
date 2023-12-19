<%@include file="Header1.jsp" %>
  <script>
     function validate()
     {  // docu
    	 np = document.forms[0].newpass.value;
    	 rnp = document.forms[0].rnewpass.value;
    	 if(np.length<8)
    	 {	 
    		 alert("Password should be min 8 chars, re-enter Plz....");
    		 document.forms[0].newpass.value;
    	     return false;
    	 }	 
    	 else if(np!=rnp)
         {
    	     alert("Sorry ur Password not matched, Plz Enter Value Password....");
    	     return false;
    	 }
     	 return  true;
     }
  </script>
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 ">
      <img src="images/resetpass.jpg" style="width:100%;height:355px;" class="img-thumbnail">
    </div>
    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 ">
      <form action="ChangePassAction" role="form" class='frm' method="post" onsubmit="return validate()">
        <%
          String msg = (String)request.getAttribute("msg");
          if(msg!=null) out.print("<font color=red>"+msg+"</font>");
        %>
         <div class="form-group">
         </div>
          <div class="form-group">
              Old Password  <input type="password" name="oldpass" placeholder="Plz Enter Old Password" class="form-control" />
          </div>
          
          <div class="form-group">
             New Password <input type="password" name="newpass" placeholder="Plz Enter ur New Password" class="form-control" />
          </div>
          <div class="form-group">
             Retype Password <input type="password" name="rnewpass" placeholder="Plz retype ur New Password" class="form-control" />
          </div>
          
          <input type="submit" value="Change Password" class="btn btn-primary btn-block" />   
          <p style="padding-left:5px;padding-top:10px;"><a href="Forget.jsp">Forget Password</a></p>   
         </form>
      </div>
  </div>   
<%@include file="Footer.jsp" %>  