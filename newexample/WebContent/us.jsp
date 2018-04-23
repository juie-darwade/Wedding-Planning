<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unsuccessfull login</title>
</head>
<body>
          <h2><%=request.getAttribute("errorMessage") %></h2>

	<a href="login.jsp">Try Again</a>
</body>
</html>