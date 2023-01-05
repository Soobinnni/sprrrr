<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//form을 객체로 저장
		var formObj = $("#board");

		//id ="btnRegister" click 이벤트 처리 : 등록을 한다.
		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/board/register");
			formObj.attr("method", "post");
			formObj.submit();
			//  $("#searchform").attr("action","/main/search").attr("method", "post").submit();
		});

		//id ="btnList" click 이벤트 처리 : list를 본다
		$("#btnList").on("click", function() {
			// 내장객체 self : 현재 창을 선택한다. self.location ==> 현재 창 이동
			self.location = "/board/list";
		});

	});
</script>
</head>
<body>
	<h2>REGISTER</h2>
	<form:form modelAttribute="board" action="register">
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" /></td>
				<td><font color="red"><form:errors path="title" /></font></td>
			</tr>
			<tr>
				<td>Writer</td>
				<td><form:input path="writer" /></td>
				<td><font color="red"><form:errors path="writer" /></font></td>
			</tr>
			<tr>
				<td>Content</td>
				<td><form:textarea path="content" /></td>
				<td><font color="red"><form:errors path="content" /></font></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnRegister">Register</button>
		<button type="submit" id="btnList">List</button>
	</div>
</body>
</html>