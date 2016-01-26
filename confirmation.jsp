<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Confirm Registration Information</title>
  </head>
  <body>
    <%
    String username = request.getParameter("username");
    String password = request.getParameter("password"); 
    %>
    Name: <%= username %>
    Password: <%= password %>
    <form action="success.jsp">
      <input type="hidden" name="username" value="<%=username %>">
      <input type="hidden" name="password" value="<%=password %>">
      <input type="submit" value="Submit">
    </form>
     
    <form action="login.jsp?">
      <input type="hidden" name="username" value="<%=username %>">
      <input type="hidden" name="password" value="<%=password %>">
      <input type="submit" name="edit" value="Edit">
    </form>
  </body>
</html>

