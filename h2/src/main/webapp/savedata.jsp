<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="save" method="post" modelAttribute="studentdata">
Enter id:-		<input type="number" name="id" id="id"><br>
Enter name:-		<input type="text" name="name" id="name"><br>
Enter address:-		<input type="text" name="address" id="section"><br>
		<button>Save</button>
	</form:form>
</body>
</html>