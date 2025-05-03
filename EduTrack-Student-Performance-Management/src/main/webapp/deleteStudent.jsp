<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="admin.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/jspstyle.css">
</head>
<body>
<%Admin admin=(Admin)  session.getAttribute("admin");
out.println("Admin,"+admin.getFirstName()+"<br>");
String msg=(String)request.getAttribute("msg");
out.println(msg);%>
<a href="addStudent.html">Add new Student</a>
<a href="viewStudents">View All Students</a>
<a href="AdminLogout">Logout</a>
</body>
</html>