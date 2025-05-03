<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="student.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Home</title>
<link rel="stylesheet" href="css/jspstyle.css">
</head>
<body>
<% Student student=(Student) session.getAttribute("student");
out.println("Welcome,"+student.getName().split(" ")[0]+"<br>");
%>
<a href="viewStudent">View Details</a>
<a href="studentlogout">Logout</a>
</body>
</html>