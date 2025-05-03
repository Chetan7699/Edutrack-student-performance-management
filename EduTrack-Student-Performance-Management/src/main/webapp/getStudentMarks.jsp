<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="student.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<link rel="stylesheet" href="css/jspstyle.css">
<style>
 @page {
            margin: 0;
        }

        body {
            margin: 0;
            padding: 0;
        }

        
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }

       
        table {
            border-collapse: collapse;
            width: 90%; 
            text-align: center;
            font-size: 24px;
        }

        th, td {
            border: 2px solid black;
            padding: 15px; /* Increased padding */
        }

        th {
            background-color: #f2f2f2;
            font-size: 26px;
            color:black;
          }

        h2 {
            font-size: 36px;
        }

        
        @media print {
            body * {
                visibility: hidden;
            }
            #result, #result * {
                
                visibility: visible;
            }
            
        }
</style>


<script>
function printPdf()
{
	var printResult=document.getElementById("result").outerHTML;
	var originalData=document.body.innerHTML;
	document.body.innerHTML=printResult;
	window.print();
	document.body.innerHTML=originalData;
}

</script>
</head>
<body>
<%Student student=(Student) session.getAttribute("student");%>
<div id="result" class="container">
<table border="1" cellspacing="0">


<!-- <tr>
<th>Core Java </th> 
<th>Adv Java </th> 
<th>HTML</th> 
<th>DBMS</th> 
<th>C </th> 
<th>Javascript </th> 
<th>Total Marks </th> 
<th>Percentage </th> 
<th>Result </th> 
</tr> -->


<tr>
<th colspan="2">Name:<%=student.getName() %><br>Roll NO:<%=student.getRollNo() %> </th>
</tr>

<tr>
<td>Core Java</td>
<td><%=student.getMarks().getCoreJava() %></td> </tr>
<tr>
<td>Advanced Java</td>
<td><%=student.getMarks().getAdvJava() %></td>
</tr>
<tr>
<td>HTML</td>
<td><%=student.getMarks().getHtml()%></td>
</tr>
<tr>
<td>DBMS</td>
<td><%=student.getMarks().getDb() %></td>
</tr>
<tr>
<td>C</td>
<td><%=student.getMarks().getC() %></td>
</tr>
<tr>
<td>JavaScript</td>
<td><%=student.getMarks().getJavascript() %>
</td>
<tr>
<td >Total Marks</td>
<td><%=student.getTotalMarks() %></td>
</tr>
<tr>
<td >Percentage</td>
<td><%=student.getPercentage() %></td>
</tr>

<tr>
<td>Result</td>
<td><%=student.getResult() %></td>
 </tr>
</table>
</div>
<a href="#"onclick="printPdf()">Print Result</a>
<a href="studentlogout">Logout</a>

</body>
</html>