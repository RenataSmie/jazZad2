<%@page import="domain.UserModel"%>
<%@ page language ="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserModel user = null;
	if (request.getSession().getAttribute("conf") != null){
		user = (UserModel)(request.getSession().getAttribute("conf"));
	} else {
		response.sendRedirect("/login");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona profilowa</title>
</head>
<body>
	<h1>Witaj, <%= user.getUsername() %></h1>
	<% if(user.getAccessLevel() > UserModel.ADMIN) {%>
	<form action="add" method="get">
	Chcesz dodać użytkownika premium? Podaj jego login
		<label>Login:<input type="text" id="name" name="name"/></label><br/>
	</form>
	<% } %>
</body>
</html>