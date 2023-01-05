<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form CheckBox</title>
</head>
<body>
	<h3>CheckBox Result</h3>
	<table>
		<tr>
			<td>개발자여부</td>
			<td>${member.foreigner}</td>
		</tr>
		<tr>
			<td>외국인여부</td>
			<td>${member.developer}</td>
		</tr>
		<tr>
			<td>취미(hobby)</td>
			<td>${member.hobby}</td>
		</tr>
		<tr>
			<td>취미(hobbyArray)</td>
			<td><c:forEach var="hobby" items="${member.hobbyArray}">
${hobby} <br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>취미(hobbyList)</td>
			<td><c:forEach var="hobby" items="${member.hobbyList}">
${hobby} <br>
				</c:forEach></td>
		</tr>
	</table>
</body>
</html>