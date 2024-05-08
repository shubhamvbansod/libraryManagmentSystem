<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet" href="home.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

	<div class="container">
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<h4 style="color: red;"><%=message%></h4>
		<%
		}
		%><br>
		<br>
		<div class="logo">
			<h2>Qspider Library</h2>
		</div>

		<form action="login" method="post">
			<label for="email"><i class="fa-solid fa-user"></i></label> <input
				type="email" name="email" placeholder="Enter email" autofocus
				required><br>
			<br> <label for="password"><i class="fa-solid fa-lock"></i></label>
			<input type="password" name="password" id="pwd"
				placeholder="Enter password" required><span class="eye"><i
				class="fa-solid fa-eye"></i></span> <span id="forgot"><a
				href="forgot.html">forgot password?</a></span> <br>
			<br> <a href="main.jsp"><button>Login</button></a>
			<button type="reset">Cancel</button>

			<h4>
				Don't have an account ?<a href="signup.jsp">SignUp</a>
			</h4>





		</form>


	</div>


</body>
</html>