<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false" %>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome</h1>

<table>
<tr>

<th>id</th> 
<th>name</th>
<th>email</th>
<th>contact</th>
<th>password</th>
<th>edit</th>
<th>delete</th>
</tr>


<c:forEach var="stu" items="${students}">

<tr>

<td>${stu.student_id }</td>
<td>${stu.studentname }</td>
<td>${stu.studentemail}</td>
<td>${stu.studentcontact}</td>
<td>${stu.studentPassword }</td>
<td><a href="edit?id=${stu.student_id }">edit</a></td>
<td><a href="delete?id=${stu.student_id }">delete</a></td>


</tr>






</c:forEach>

</table>
</body>
</html>