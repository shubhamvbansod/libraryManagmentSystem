package libraryManagmentSystem;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserCrud crud= new UserCrud();
		Books books = new Books();

		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			String dbPassword=crud.login(email);
			
			if (dbPassword!=null) {
				if(dbPassword.equals(password)){
					
					req.setAttribute("list", crud.getAllBooks());
					req.getRequestDispatcher("main.jsp").forward(req, resp);
				}
				else {
					req.setAttribute("message", "invalid password!");
					req.getRequestDispatcher("home.jsp");}
				
			}
				
			else {
				req.setAttribute("message", "user not found!! please signUp first!!!");
				req.getRequestDispatcher("signup.jsp").forward(req, resp);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	 

}
