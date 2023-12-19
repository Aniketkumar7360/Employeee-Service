<% 
   session.invalidate();
   request.setAttribute("msg", "U r Successfully Logout....");
   request.getRequestDispatcher("index.jsp").forward(request, response);
%>