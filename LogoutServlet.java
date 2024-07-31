

package test;

import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
 PrintWriter pw = res.getWriter();
 res.setContentType("text/html");
 Cookie c[] = req.getCookies();
 if(c==null) {
 pw.println("Session Expired...<br>");
 }else {
 ServletContext sct = this.getServletContext();
 sct.removeAttribute("ub");
 c[0].setMaxAge(0);
 res.addCookie(c[0]);
 pw.println("User logged out Successfully..<br>");
 }//end of else
 RequestDispatcher rd =

 req.getRequestDispatcher("login.html");

 rd.include(req, res);
}
}
