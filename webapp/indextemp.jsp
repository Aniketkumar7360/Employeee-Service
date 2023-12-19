<%@include file="Header1.jsp" %>
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 "></div>
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 "></div>
    <div class="col-xs-10 col-sm-10 col-md-4 col-lg-4 ">
      <form action="ValidateAction" role="form" class='frm' method="post">
        <%
          String msg = (String)request.getAttribute("msg");
          if(msg!=null) out.print("<font color=red>"+msg+"</font>");
        %>
         <div class="form-group">
         </div>
       <div class="form-group">
              User Id  <input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" />
          </div>
          <div class="form-group">
              Password <input type="password" name="pass" placeholder="Plz Enter ur Password" class="form-control" />
          </div>
          <input type="submit" value="Sign In" class="btn btn-primary btn-block" />   
          <p style="padding-left:5px;padding-top:10px;"><a href="Forget.jsp">Forget Password</a></p>   
         </form>  
      </div>
  </div>   
<%@include file="Footer.jsp" %>  