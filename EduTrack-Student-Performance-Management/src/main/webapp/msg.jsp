<%@page import="java.util.logging.ErrorManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="admin.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Failed</title>
<link rel="stylesheet" href="css/jspstyle.css">
</head>
<body>
<%

String msg=(String)request.getAttribute("msg");
if(msg!=null){
out.println(msg);%>
<%@include file="index.html" %>
<%
}
else
{
   String errmsg=(String)request.getAttribute("errmsg");
   out.println(errmsg);
   Admin admin=(Admin)session.getAttribute("admin");
   out.println("Admin,"+admin.getFirstName()+"<br>");
%>
   <a href="addStudent.html">Add new Student</a>
<a href="viewStudents">View All Students</a>
<a href="AdminLogout">Logout</a>
<% }%>


</body>
</html>