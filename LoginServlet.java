package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/log")

public class LoginServlet extends HttpServlet
{
 protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
 {
   PrintWriter pw=res.getWriter();
   res.setContentType("text/html");
   UserBean ub=new LoginDAO().login(req);
   
   if(ub==null)
   {
	   pw.println("Invalid login Process<br>");
	   RequestDispatcher rd= req.getRequestDispatcher("login.html");
	   rd.include(req, res);
	   
   }
   else
   {
	   ServletContext sct=this.getServletContext();
	   sct.setAttribute("ub",ub);
	   Cookie ck =new Cookie("fname",ub.getfName());
	   res.addCookie(ck);
	   
	   //Serialization Process
	   pw.println("Welcome User:"+ub.getfName()+"<br>");
	   RequestDispatcher rd =

			   req.getRequestDispatcher("link.html");

			   rd.include(req, res);
	   
   }
 }
}
