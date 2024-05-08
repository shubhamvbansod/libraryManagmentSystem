package libraryManagmentSystem;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user= new User();
		UserCrud crud = new UserCrud();
		
		
		user.setId(Integer.parseInt(req.getParameter("id")));
		user.setName(req.getParameter("name"));
		user.setPhone(Long.parseLong(req.getParameter("phone")));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		try {
			int result= crud.signUp(user);
			if (result!=0) {
				req.setAttribute("message","Signup successfull!!!");
				req.getRequestDispatcher("home.jsp").forward(req, resp);;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
