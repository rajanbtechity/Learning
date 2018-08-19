<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("vzid_session") == null) {
			response.sendRedirect("ErrorPage.jsp");
		}
	%>
	<div align="right">
	<form action="LogoutUser">
		<input type="submit" value="Logout">
	</form>
	</div>
	<div align="center">
		<h4>Welcome ${vzid_session}</h4>
		<h3>RTCI Main.jsp page with all the link</h3>
		<a href="Transformation.jsp">Transformation Page</a>
	</div>
</body>
</html>