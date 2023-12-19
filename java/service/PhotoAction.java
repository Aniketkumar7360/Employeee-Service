package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class PhotoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      try
      {
    	 FileItem photo=null;
    	 String name="";
    	 FileItemFactory factory = new DiskFileItemFactory();
    	 ServletFileUpload upload = new ServletFileUpload(factory);
    	 List<FileItem> items = upload.parseRequest(req);  // get add request Form Parameters
    	 System.out.println(items);
    	 for(FileItem n : items) // for each form field
    	 {
    		if(!n.isFormField()) // if that is photo upload field 
    			photo = n;
    		else
    		{
              if(n.getFieldName().equals("name"))
             	 name = n.getString(); 
            }
    	 }
    	 String msg = ""+db.UserDAO.getRef().addPhoto(photo);
    	 req.setAttribute("pid", msg);
    	 req.setAttribute("name", name);
    	// System.out.println(msg+" - "+name);
    	// System.out.println(photo.getInputStream());
      }catch(Exception ex) {System.out.println(ex);}
      req.getRequestDispatcher("ServiceForm.jsp").forward(req, res);
	}

}
