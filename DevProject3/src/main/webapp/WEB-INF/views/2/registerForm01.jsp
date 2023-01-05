<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>폼 양식 요청 처리</title>
</head>
<body>
	<h2>폼 양식 요청 처리</h2>
	
	<!-- mapping : /registerUserId 각각 다른 userId가 Member3에 초기화됨  -->
	<form action="/registerUserId" method="post">
		userId: <input type="text" name="userId" /><br> <input
			type="submit" value="registerUserId">
	</form>
	<form action="/registerMemberUserId" method="post">
		userId: <input type="text" name="userId" /><br> <input
			type="submit" value="registerMemberUserId">
	</form>
	
	<!-- mapping : /registerPassword password가 필드변수명과 폼필드네임명이 같아서 변수로 쓰일 것 -->
	<form action="/registerPassword" method="post">
		password: <input type="password" name="password" /><br> <input
			type="submit" value="registerPassword">
	</form>
	
	<!-- mapping : /registerRadio (라디오는 택1가능. 라디오의 name을 통일. Controller parameter명 radio의 name과
					일치시켜 parameter로 사용-->
	<form action="/registerRadio" method="post">
		gender: <br> <input type="radio" name="gender" value="male"
			checked> Male<br> <input type="radio" name="gender"
			value="female"> Female<br> <input type="radio"
			name="gender" value="other"> Other<br> <input
			type="submit" value="registerRadio">
	</form>
	
	<!-- mapping : /registerSelect select은 속성 multiple을 적용하지 않으면 택 1.
		∴ select의 name과 Controller 메서드 파리미터 변수명을 일치시켜 메서드의 지역변수로 활용-->
	<form action="/registerSelect" method="post">
		nationality: <select name="nationality">
			<option value="Korea" selected>대한민국</option>
			<option value="Germany">독일</option>
			<option value="Australia">호주</option>
			<option value="Canada">캐나다</option>
		</select><br> <input type="submit" value="registerSelect">
	</form>
	
	<!-- mapping :/registerMultipleSelect01,02, 03 -->
	<!-- select에 multiple속성을 이용하여 다중 선택 가능하게 함. 이 경우, String배열을 이용해
		필드의 값들을 변수로 저장하거나, ArrayList로 String객체들을 저장한다. -->
	<form action="/registerMultipleSelect01" method="post">
		cars: <select name="cars" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect01">
	</form>
	<!-- carArray name과 Controller 메서드 String배열 인스턴스명을 일치시켜 
		select value들을 저장한다. -->
	<form action="/registerMultipleSelect02" method="post">
		carArray: <select name="carArray" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect02">
	</form>
	<!-- carList name과 Controller 메서드 ArrayList 인스턴스명을 일치시켜 
		select value들을 저장한다. -->
	<form action="/registerMultipleSelect03" method="post">
		carList: <select name="carList" multiple>
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="opel">Opel</option>
			<option value="audi">Audi</option>
		</select><br> <input type="submit" value="registerMultipleSelect03">
	</form>
	
	<!-- mapping :/registerCheckbox01~04 -->
	<!-- checkbox는 다중 선택이 가능.  -->
	<form action="/registerCheckbox01" method="post">
		hobby: <br> <input type="checkbox" name="hobby" value="Sports">
		Sports<br> <input type="checkbox" name="hobby" value="Music">
		Music<br> <input type="checkbox" name="hobby" value="Movie">
		Movie<br> <input type="submit" value="registerCheckbox01">
	</form>
	<!-- 다중선택이 String배열로 저장 -->
	<form action="/registerCheckbox02" method="post">
		hobbyList: <br> <input type="checkbox" name="hobbyArray"
			value="Sports"> Sports<br> <input type="checkbox"
			name="hobbyArray" value="Music"> Music<br> <input
			type="checkbox" name="hobbyArray" value="Movie"> Movie<br>
		<input type="submit" value="registerCheckbox02">
	</form>
	<!-- 체크박스 value는 체크를 하게 되면 전달되고, 아니면 null이 전달된다. -->
	<form action="/registerCheckbox03" method="post">
		developer: <input type="checkbox" name="developer" value="Y"><br>
		<input type="submit" value="registerCheckbox03">
	</form>
	<!-- 체크를 하면 value boolean값 false가 전달된다. -->
	<form action="/registerCheckbox04" method="post">
		foreigner: <input type="checkbox" name="foreigner" value="false"><br>
		<input type="submit" value="registerCheckbox04">
	</form>
	
	<!-- mapping : /registerAddress 폼필드name 값으로 변수 Address가 초기화된다.-->
	<form action="/registerAddress" method="post">
		postCode: <input type="text" name="postCode" /><br> location: <input
			type="text" name="location" /><br> <input type="submit"
			value="registerAddress">
	</form>
	
	<!-- mapping : /registerUserAddress Member3와 has-a관계가 있는 Address가(Member3의 필드멤버인 Address)
		Member3에서 변수명이 아래의 폼name의 온점 전에 위치한 속성명과 일치하고 Address에서 필드변수명과
		온점 후에 위치한 속성명과 일치할 때, Controller의 메서드에서 Address address = member.getAddress();로
		얻은 후, get으로 폼의 value들을 이용할 수 있다.-->
	<form action="/registerUserAddress" method="post">
		address.postCode: <input type="text" name="address.postCode" /><br>
		address.location: <input type="text" name="address.location" /><br>
		<input type="submit" value="registerUserAddress">
	</form>
	
	<!-- mapping : /registerUserCardList
		List<Card>는 Member3의 필드멤버. 위와 같은 논리로 파리미터에 접근할 수 있으며
		Card의 필드멤버는 Member3의 List인스턴스명으로 접근할 수 있다. -->
	<form action="/registerUserCardList" method="post">
		카드1 - 번호 : <input type="text" name="cardList[0].no" /><br> 카드1 -
		유효년월 : <input type="text" name="cardList[0].validMonth" /><br>
		<br> 카드2 - 번호 : <input type="text" name="cardList[1].no" /><br>
		카드2 - 유효년월 : <input type="text" name="cardList[1].validMonth" /><br>
		<br> <input type="submit" value="registerUserCardList">
	</form>
	
	<!-- mapping : /registerTextArea 폼필드 name과 Controller 메서드의 파라미터명을 일치하여 값을 가져간다.-->
	<form action="/registerTextArea" method="post">
		introduction: <br>
		<textarea name="introduction" rows="6" cols="50"></textarea>
		<br> <input type="submit" value="registerTextArea">
	</form>
	
	<!-- mapping : /registerDate01 / @DateTimeFormat(pattern = "yyyyMMdd")-->
	<form action="/registerDate01" method="post">
		dateOfBirth: <input type="text" name="dateOfBirth" /><br> <input
			type="submit" value="registerDate01">
	</form>
</body>
</html>