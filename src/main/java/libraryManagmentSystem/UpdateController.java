package libraryManagmentSystem;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController  extends HttpServlet{
	
	Books books = new Books();
	
	UserCrud crud= new UserCrud();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
			try {
				Books books = crud.findBook(id);
				if (books!=null) {
					
					req.setAttribute("list", books);
					
					req.getRequestDispatcher("update.jsp").forward(req, resp);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		books.setId(Integer.parseInt(req.getParameter("id")));
		books.setName(req.getParameter("name"));
		books.setAuthor(req.getParameter("author"));
		books.setGenre(req.getParameter("genre"));
		books.setPrice(Double.parseDouble(req.getParameter("price")));
		
		try {
			int result = crud.updateBooks(books);
			
			if (result != 0) {
				
				req.setAttribute("list", crud.getAllBooks());
				
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
