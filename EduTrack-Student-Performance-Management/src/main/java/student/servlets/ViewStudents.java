package student.servlets;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.beans.Student;
import student.dao.StudentDAO;
@SuppressWarnings("serial")
@WebServlet("/viewStudents")
public class ViewStudents extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req,HttpServletResponse res)
  throws ServletException,IOException
  {
HttpSession hs=req.getSession(false);
	  
	  if(hs==null)
	  {
		  req.setAttribute("msg", "Session Expired Please Login again...");
		  req.getRequestDispatcher("msg.jsp").forward(req, res);
	  }
	  List<Student> students=new StudentDAO().viewStudents();
	  hs.setAttribute("students", students);
	  req.getRequestDispatcher("viewStudents.jsp").forward(req, res);
  }
}
