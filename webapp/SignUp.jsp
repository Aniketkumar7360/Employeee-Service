<%@include file="Header1.jsp" %>
  <style>
      .lbl { text-align: right;font-family: verdana; font-size:14px; font-weight: bold;  } 
      .frm { border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  <div class="row">
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 ">
      <form action="RegisterAction" role="form" method="post" class="frm">
         <table class="table table-md" width="100%"> 
           <tbody>    
            <tr>
                <td colspan='4' style='text-align:center;'><big>User Registration Form<big></td>
            </tr>
            <tr>
                <td class="lbl">User Id</td><td><input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" required /></td>
                <td class="lbl">Password</td><td><input type="password" name="pass" placeholder="Plz Enter ur Password" class="form-control" required /></td>
            </tr>
            <tr>
                <td class="lbl">Name</td><td><input type="text" name="name" placeholder="Plz Enter Name" class="form-control" required /></td>
                <td class="lbl">D.O.B.</td><td><input type="date" name="dob"  min="1947-08-15" class="form-control" required /></td>
            </tr>
            <tr>
                 <td class="lbl">Mail Id</td><td><input type="email" name="mailid" placeholder="Plz Enter ur Mail Id" class="form-control" /></td>
                 <td class="lbl">Mobile</td><td><input type="number" name="mobile" placeholder="9990046906" class="form-control" /></td>
            </tr>
            <tr>
                <td class="lbl">Security Question</td><td colspan="3">
                      <select name=squestion class="form-control"required/>
                        <option value="">Please Select your Security Question for Password Recovery.</option>
                        <option value="1">What is your First School name?</option>
                        <option value="2">What is your Pets name?</option>
                        <option value="3">What is your Birth Place?</option>
                        <option value="4">What's your Mother's name?</option>
                        <option value="5">What was the name of your first Mobile Number?</option>
                        <option value="6">Where Did you travel for the first time?</option>
                        <option value="7">What was your first car?</option>
                        <option value="8">What's your dream job?</option>
                      </select>
                </td>
            </tr>
            
            <tr>
                <td class="lbl">Security Ans.</td><td><input type="text" name="securityans" placeholder="Plz Enter ur Security Answer" class="form-control"required /></td>
                <td class="lbl">Gender</td><td><select name="gender" required class="form-control" />
                                      <option value="">I m a .....</option>
                                      <option value="Male">Male.</option>
                                      <option value="Female">Female.</option>
                                   </select>
                               </td>
            </tr>
            <tr>
               <td class="lbl">Address</td><td><textarea name=address class="form-control"></textarea></td>
               <td class="lbl">Login Mode</td><td><select name=wmode class="form-control" required >
                                                    <option value="">Select Registered Mode</option>
                                                    <option value="SERVICE">Service Provider</option>
                                                    <option value="CUSTOMER">Customer</option>
                                                    <option value="EMPLOYEE">Employee</option>
                                                  </select>
                                               </td>
            </tr>
            <tr>
               <td colspan="4"><input type="submit" value="Sign Up" class="btn btn-lg btn-primary btn-block" /> </td>
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