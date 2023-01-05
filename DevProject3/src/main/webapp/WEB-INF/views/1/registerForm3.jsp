<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리 자바빈즈</title>
</head>
<body>
	<h1>요청 처리 자바빈즈</h1>
	<form action="/registerbeans01" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br> <input
			type="submit" value="registerbeans01">
	</form>
	<form action="/registerbeans02" method="post">
		userId: <input type="text" name="userId" value="hong"><br>
		password: <input type="text" name="password" value="1234"><br>
		coin: <input type="text" name="coin" value="100"><br> 
		exam : <input type="text" name="exam" value="forExample"><br>
		<input type="submit" value="registerbeans02"> 
	</form>
</body>
</html>