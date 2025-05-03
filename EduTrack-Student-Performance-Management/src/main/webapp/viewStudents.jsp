<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,admin.beans.*,student.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
<style>
tr,td
{
padding :5px;
}

</style>
<link rel="stylesheet" href="css/jspstyle.css">
</head>
<body>
<%List<Student> students=(List<Student>)session.getAttribute("students");
%>
<table border="1" cellspacing="0">
<tr>
<th>Roll No</th>
<th>Name</th>
<th>Course</th>
<th>Total Marks</th>
<th>Percentage</th>
<th>Result</th>
<th>Marks</th>
<th>Delete</th>
</tr>
<% if (students == null || students.isEmpty()) 
{ %>
    <tr>
        <td colspan="8" style="text-align:center">No students found</td>
    </tr>
	<% }
else
{
	Iterator<Student> itr=students.iterator();
	
	while(itr.hasNext())
	{ Student student = itr.next();%>
		<tr>
    <td><%= student.getRollNo()%></td>
    <td><%= student.getName() %></td>
    <td><%= student.getCourse() %></td>
    <td><%= student.getTotalMarks() %></td>
    <td><%= student.getPercentage() %></td>
    <td><%= student.getResult() %></td>
    <td><a href="studentMarks?rno=<%=student.getRollNo() %>">View Marks</a></td>
    <td><a href="deleteStudent?rno=<%=student.getRollNo() %>">Delete Student</a></td>
</tr>
	<% }
}%>
	

</table>
<%Admin admin=(Admin)session.getAttribute("admin");
out.println("<br>Admin, "+admin.getFirstName()+"<br>");%>
<a href="addStudent.html">Add new Student</a>
<a href="AdminLogout">Logout</a>
</body>
</html>