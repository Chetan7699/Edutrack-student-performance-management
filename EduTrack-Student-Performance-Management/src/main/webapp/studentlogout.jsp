<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/jspstyle.css">
</head>
<body>
<%session.removeAttribute("student");
session.invalidate();
out.println("Student Logout Successfully...<br>");%>
<%@include file="index.html" %>
</body>
</html>