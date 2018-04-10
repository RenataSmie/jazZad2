<%@ page language ="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="domain.UserModel"%>
<%
UserModel user = null;
if(request.getSession().getAttribute("conf") != null){
	user = (UserModel)(request.getSession().getAttribute("conf"));
	} else {
		response.sendRedirect("profile.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formularz rejestracji</title>
</head>
<body>
	<% if(user != null) {%>
	<form action="/add" method="get">
		<label>Login:<input type="text" id="name" name="username"/></label><br/>
		<label>Haslo:<input type="password" id="password" name="password"/></label><br/>
		<label>Powtorz haslo:<input type="password" id="confirmPassword" name="confirmPassword"/></label><br/>
		<label>Email:<input type="email" id="email" name="email"/></label><br/>
		<input type="submit" value="zarejestruj">
	</form>
	<%} %>
</body>
</html>