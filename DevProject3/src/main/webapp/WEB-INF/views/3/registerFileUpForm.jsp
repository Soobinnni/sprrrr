<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 폼 요청처리</title>
</head>
<body>
	<!--   파일업로드 시에는 form태그의 enctype이 "multipart/form-data/로 설정되어 있어야 한다.
		  method는 "POST"이어야 한다.
		  input 태그의 type 속성 값을 "file"로 지정해야한다.
		  type이 "file"인 input태그가 여러 개 있고, name 속성의 값이 같다면 파일이 배열 형태로 Controller에게 전달된다. -->
		  
	<h2>파일 업로드 폼 요청처리</h2>
	<!-- mapping : /registerFileUp01 MultipartFile의 메서드 파라미터명은 picture이어야 input type="file"의
		value가 Controller에 전달될 수 있다.-->
	<form action="/registerFileUp01" method="post"
		enctype="multipart/form-data">
		1. <input type="file" name="picture"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp02 -->
	<form action="/registerFileUp02" method="post"
		enctype="multipart/form-data">
		2.userId: <input type="text" name="userId" value="hong"><br>
		2.password: <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp03 -->
	<form action="/registerFileUp03" method="post"
		enctype="multipart/form-data">
		3.userId: <input type="text" name="userId" value="hong"><br>
		3.password: <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp04 -->
	<form action="/registerFileUp04" method="post"
		enctype="multipart/form-data">
		4.userId: <input type="text" name="userId" value="hong"><br>
		4.password: <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp05 -->
	<form action="/registerFileUp05" method="post"
		enctype="multipart/form-data">
		5.userId: <input type="text" name="userId" value="hong"><br>
		5.password: <input type="text" name="password" value="1234"><br>
		<input type="file" name="picture"> <br> <input
			type="file" name="picture2"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp06  -->
	<form action="/registerFileUp06" method="post"
		enctype="multipart/form-data">
		6-1.userId: <input type="text" name="userId" value="hong"><br>
		6-1.password: <input type="text" name="password" value="1234"><br>
		<input type="file" name="pictureList[0]"> <br> <input
			type="file" name="pictureList[1]"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp06 -->
	<form action="/registerFileUp06" method="post"
		enctype="multipart/form-data">
		6-2.userId: <input type="text" name="userId" value="hong1"><br>
		6-2.password: <input type="text" name="password" value="12345"><br>
		<input type="file" name="pictureList"> <br> <input
			type="file" name="pictureList"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp07 -->
	<form action="/registerFileUp07" method="post"
		enctype="multipart/form-data">
		7.userId: <input type="text" name="userId" value="hong"><br>
		7.password: <input type="text" name="password" value="1234"><br>
		<input type="file" name="pictureList[0]"> <br> <input
			type="file" name="pictureList[1]"> <input type="submit">
	</form>
	
	<!-- mapping : /registerFileUp08 -->
	<form action="/registerFileUp08" method="post"
		enctype="multipart/form-data">
		8.userId: <input type="text" name="userId" value="hong"><br>
		8.password: <input type="text" name="password" value="1234"><br>
		<input type="file" name="pictureList" multiple> <input
			type="submit">
	</form>
</body>
</html>