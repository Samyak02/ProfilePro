package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
  PrintWriter pw = res.getWriter();
  res.setContentType("text/html");
  Cookie c[] = req.getCookies();
//Internally perform DeSerialization
  
  if(c==null) 
  {
	  pw.println("Session Expired<br>");
	  RequestDispatcher rd = req.getRequestDispatcher("login.html");

	  rd.include(req, res);
	  
	  
  }
  
  else
  {
	  String fName =c[0].getValue();
	  pw.println("Page Belongs to User:"+fName+"<br>");
	  ServletContext sct = this.getServletContext();
	  UserBean ub = (UserBean)sct.getAttribute("ub");
	  
	  
	  pw.println(ub.getfName()+"&nbsp&nbsp&nbsp"
	  +ub.getlName()+"&nbsp&nbsp&nbsp"
	  +ub.getAddr()+"&nbsp&nbsp&nbsp"
	  +ub.getmId()+"&nbsp&nbsp&nbsp"
	  +ub.getPhNo()+"&nbsp&nbsp&nbsp"
	  +"<a href='edit'>EditProfile</a>"
	  +"&nbsp&nbsp&nbsp"
	  +"<a href='logout'>Logout</a>");
	  
  }
  

 }
}