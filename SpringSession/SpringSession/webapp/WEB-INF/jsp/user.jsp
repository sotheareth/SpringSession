<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>
	<h1>User</h1>
	<h3>List of all the available Cookies</h3>
	<ul>
	<c:forEach var="cookies" items="${cookie}">
    	<li>
    		<c:out value="${cookies.key}"/>:
    		    	Object=<c:out value="${cookies.value}"/>,
    		    	value=<c:out value="${cookies.value.value}"/>
        </li>
	</c:forEach>
	</ul>
</body>
</html>