package student.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.beans.Student;
import student.dao.StudentDAO;
@WebServlet("/update")
@SuppressWarnings("serial")
public class UpdateMarks extends HttpServlet
{
   @Override
   protected void doPost(HttpServletRequest req,HttpServletResponse res)
   throws ServletException,IOException
   {
	   HttpSession hs=req.getSession(false);
	   if(hs==null)
	   {
		   req.setAttribute("msg","Session Expired Please Login Again....<br>");
		   req.getRequestDispatcher("msg.jsp").forward(req, res);
	   }
	   Student student =new Student();
	   student.setRollNo(req.getParameter("rno"));
	   int coreJava=Integer.parseInt(req.getParameter("cj")) ;
		  int advJava=Integer.parseInt(req.getParameter("aj")) ;
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
		  student.setTotalMarks(totalMarks);
		  student.setPercentage(per);
		  student.setResult(result);
		  		  student.getMarks().setCoreJava(coreJava);
		  student.getMarks().setAdvJava(advJava);
		  student.getMarks().setHtml(html);
		  student.getMarks().setDb(dataBase);
		  student.getMarks().setC(c);
		  student.getMarks().setJavascript(javaScript);
	  
	   int update = new StudentDAO().updateMarks(student);
	   if(update >0)
	   {
		   req.setAttribute("msg", "Student Marks Updated Successfully...");
		   req.getRequestDispatcher("updateMarks.jsp").forward(req, res);
	   }
   }
   
}
