<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/jspstyle.css">
</head>
<body>
<%session.removeAttribute("admin");
session.removeAttribute("students");
session.invalidate();
out.println("Admin Log out successfully...<br>");%>
<%@ include file="index.html" %>
</body>
</html>