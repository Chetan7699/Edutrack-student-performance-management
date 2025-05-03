<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*,admin.beans.*,student.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Marks</title>
<link rel="stylesheet" href="css/jspstyle.css">
<link rel="stylesheet" href="css/style.css">
<script>
function validateForm() {
    let subjects = ["cj", "aj", "html", "db", "c", "js"];
    
    for (let i = 0; i < subjects.length; i++) {
        let marks = document.forms["editMarksForm"][subjects[i]].value;
        
        
        
        if (isNaN(marks) || marks < 0 || marks > 100) {
            alert("Marks should be a number between 0 and 100.");
            return false;
        }
    }
    return true;
}</script>


</head>
<body>
<%Student student=(Student)request.getAttribute("student") ;%>
<form name="editMarksForm" action="update" method="post" onsubmit="return validateForm()">
<input type="hidden" name="rno" value=<%=student.getRollNo() %>> 
Core Java: <input type="text" name="cj" value=<%=student.getMarks().getCoreJava() %>><br>
Advance Java: <input type="text" name="aj" value=<%=student.getMarks().getAdvJava() %>><br>
Html: <input type="text" name="html" value=<%=student.getMarks().getHtml() %>><br>
Database: <input type="text" name="db" value=<%=student.getMarks().getDb() %>><br>
C: <input type="text" name="c" value=<%=student.getMarks().getC() %>><br>
Javascript: <input type="text" name="js" value=<%=student.getMarks().getJavascript() %>><br>
<button type="submit">Update Marks</button>


</form>
</body>
</html>