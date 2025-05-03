package student.servlets;
import jakarta.servlet.*;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import student.beans.Student;
import student.dao.StudentDAO;

import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/addStudent")
public class AddStudent extends HttpServlet
{
   @Override
   protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
	   HttpSession hs=req.getSession(false);
	   
	   if(hs==null)
	   {
		   req.setAttribute("msg", "Session Expired,Please Login again...");
		   req.getRequestDispatcher("msg.jsp").forward(req, res);
	   }
	   else
	   {
		    Student student=new Student();
		   
		    
	  String rollNo=req.getParameter("roll");
	  String studentName=req.getParameter("sname");
	  String studentCourse=req.getParameter("course");
	  int coreJava=Integer.parseInt(req.getParameter("cj")) ;
	  int advJava=Integer.parseInt(req.getParameter("ajava")) ;
	  int html=Integer.parseInt(req.getParameter("html")) ;
	  int dataBase=Integer.parseInt(req.getParameter("db")) ;
	  int c=Integer.parseInt(req.getParameter("c")) ;
	  int javaScript=Integer.parseInt(req.getParameter("js")) ;
	  int totalMarks=coreJava+advJava+html+dataBase+c+javaScript;
	  double per=(double)totalMarks/6.0;
	  String result="";
	  if(per>90 && per<=100)
	  {
		  result="O";
	  }
	  else if(per>80 && per<=90)
	  {
		  result="A+";
	  }
	  else if(per>70 && per<=80)
	  {
		  result="A";
	  }
	  else if(per>60 && per<=70)
	  {
		  result="B";
	  }
	  else if(per>50 && per<=60)
	  {
		  result="C";
	  }
	  else if(per>35 && per<=50)
	  {
		  result="D";
	  }
	  else
	  {
		  result="F";
	  }
	  
	  student.setRollNo(rollNo);
	  
	  student.setName(studentName);
	  student.setCourse(studentCourse);
	  student.setTotalMarks(totalMarks);
	  student.setPercentage(per);
	  student.setResult(result);
	  student.getMarks().setCoreJava(coreJava);
	  student.getMarks().setAdvJava(advJava);
	  student.getMarks().setHtml(html);
	  student.getMarks().setDb(dataBase);
	  student.getMarks().setC(c);
	  student.getMarks().setJavascript(javaScript);
	  int k = new StudentDAO().addStudent(student);
	  if(k>0)
	  {
		  req.setAttribute("msg","Student Added Succesfully...");
		  req.getRequestDispatcher("addStudent.jsp").forward(req, res);
		  
	  }
	  else
	  {
		  req.setAttribute("errmsg", "Student Already Exists with roll number<br>");
		  req.getRequestDispatcher("msg.jsp").forward(req, res);
	  }
	  
	  
	   }
	  
	  
	  
	  
	  
	  
   }
}
