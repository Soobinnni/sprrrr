<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date 타입 처리</title>
</head>
<body>
	<h1>Date 타입 처리</h1>
	<a href="registerByDate01?userId=hong&dateOfBirth=2000/10/20">registerByDate01?userId=hon
		g&ampdateOfBirth=2000/10/20</a>
	<br>
	<a href="registerByDate02?userId=hong&dateOfBirth=2000/10/20">registerByDate02?userId=hon
		g&ampdateOfBirth=2000/10/20</a>
	<br>
	<form action="/registerdate" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		dateOfBirth: <input type="text" name="dateOfBirth" value="2000/10/20"><br>
		<input type="submit" value="registerdate">
	</form>
	<br><br><br>
	<h1>Date 타입 처리 @DateTimeFormat이용하기</h1>
	
	<a href="registerByDate03?userId=hong&dateOfBirth=19980617">registerByDate01?userId=hon
		g&ampdateOfBirth=19980617</a>
	<br>
	<a href="registerByDate04?userId=hong&dateOfBirth=20020402">registerByDate02?userId=hon
		g&ampdateOfBirth=20020402</a>
	<br>
	<form action="/registerdate2" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		dateOfBirth: <input type="text" name="dateOfBirth" value="20220103"><br>
		<input type="submit" value="registerdate2">
	</form>
</body>
</html>