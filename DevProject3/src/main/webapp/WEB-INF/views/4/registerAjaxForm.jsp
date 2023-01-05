<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 방식 요청 처리</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		//id = "registerBtn01"의 click이벤트 처리
		$("#registerBtn01").on("click", function(){
			$.get("/ajaxRegister01/hong", function(result){
				console.log(result);
				if (result=="SUCCESS") {
					alert("응답 성공");
				}
			});
		});
		
		//id="registerBtn02" click이벤트 처리
		$("#registerBtn02").on("click", function(){
			var userId = $("#userId");
			var password = $("#password");
			var userIdVal = userId.val();
			var passwordVal = password.val();
			
			var jsonObject = {userId:userIdVal,
					password:passwordVal};
			var jsonStg = JSON.stringify(jsonObject);
			
			//ajax로 Controller에 요청
			$.ajax({
				type : "post",
				url : "/ajaxRegister02/hong/pwd1",
				data : jsonStg,
				contentType : "application/json; charset=utf-8",
				success : function(result){
					console.log(result);
					if (result == 'SUCCESS') {
						alert("응답 성공");
					}
				}
			});
		});
		
		//id ="registerBtn03"의 click이벤트 처리. 응답 Controller에선, 요청 param을 자바빈즈로 저장한다.
		$("#registerBtn03").on("click", function(){
			var userId = $("#userId");
			var password = $("#password");
			var userIdVal = userId.val();
			var passwordVal = password.val();
			
			var jsonObject = {userId:userIdVal,
					password:passwordVal};
			var jsonStg = JSON.stringify(jsonObject);
			
			//ajax로 Controller에 요청
			$.ajax({
				type : "post",
				url : "/ajaxRegister03",
				data : jsonStg,
				contentType : "application/json; charset=utf-8",
				success : function(result){
					console.log(result);
					if (result == "SUCCESS") {
						alert("응답 성공");
					}
				}
			});
		});
		
		//id ="registerBtn04" click이벤트 처리
		$("#registerBtn04").on("click", function(){
			//url로 param을 보낼 것이기 때문에 JSON객체 생성할 필요가 X
			$.ajax({
				type :"post",
				url : "/ajaxRegister04?userId=kimSoob",
				//data, contentType은 param을 url에 붙였기 때문에 생략 가능
				success : function(result){
					console.log(result);
					if (result == "SUCCESS") {
						alert("응답 성공");
					}
				}
			});
		});
		
		//id = "registerBtn05" click 이벤트 처리
		$("#registerBtn05").on("click", function(){
			//1. 경로변수 2. json배열 보내기
			var userId = $("#userId");
			var password = $("#password");
			var userIdVal = userId.val();
			var passwordVal = password.val();
			var jsonObject = {userId : userIdVal, password : passwordVal};
			var jsonStg = JSON.stringify(jsonObject);
			
			$.ajax({
				type : "post",
				url : "/ajaxRegister05/userId?kimkim",
				data : jsonStg,
				contentType : "application/json; charset=utf-8",
				success : function(result){
					console.log(result);
					if (result == "SUCCESS") {
						alert("응답 성공");
					}
				}
			});
		});
		//id = "registerBtn06" click 이벤트 처리
		$("#registerBtn06").on("click", function(){
			var jsonObjectArr = [
				{"userId" : "kim", "password" : "1234"},
				{"userId" : "lee", "password" : "5678"}
			];
			var toStringify = JSON.stringify(jsonObjectArr);
			
			$.ajax({
				type : "post",
				url : "/ajaxRegister06",
				data : toStringify,
				contentType : "application/json; charset=utf-8",
				success : function(result){
					console.log(result);
					if (result == "SUCCESS") {
						alert("응답 성공");
					}
				}
			});
		});
		//id = "registerBtn07" click 이벤트 처리
		$("#registerBtn07").on("click", function(){
			//MemberAjax의 필드멤버 Address객체의 데이터 넣기
			var userId = $("#userId");
			var password = $("#password");
			var userIdVal = userId.val();
			var passwordVal = password.val();
			var jsonObject = {userId:userIdVal, password:passwordVal, 
					address :{
						postCode:"010908", location:"seoul"
						}
					};
			var toStrg = JSON.stringify(jsonObject);
			$.ajax({
				type : "post",
				url : "/ajaxRegister07",
				data : toStrg,
				contentType : "application/json; charset=utf-8",
				success : function(result){
					console.log(result);
					if (result == "SUCCESS") {
						alert("응답 성공");
					}
				}
			});
		});
		
		
		//id = "registerBtn08" click 이벤트 처리
		$("#registerBtn08").on("click", function(){
			//MemberAjax 내, List<Card>의 값 넣기
			var userId = $("#userId");
			var password = $("#password");
			var userIdVal = userId.val();
			var passwordVal = password.val();
			var jsonOb = {userId:userIdVal, password:passwordVal, 
					cardList : [
						{no:"23456", validMonth:"20190908"}, 
						{no:"12342", validMonth:"20200705"}
						]
					};
			var strJson = JSON.stringify(jsonOb);
			$.ajax({
				type : "post",
				url : "/ajaxRegister08",
				data: strJson,
				contentType : "application/json; charset=utf-8",
				success : function(result) {
					console.log(result);
					if (result === "SUCCESS") {
						alert("SUCCESS");
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>Ajax 방식 요청 처리</h1>
	<form>
		userId: <input type="text" name="userId" value="hong" id="userId"><br>
		password: <input type="text" name="password" value="1234"
			id="password"><br>
	</form>
	<button id="registerBtn01">registerBtn01</button>
	<button id="registerBtn02">registerBtn02</button>
	<button id="registerBtn03">registerBtn03</button>
	<button id="registerBtn04">registerBtn04</button>
	<button id="registerBtn05">registerBtn05</button>
	<button id="registerBtn06">registerBtn06</button>
	<button id="registerBtn07">registerBtn07</button>
	<button id="registerBtn08">registerBtn08</button>
</body>
</html>