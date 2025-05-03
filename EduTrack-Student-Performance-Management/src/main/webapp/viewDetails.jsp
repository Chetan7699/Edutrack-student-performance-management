<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="student.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/jspstyle.css">
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
<%Student student=(Student) session.getAttribute("student");
%>
<table border="1" cellspacing="0">
<tr>
<th>RollNo </th> 
<th>Name </th> 
<th>Course </th> 
<th>Total Marks </th> 
<th>Percentage </th> 
<th>Result </th> 
<th>Marks </th>
</tr>
<tr>
<td><%=student.getRollNo() %></td>
<td><%=student.getName() %></td>
<td><%=student.getCourse() %></td>
<td><%=student.getTotalMarks() %></td>
<td><%=student.getPercentage() %></td>
<td><%=student.getResult() %></td>
<td><a href="getMarks">View Marks</a></td>
 </tr>
</table>
<a href="studentlogout">Logout</a>
</body>
</html>