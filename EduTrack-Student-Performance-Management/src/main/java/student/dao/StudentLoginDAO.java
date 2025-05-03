package student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import student.beans.Student;
import studentmanagement.db.DBConnection;

public class StudentLoginDAO 
{
      public Student login(String rollNo)
      {
    	  Student student=null;
    	  try
    	  {
    		  Connection conn=DBConnection.getConn();
    		  PreparedStatement ps1=conn.prepareStatement("select * from student where rollNo=?");
    		  PreparedStatement ps2=conn.prepareStatement("select * from studentmarks where rollno=?");
    		  ps1.setString(1, rollNo);
    		  ps2.setString(1, rollNo);
    		  ResultSet rs1=ps1.executeQuery();
    		  ResultSet rs2=ps2.executeQuery();
    		  if(rs1.next() && rs2.next())
    		  {
    			  student=new Student();
    			  student.setRollNo(rs1.getString(1));
    			  student.setName(rs1.getString(2));
    			  student.setCourse(rs1.getString(3));
    			  student.setTotalMarks(rs1.getInt(4));
    			  student.setPercentage(rs1.getDouble(5));
    			  student.setResult(rs1.getString(6));
    			  student.getMarks().setCoreJava(rs2.getInt(2));
    			  student.getMarks().setAdvJava(rs2.getInt(3));
    			  student.getMarks().setHtml(rs2.getInt(4));
    			  student.getMarks().setDb(rs2.getInt(5));
    			  student.getMarks().setC(rs2.getInt(6));
    			  student.getMarks().setJavascript(rs2.getInt(7));
    			  
    		  }
    		   
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  e.printStackTrace();
    	  }
    	  return student;
      }
}
