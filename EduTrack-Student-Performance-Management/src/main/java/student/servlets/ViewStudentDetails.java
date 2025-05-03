package student.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/viewStudent")
@SuppressWarnings("serial")
public class ViewStudentDetails extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired Please Login Again..");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		req.getRequestDispatcher("viewDetails.jsp").forward(req, res);
		
	}
}
