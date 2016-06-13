<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<form name='formID' action="<c:url value='/login' />"
		method='POST'>

		<table>
			<tr>
				<td>Username:</td>
				<td><input type='text' name='username'
					class="textfield validate[required]" placeholder="Username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password'
					class="textfield validate[required]" placeholder="Password" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" class="btn btn-success" /></td>
			</tr>
		</table>
		
<%-- 		<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 						value="${_csrf.token}" /> --%>
	</form>
</body>
</html>