<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accept 매핑</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#getBtn").on("click", function() {
			var boardNo = $("#boardNo");
			var boardNoVal = boardNo.val();
			console.log(boardNoVal);
			$.get("/board5/" + boardNoVal, function(data) {
				console.log(data);
				alert(JSON.stringify(data));
			});
		});
		$("#getJsonBtn").on("click", function() {
			var boardNo = $("#boardNo");
			var boardNoVal = boardNo.val();
			console.log(boardNoVal);
			$.ajax({
				type : "get",
				url : "/board5/" + boardNoVal,
				headers : {
					"Accept" : "application/json"
				},
				success : function(result) {
					console.log("result: " + result);
					alert(JSON.stringify(result));
				}
			});
		});
		$("#getXmlBtn").on("click", function() {
			var boardNo = $("#boardNo");
			var boardNoVal = boardNo.val();
			console.log(boardNoVal);
			$.ajax({
				type : "get",
				url : "/board5/" + boardNoVal,
				headers : {
					"Accept" : "application/xml"
				},
				success : function(result) {
					console.log("result: " + result);
					alert(xmlToString(result));
				}
			});
		});
	});
	function xmlToString(xmlData) {
		var xmlString;
		if (window.ActiveXObject) {
			xmlString = xmlData.xml;
		} else {
			xmlString = (new XMLSerializer()).serializeToString(xmlData);
		}

		return xmlString;
	}
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
		<button id="getBtn">읽기(default)</button>
		<button id="getJsonBtn">읽기(JSON)</button>
		<button id="getXmlBtn">읽기(XML)</button>
	</div>
</body>
</html>