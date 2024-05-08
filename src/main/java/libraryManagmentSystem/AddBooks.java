package libraryManagmentSystem;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addBook")
public class AddBooks extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserCrud crud= new UserCrud();
		Books books= new Books();
		books.setId(Integer.parseInt(req.getParameter("id")));
		books.setName(req.getParameter("name"));
		books.setAuthor(req.getParameter("author"));
		books.setGenre(req.getParameter("genre"));
		books.setPrice(Long.parseLong(req.getParameter("price")));
		try {
			int result=crud.addBook(books);
			if(result!=0) {
				req.setAttribute("list", crud.getAllBooks());
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
