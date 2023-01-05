<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리 Register Form</title>
</head>
<body>
	<h1>요청 처리 Register Form</h1>
	<a href="register?userId=hong&password=1234">register?userId=hong&amp;password=1234</a>
	<!-- form  -->
	<form action="/register01" method="post">
		userId: <input type="text" name="userId" value="hong01"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="101"><br> <input
			type="submit" value="register01">
	</form>

	<!-- form  -->
	<form action="/register02" method="post">
		userId: <input type="text" name="userId" value="hong02"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="102"><br> <input
			type="submit" value="register02">
	</form>
	<!-- form  -->
	<form action="/register03" method="post">
		userId: <input type="text" name="userId" value="hong03"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="103"><br> <input
			type="submit" value="register03">
	</form>
	<!-- form  -->
	<form action="/register04" method="post">
		userId: <input type="text" name="userId" value="hong04"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="104"><br> <input
			type="submit" value="register04">
	</form>
	<!-- form  -->
	<form action="/register05" method="post">
		userId: <input type="text" name="userId" value="hong05"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="105"><br> <input
			type="submit" value="register05">
	</form>
</body>
</html>