<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContentType 매핑</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#postBtn").on("click", function() {
			//json 데이터 형식 전송
			var boardNo = $("#boardNo");
			var title = $("#title");
			var content = $("#content");
			var writer = $("#writer");
			var boardNoVal = boardNo.val();
			var titleVal = title.val();
			var contentVal = content.val();
			var writerVal = writer.val();
			var boardObject = {
				boardNo : boardNoVal,
				title : titleVal,
				content : contentVal,
				writer : writerVal
			};
			$.ajax({
				type : "post",
				url : "/board4/" + boardNoVal,
				data : JSON.stringify(boardObject),
				contentType : "application/json; charset=utf-8",
				success : function(result) {
					console.log("result: " + result);
					if (result === "SUCCESS") {
						alert("SUCCESS");
					}
				}
			});
		});
		$("#putJsonBtn").on("click", function() {
			//json 데이터 형식 전송
			var boardNo = $("#boardNo");
			var title = $("#title");
			var content = $("#content");
			var writer = $("#writer");
			var boardNoVal = boardNo.val();
			var titleVal = title.val();
			var contentVal = content.val();
			var writerVal = writer.val();
			var boardObject = {
				boardNo : boardNoVal,
				title : titleVal,
				content : contentVal,
				writer : writerVal
			};
			$.ajax({
				type : "put",
				url : "/board4/" + boardNoVal,
				data : JSON.stringify(boardObject),
				contentType : "application/json; charset=utf-8",
				success : function(result) {
					console.log("result: " + result);
					if (result === "SUCCESS") {
						alert("SUCCESS");
					}
				}
			});
		});
		$("#putXmlBtn").on("click", function() {
			//xml 데이터 형식 전송
			var boardNo = $("#boardNo");
			var title = $("#title");
			var content = $("#content");
			var writer = $("#writer");
			var boardNoVal = boardNo.val();
			var titleVal = title.val();
			var contentVal = content.val();
			var writerVal = writer.val();
			var xmlData = "<Board>";
			xmlData += "<boardNo>0</boardNo>";
			xmlData += "<title>title1</title>";
			xmlData += "<content>content1</content>";
			xmlData += "<writer>writer1</writer>";
			xmlData += "<regDate>2018-12-10</regDate>";
			xmlData += "</Board>";
			$.ajax({
				type : "put",
				url : "/board4/" + boardNoVal,
				data : xmlData,
				contentType : "application/xml; charset=utf-8",
				success : function(result) {
					console.log("result: " + result);
					if (result === "SUCCESS") {
						alert("SUCCESS");
					}
				}
			});
		});
	});
</script>
<body>
	<h1>Ajax Home</h1>
	<form>
		boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
		title: <input type="text" name="title" value="" id="title"><br>
		content: <input type="text" name="content" value="" id="content"><br>
		writer: <input type="text" name="writer" value="" id="writer"><br>
	</form>
	<div>
		<button id="postBtn">수정(post-default(json))</button>
		<button id="putJsonBtn">수정(put json)</button>
		<button id="putXmlBtn">수정(put xml)</button>
	</div>
</body>
</html>