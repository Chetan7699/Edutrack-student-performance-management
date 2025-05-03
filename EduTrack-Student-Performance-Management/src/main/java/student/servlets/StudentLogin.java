package student.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.beans.Student;
import student.dao.StudentLoginDAO;
@WebServlet("/student")
@SuppressWarnings("serial")
public class StudentLogin extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException
    {
    	String rollNo = req.getParameter("rno");
    	Student student = new StudentLoginDAO().login(rollNo);
    	if(student==null)
    	{
    		req.setAttribute("msg", "Invalid Roll Number...");
    		req.getRequestDispatcher("msg.jsp").forward(req, res);
    	}
    	HttpSession hs=req.getSession();
    	hs.setAttribute("student", student);
    	req.getRequestDispatcher("studentlogin.jsp").forward(req, res);
    	
    }
}
