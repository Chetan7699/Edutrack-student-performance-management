package student.servlets;
import java.io.IOException;

import admin.beans.Admin;
import admin.dao.AdminLoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/admin")
@SuppressWarnings("serial")
public class AdminLogin extends HttpServlet
{
   @Override
   protected void doPost(HttpServletRequest req,HttpServletResponse res)
   throws ServletException,IOException
   {
	   String userName = req.getParameter("uname");
	   String password = req.getParameter("pass");
	   Admin admin= new AdminLoginDAO().getAdmin(userName, password);
	   if(admin==null)
	   {
		   req.setAttribute("msg", "Invalid Login Details...");
		   req.getRequestDispatcher("msg.jsp").forward(req, res);
		   
	   }
	   else
	   {
		   HttpSession session=req.getSession();
		   session.setAttribute("admin", admin);
		   req.getRequestDispatcher("adminlogin.jsp").forward(req, res);
		   
	   }
	   
	   
   }
}
