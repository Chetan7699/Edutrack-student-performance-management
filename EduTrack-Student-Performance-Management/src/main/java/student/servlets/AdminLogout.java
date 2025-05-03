package student.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/AdminLogout")
@SuppressWarnings("serial")
public class AdminLogout extends HttpServlet 
{
	@Override
   protected void doGet(HttpServletRequest req,HttpServletResponse res)
   throws ServletException,IOException
   {
	   HttpSession hs=req.getSession();
	   if(hs==null)
	   {
		   req.setAttribute("msg", "Session Expired Please Login again....<br> ");
		   req.getRequestDispatcher("msg.jsp").forward(req, res);
	   }
	   
	   req.getRequestDispatcher("adminLogout.jsp").forward(req, res);
   }
	
}
