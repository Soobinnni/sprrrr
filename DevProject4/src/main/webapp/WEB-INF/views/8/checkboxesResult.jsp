<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form TextArea</title>
</head>
<body>
	<h3>Spring Form TextArea Result</h3>
	<h4>hobbyList :</h4>
	<c:forEach var="hobby" items="${hobbyList}">
		<c:out value="${hobby}" />
		<br>
	</c:forEach>
</body>
</html>