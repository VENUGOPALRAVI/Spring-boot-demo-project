<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form:form action="update" modelAttribute="student_dto">

id: <form:input path="student_id" readonly="true"/><br><br>
name:    <form:input path="studentname"/>
<br><br>
Email:   <form:input path="studentemail"/>
<br><br>
contact: <form:input path="studentcontact"/>
<br><br>
password:<form:input path="studentPassword"/>
<br><br>
<input type="submit" >
</form:form>




</body>
</html>