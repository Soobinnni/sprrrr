<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#putBtn").on("click", function() {
		var boardNo = $("#a");
		var title = $("#b");
		var content = $("#c");
		var writer = $("#d");

		var a = boardNo.val();
		var b = title.val();
		var c = content.val();
		var d = writer.val();

		//json객체
		var boardObject = {
			boardNo : a,
			title : b,
			content : c,
			writer : d
		};

		$.ajax({
			type : "put",
			url : "/board3/" + a,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if (result == "a") {
					alert('SUCCESS');
				}
			}
		})
	})

	$("#putHeaderBtn").on("click", function() {
		var boardNo = $("#boardNo");
		var title = $("#title");
		var content = $("#content");
		var writer = $("#writer");

		var boardNoVal = boardNo.val();
		var titleVla = title.val();
		var contentVal = content.val();
		var writerVal = writer.val();

		//json객체
		var boardObject = {
			boardNo : boardNoval,
			title : titleVal,
			content : contentVal,
			writer : writerVal
		};

		$.ajax({
			type : "put",
			url : "/board3/" + boardNoval,
			header : {
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if (result == "a") {
					alert("SUCCESS");
				}
			}
		})
	})	
})
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax Home</h1>
	<form>
		boardNo: <input type="text" name="boardNo" id="a"><br>
		title: <input type="text" name="title" id="b"><br>
		content: <input type="text" name="content" id="c"><br>
		writer: <input type="text" name="writer" id="d"><br>
	</form>
	<div>
		<button id="putBtn">수정(put)</button>
		<button id="putHeaderBtn">수정(put with header)</button>
	</div>

</body>
</html>