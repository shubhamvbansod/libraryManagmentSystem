<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<link rel="stylesheet" href="signup.css">
</head>
<body>
<div class="container">

<%String msg=(String)request.getAttribute("message");
if(msg!=null) {%>
	<h5 style="color:red;">
<%=msg %></h5>
<% } %>
    <h2 align="center">SignUp</h2>
    <form action="signup" method="post">
        <label for="id">ID</label>
        <input type="number" name="id" required autofocus="autofocus"><br>
        <label for="name">Name</label>
        <input type="text" name="name" required><br>
        <label for="phone">Phone</label>
        <input type="tel" name="phone" required pattern="[6789][0-9]{9}"><br>
        <label for="address">Address</label>
        <input type="text" name="address"required><br>
        <label for="email">Email</label>
        <input type="email" name="email" required><br>
        <label for="id">Password</label>
        <input type="password" name="password" required><br>
       <div class="button"> <button>SignUp</button>
       <button type="reset">Cancel</button></div>
        
    </form><br>
    <h5>Already Have an account?<a href="home.jsp">Login</a></h5>

  </div>

</body>
</html>