<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<h2>회원 가입</h2>
<form method="post" action="registerUser">
	<table>
		<tr>
			<td>유저ID</td>
			<td><input type="text" name="userId" /></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" /></td>
		</tr>
		<tr>
			<td>E-MAIL</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="dateOfBirth" /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value="male" checked>
				Male<br> <input type="radio" name="gender" value="female">
				Female<br> <input type="radio" name="gender" value="other">
				Other</td>
		</tr>
		<tr>
			<td>개발자여부</td>
			<td><input type="checkbox" name="developer" value="Y"></td>
		</tr>
		<tr>
			<td>외국인여부</td>
			<td><input type="checkbox" name="foreigner" value="false">
			</td>
		</tr>
		<tr>
			<td>국적</td>
			<td><select name="nationality" class="jobs">
					<option value="Korea" selected>대한민국</option>
					<option value="Germany">독일</option>
					<option value="Australia">호주</option>
					<option value="Canada">캐나다</option>
			</select></td>
		</tr>
		<tr>
			<td>소유차량</td>
			<td><select name="cars" multiple>
					<option value="volvo">Volvo</option>
					<option value="saab">Saab</option>
					<option value="opel">Opel</option>
					<option value="audi">Audi</option>
			</select></td>
		</tr>
		<tr>
			<td>소유차량</td>
			<td><select name="carArray" multiple>
					<option value="volvo">Volvo</option>
					<option value="saab">Saab</option>
					<option value="opel">Opel</option>
					<option value="audi">Audi</option>
			</select></td>
		</tr>
		<tr>
			<td>소유차량</td>
			<td><select name="carList" multiple>
					<option value="volvo">Volvo</option>
					<option value="saab">Saab</option>
					<option value="opel">Opel</option>
					<option value="audi">Audi</option>
			</select></td>
		</tr>
		<tr>
			<td>취미</td>
			<td><input type="checkbox" name="hobby" value="Sports">
				Sports<br> <input type="checkbox" name="hobby" value="Music">
				Music<br> <input type="checkbox" name="hobby" value="Movie">
				Movie</td>
		</tr>
		<tr>
			<td>취미</td>
			<td><input type="checkbox" name="hobbyArray" value="Sports">
				Sports<br> <input type="checkbox" name="hobbyArray"
				value="Music"> Music<br> <input type="checkbox"
				name="hobbyArray" value="Movie"> Movie</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" name="address.postCode" /></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address.location" /></td>
		</tr>
		<tr>
			<td>카드1 - 번호</td>
			<td><input type="text" name="cardList[0].no" /></td>
		</tr>
		<tr>
			<td>카드1 - 유효년월</td>
			<td><input type="text" name="cardList[0].validMonth" /></td>
		</tr>
		<tr>
			<td>카드2 - 번호</td>
			<td><input type="text" name="cardList[1].no" /></td>
		</tr>
		<tr>
			<td>카드2 - 유효년월</td>
			<td><input type="text" name="cardList[1].validMonth" /></td>
		</tr>
		<tr>
			<td>소개</td>
			<td><textarea name="introduction" rows="6" cols="50"></textarea>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><input type="submit" name="btnSubmit" value="등록"></td>
			<td><input type="reset" name="btnReset" value="리셋"></td>
		</tr>
	</table>
</form>
</body>
</html>