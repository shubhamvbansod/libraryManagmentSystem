<%@page import="libraryManagmentSystem.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
<link rel="stylesheet" href="update.css">
</head>
<body>
<%Books books=(Books)request.getAttribute("list");

%>


<div class="container"><h3>UPDATE</h3>
<form action="update" method="post">
        <label for="id">ID</label>
        <input type="number" name="id" type="hidden" value=<%=books.getId()%>><br>
        <label for="name">Name</label>
        <input type="text" name="name" value="<%=books.getName()%>"> <br>
        <label for="Author">Author</label>
        <input type="text" name="author" value="<%=books.getAuthor()%>" ><br>
        <label for="genre">Genre</label>
        <input type="text" name="genre" value="<%=books.getGenre()%>"><br>
        <label for="genre">price</label>
        <input type="number" name="price" value="<%=books.getPrice()%>"><br>
        
        <button>Update</button>
        <button type="reset">Cancel</button>
</form>
</div>

</body>
</html>