<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form CheckBox</title>
</head>
<body>
	<h2>Spring Form CheckBox</h2>
	<form:form modelAttribute="member" method="post" action="register6">
		<table>
			<tr>
				<td>개발자여부</td>
				<td><form:checkbox path="developer" value="Y" /></td>
			</tr>
			<tr>
				<td>외국인여부</td>
				<td><form:checkbox path="foreigner" value="false" /></td>
			</tr>
			<tr>
				<td>취미(hobby)</td>
				<!-- path로 controller에 보낼 때 데이터를 Member를 초기화할 수 있다 -->
				<td><form:checkbox path="hobby" value="Sports" label="
Sports" />
					<br> <form:checkbox path="hobby" value="Music" label=" Music" />
					<br> <form:checkbox path="hobby" value="Movie" label=" Movie" />
				</td>
			</tr>
			<tr>
				<td>취미(hobbyArray)</td>
				<td><form:checkbox path="hobbyArray" value="Sports"
						label="
Sports" /> <br> <form:checkbox path="hobbyArray"
						value="Music" label="
Music" /> <br> <form:checkbox
						path="hobbyArray" value="Movie" label="
Movie" /></td>
			</tr>
			<tr>
				<td>취미(hobbyList)</td>
				<td><form:checkbox path="hobbyList" value="Sports"
						label="
Sports" /> <br> <form:checkbox path="hobbyList"
						value="Music" label="
Music" /> <br> <form:checkbox
						path="hobbyList" value="Movie" label="
Movie" /></td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>