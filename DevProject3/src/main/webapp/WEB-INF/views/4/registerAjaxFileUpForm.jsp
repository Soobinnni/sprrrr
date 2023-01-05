<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 Ajax 방식 요청 처리</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#inputFile").on("change", function(event) {
			console.log("change 이벤트 발생");
			var files = event.target.files;
			var file = files[0]; //0인덱스 File객체 저장

			//폼 데이터 형성
			var formData = new FormData();
			formData.append('file', file); //<input name='file' value=file/>

			//ajax로 request
			$.ajax({
				type : "post",
				url : "/uploadAjax",
				data : formData,
				processData : false,
				contentType : false,
				success : function(result) {
					console.log(result);
					alert(result);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>파일 업로드 Ajax 방식 요청 처리</h2>
	<div>
		<input type='file' id='inputFile' />
	</div>
</body>
</html>