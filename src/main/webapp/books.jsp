<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddBooks</title>
<link rel="stylesheet" href="books.css">
</head>
<body>
<div class="container">
<form action="addBook" method="post">
        <label for="id">ID</label>
        <input type="number" name="id" autofocus><br>
        <label for="name">Name</label>
        <input type="text" name="name" required><br>
        <label for="Author">Author</label>
        <input type="text" name="author" ><br>
        <label for="genre">Genre</label>
        <input type="text" name="genre" ><br>
        <label for="genre">price</label>
        <input type="number" name="price" ><br>
        
        <a href="main.jsp"><button>Add Book</button></a>
        <button type="reset">Cancel</button>
</form>
</div>

</body>
</html>