package student.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/getMarks")
@SuppressWarnings("serial")
public class GetStudentMarks extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired Please login again...<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		req.getRequestDispatcher("getStudentMarks.jsp").forward(req, res);
	}
}
