  <!-- Modal dialog for Sign In -->
<div class="modal fade" id="signin" tabindex="-1" role="dialog" aria-labelledby="title" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="title"><b>User Sign In Form</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"><b>&times;</b></span>
        </button>
      </div>
      <div class="modal-body">
        <form action="ValidateAction" role="form" class='frm' method="post">
       <div class="form-group">
              User Id  <input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" />
          </div>
          <div class="form-group">
              Password <input type="password" name="pass" placeholder="Plz Enter ur Password" class="form-control" />
          </div>
          <input type="submit" value="Sign In" class="btn btn-primary btn-block" />   
         </form>  
      </div>
      <div class="modal-footer">
         <big>Powered by Employee Deskboard Service&copy;2023, All Rights Reserved..</big> 
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="forget" tabindex="-1" role="dialog" aria-labelledby="title" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="title"><b>Please Enter ur User Id for forget Password</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"><b>&times;</b></span>
        </button>
      </div>
      <div class="modal-body">
        <form action="ForgetAction" role="form" class='frm' method="post">
         <div class="form-group">
              User Id  <input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" />
          </div>
          <input type="submit" value="Forget Password" class="btn btn-primary btn-block" />   
        </form>  
      </div>
      <div class="modal-footer">
         <big>Powered by Employee Deskboard Service&copy;2023, All Rights Reserved..</big> 
      </div>
    </div>
  </div>
</div>
