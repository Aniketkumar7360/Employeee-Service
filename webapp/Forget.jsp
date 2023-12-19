<%@include file="Header1.jsp" %>
   <style>
      .frm { padding: 30px; border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 ">
      <form action="ForgetAction" role="form" class='frm' method="post">
         <div class="form-group">
              User Id  <input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" />
          </div>
          <input type="submit" value="Forget Password" class="btn btn-primary btn-block" />   
         </form>  
        <a href="SignUp.jsp">Sign Up</a> | <a href="index.jsp">Sign In</a>   
      </div>
  </div>   
<%@include file="Footer.jsp" %>  