<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,student.beans.*,admin.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marks</title>
<link rel="stylesheet" href="css/jspstyle.css">
</head>
<body>
<table border="1" cellspacing="0">
<tr>
<th>RollNo</th>
<th>Core Java</th>
<th>Advance Java</th>
<th>Html</th>
<th>DBMS</th>
<th>C</th>
<th>JavaScript</th>

</tr>
<%
Student student=(Student) request.getAttribute("student");
if(student==null)
{%>
<tr>
<td colspan="6">No Marks data found</td>
</tr>
<% }
else
{
	%>
	
		<tr>
		<td><%=student.getRollNo() %></td>
		<td><%=student.getMarks().getCoreJava() %></td>
		<td><%=student.getMarks().getAdvJava() %></td>
		<td><%=student.getMarks().getHtml()%></td>
		<td><%=student.getMarks().getDb() %></td>
		<td><%=student.getMarks().getC() %></td>
		<td><%=student.getMarks().getJavascript() %></td>
		</tr>
	
<%}%>
</table>
<%Admin admin=(Admin)session.getAttribute("admin");
out.println("<br>Admin, "+admin.getFirstName()+"<br>");%>
<a href="edit?rno=<%=student.getRollNo() %>">Edit Marks</a>
<a href="addStudent.html">Add new Student</a>
<a href="viewStudents">View All Students</a>
<a href="AdminLogout">Logout</a>
</body>
</html>