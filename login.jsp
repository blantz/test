<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%!
 private Pattern _pattern = Pattern.compile("[0-9]");
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome! Register here!</title>
  </head>
  <body>
  <%
  String msg = null;
  String submit = request.getParameter("submit");
  String username = request.getParameter("username");
  String password = request.getParameter("password"); 
  if (submit != null && submit.equals("Submit")) {
    if (username == null
            || username.trim().length() == 0
            || password == null
            || password.trim().length() == 0) {
        msg = "All fields are required! Try again! Don't make me go back there!";
    } else if (username.equals("Force an error")) {
        msg = "I'm sorry, but we seem to have encountered an error. Please try again later or contact Hidden Clause customer support.";
    } else {
      Matcher matcher = _pattern.matcher(username);
      if (matcher.find()) {
          msg = "Yo! The username can only contain letters!";
      } else if (username.trim().length() > 30) {
          msg = "Yo! The username can only be 30 letters or less!";
      } else {
          matcher = _pattern.matcher(password);
          if (matcher.find()) {
              msg = "Yo! The password can only contain letters!";
          } else if (password.trim().length() > 30) {
              msg = "Yo! The password can only be 30 letters or less!";
          }
      }
    }
   
    if (msg == null) {
        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    } else {
    %>
      <span style="color: red;"><%=msg %></span>
    <%
    }
  }
  %>
    <form action="login.jsp">
        <input name="username" value='<%=username != null ? username : "" %>'>
        <input name="password" type="hidden" value='<%= password != null ? password : "" %>'>
        <input type="submit" value="Submit" name="submit">
    </form>
  </body>
</html>
