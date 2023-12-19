<%@include file="Header1.jsp" %>
  <style>
      .lbl { text-align: right;font-family: verdana; font-size:14px; font-weight: bold;  } 
      .frm { border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  <script>
     function photoSave()
     {
        document.fr.action="PhotoAction";
        document.fr.enctype="multipart/form-data";
        document.fr.submit();
     }
     function totalRs() // casting calculate
     {        //      bodypartse,1stformse.charges var ka value
    	 pr = parseInt(document.fr.charges.value); // charges value get
    	 dis = parseInt(document.fr.discount.value);
    	 tot = pr-((dis/100)*pr); // total price after discount 
     	 document.fr.total.value=""+tot;
     }
  </script>
  <%
  String pid = (String)request.getAttribute("pid");
  String name = (String)request.getAttribute("name");
  if(name==null) 
	  name = pid = "";
  
  %>
  <div class="row">
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 ">
      <form action="ServiceFormAction" name=fr role="form" method="post" class="frm">
         <table class="table table-md" width="100%"> 
           <tbody>    
            <tr>
                <td colspan='4' style='text-align:center;'><big>New Service Registration Form<big></td>
            </tr>
            <tr>
                <input type=hidden value="<%=pid%>" name=pid />
                <td class="lbl">Name</td><td><input type="text" value="<%=name%>" name="name" placeholder="Plz Enter Service Name" class="form-control" required /></td>
                <td class="lbl">Photo</td><td><input type="file" name="ph" class="form-control" onchange="photoSave()" /></td>
            </tr>
            <tr>
               <td class="lbl">Info</td><td colspan=3><textarea name=info class="form-control"></textarea></td>
            </tr>
            
            <tr>
               <td class="lbl">Office Address</td><td colspan=3><textarea name=office class="form-control"></textarea></td>
            </tr>
            <tr>
               <td class="lbl">City</td><td><select name="city" required class="form-control" />
                                      <option value="">Select City</option>
                                      <option value="Ghaziabad">Ghaziabad.</option>
                                      <option value="Noida">Noida.</option>
                                      <option value="Greator Noida">Greator Noida.</option>
                                      <option value="New Delhi">New Delhi.</option>
                                   </select>
                               </td>
                 <td class="lbl">Charges.</td><td><div class="input-group"><span class="input-group-addon">Rs.</span><input type="number" name="charges" class="form-control" required /></div></td>
            </tr>
            <tr>
                 <td class="lbl">Discount</td><td><div class="input-group"><div class="input-group"><input type="number" name="discount" placeholder="Discount in %" class="form-control" onblur="totalRs()" /><span class="input-group-addon">% Discount</span></div></td>
                 <td class="lbl">Total.</td><td><div class="input-group"><span class="input-group-addon">Rs.</span><input type="number" name="total" class="form-control" readonly /></div></td>
            </tr>
            <tr>
               <td colspan="4"><input type="submit" value="Add New Service" class="btn btn-lg btn-primary btn-block" /> </td>
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
       %>
      </div>
  </div>    
      
 <%@include file="Footer.jsp" %>