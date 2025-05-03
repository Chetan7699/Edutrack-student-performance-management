package student.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import student.beans.Student;
import studentmanagement.db.DBConnection;
public class StudentDAO {

	private static List<Student> students=null;
	
	public int addStudent(Student student)
	{
		int k=0;
		try
		{
			Connection conn = DBConnection.getConn();
			CallableStatement cs=conn.prepareCall("{call addStudent(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1,student.getRollNo());
			cs.setString(2, student.getName());
			cs.setString(3, student.getCourse());
			cs.setInt(4, student.getTotalMarks());
			cs.setDouble(5, student.getPercentage());
			cs.setString(6, student.getResult());
			cs.setInt(7, student.getMarks().getCoreJava());
			cs.setInt(8, student.getMarks().getAdvJava());
			cs.setInt(9, student.getMarks().getHtml());
			cs.setInt(10, student.getMarks().getDb());
			cs.setInt(11, student.getMarks().getC());
			cs.setInt(12, student.getMarks().getJavascript());
			k=cs.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	
	public List<Student> viewStudents()
	{
		
		try
		{
			Connection conn=DBConnection.getConn();
			PreparedStatement ps1=conn.prepareStatement("Select * from student");
			PreparedStatement ps2=conn.prepareStatement("Select * from studentmarks");
			
			ResultSet rs1 = ps1.executeQuery();
		    ResultSet rs2=ps2.executeQuery();
		    students=new ArrayList<Student>();
		    while(rs1.next() && rs2.next())
		    {
		    	Student student=new Student();
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
		    	students.add(student);
		    	
		    }
			
			
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return students;
	}
	
	
	public int updateMarks(Student student)
	{
		int k=0;
		try
		{
		Connection conn=DBConnection.getConn();
		PreparedStatement ps1=conn.prepareStatement("update student set totmarks=?,percentage=?,result=? where rollNo=?");
		PreparedStatement ps=conn.prepareStatement("update studentmarks set corejava=?,advjava=?,html=?,database=?,c=?,javascript=? where rollNo=?");
		ps.setInt(1, student.getMarks().getCoreJava());
		ps.setInt(2, student.getMarks().getAdvJava());
		ps.setInt(3, student.getMarks().getHtml());
		ps.setInt(4, student.getMarks().getDb());
		ps.setInt(5, student.getMarks().getC());
		ps.setInt(6, student.getMarks().getJavascript());
		ps.setString(7, student.getRollNo());
		
		k=ps.executeUpdate();
		if(k>0)
		{
			ps1.setInt(1, student.getTotalMarks());
			ps1.setDouble(2, student.getPercentage());
			ps1.setString(3, student.getResult());
			ps1.setString(4, student.getRollNo());
			int q=ps1.executeUpdate();
			if(k>0 && q>0)
			{
				return 1;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	
	
	public int deleteStudent(String rollNo)
	{
		int k=0;
		try
		{
			Connection conn=DBConnection.getConn();
			CallableStatement cs=conn.prepareCall("{call deleteStudent(?)}");
			cs.setString(1, rollNo);
			k=cs.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
