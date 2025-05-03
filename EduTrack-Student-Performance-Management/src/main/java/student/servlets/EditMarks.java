package student.servlets;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.beans.Student;
@WebServlet("/edit")
@SuppressWarnings("serial")
public class EditMarks extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired Please Login Again...");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		
			
			@SuppressWarnings("unchecked")
			ArrayList<Student> students =(ArrayList<Student>) hs.getAttribute("students");
			String rollNo=req.getParameter("rno");
			for(Student student : students)
			{
				if(rollNo.equals(student.getRollNo()))
				{
					req.setAttribute("student", student);
					req.getRequestDispatcher("editMarks.jsp").forward(req, res);
					break;
				}
				
			}
		}
	
}
