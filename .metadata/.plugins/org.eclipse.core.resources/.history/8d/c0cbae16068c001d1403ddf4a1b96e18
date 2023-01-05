<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form Select</title>
</head>
<body>
	<h2>Spring Form Select_02</h2>
	<form:form modelAttribute="member" method="post" action="register12">
		<table>
			<tr>
				<td>국적</td>
				<td><form:select path="nationality"
						items="${nationalityCodeList}" itemValue="value" itemLabel="label" />
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>
