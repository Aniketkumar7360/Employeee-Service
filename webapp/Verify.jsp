<%@include file="Header1.jsp" %>
   <style>
      .frm { padding: 30px; border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 ">
      <%
          String msg = (String)request.getAttribute("msg");
          if(msg!=null) out.print("<font color=red>"+msg+"</font>");
      %>
      <form action="VerifyAction" role="form" class='frm' method="post">
         <div class="form-group">
              Plz Enter ur OTP   <input type="text" name="otp" placeholder="Plz Enter ur OTP" class="form-control" />
          </div>
          <input type="submit" value="Sign In" class="btn btn-primary btn-block" />   
         </form>  
        <a href="SignUp.jsp">Sign Up</a> 
      </div>
  </div>   
<%@include file="Footer.jsp" %>