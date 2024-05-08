<%@page import="java.util.ArrayList"%>
<%@page import="libraryManagmentSystem.Books"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<link rel="stylesheet" href="Main.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

<%List<Books>list = (List)request.getAttribute("list");%>

	 <div class="page">
        <div class="container">
           <div class="btn"><a href="books.jsp" id="add-book"><button>Add Book</button></a>
           <a href="home.jsp" id="log-out"><button>LogOut</button></a></div>
			<%if(list!=null){ %>
			<div class="show-data">
			<table>
			<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Author</th>
			<th>Genre</th>
			<th>price</th>
			<th  colspan="2">actions</th>
			
			</tr>
			
							<%for(Books books :list )
			
			
	{
		%>
		<tr>
		<td><%=books.getId()%></td>
		<td><%=books.getName()%></td>
		<td><%=books.getAuthor()%></td>
		<td><%=books.getGenre()%></td>
		<td><%=books.getPrice()%></td>
		<td><a href="delete?id=<%=books.getId()%>"><button>delete</button></a></td>
		<td><a href="update?id=<%=books.getId()%>"><button>Edit</button></a></td>
		</tr>
		
			<%} %>
			</table>
			</div><%} %>
		
        </div>

    </div>
</body>
</html>