package student.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/studentlogout")
@SuppressWarnings("serial")
public class StudentLogout extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req,HttpServletResponse res)
  throws ServletException,IOException
  {
	  HttpSession hs=req.getSession(false);
	  if(hs==null)
	  {
		  req.setAttribute("msg", "Session Expired Plaese Login again....<br>");
		  req.getRequestDispatcher("msg.jsp").forward(req, res);
	  }
	  req.getRequestDispatcher("studentlogout.jsp").forward(req, res);
  }
}
