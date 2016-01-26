<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String username = request.getParameter("username");
if (username.equals("Confirmation error")) {
    request.getRequestDispatcher("login.jsp?username=Force%20an%20error&submit=Submit").forward(request, response);
}
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Success!</title>
  </head>
  <body>
    Thanks for registering!
  </body>
</html>

