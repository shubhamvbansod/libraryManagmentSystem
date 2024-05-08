package libraryManagmentSystem;

import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.ResolveResult;



public class UserCrud {

	public Connection getConnection () throws ClassNotFoundException, SQLException {
		String className="com.mysql.cj.jdbc.Driver";
		Class.forName(className);
		String url="jdbc:mysql://localHost:3306/librarydb?user=root&password=root";
		Connection connection=DriverManager.getConnection(url);
		return connection;
	}
	
	public int signUp(User user) throws ClassNotFoundException, SQLException {
		Connection connection=getConnection();
		String sql="INSERT INTO USER(ID,NAME,PHONE,ADDRESS,EMAIL,PASSWORD)VALUES(?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setString(5, user.getEmail());
		preparedStatement.setString(6, user.getPassword());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	
	public String login(String email) throws ClassNotFoundException, SQLException {
		Connection connection =getConnection();
		String sql="SELECT PASSWORD FROM  USER WHERE EMAIL=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet set =preparedStatement.executeQuery();
		String password= null;
		
		while(set.next()) {
			password=set.getString("password");
		}
		connection.close();
		return password;
	}
	public int addBook(Books books) throws ClassNotFoundException, SQLException {
		Connection connection= getConnection();
		String sql= "INSERT INTO BOOKS(ID,NAME,AUTHOR,GENRE,PRICE)VALUES(?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, books.getId());
		preparedStatement.setString(2, books.getName());
		preparedStatement.setString(3, books.getAuthor());
		preparedStatement.setString(4, books.getGenre());
		preparedStatement.setDouble(5, books.getPrice());
		int result =preparedStatement.executeUpdate();
		connection.close();
		return result;
		
		
	}
	
	public List<Books> getAllBooks() throws ClassNotFoundException, SQLException {
		Connection connection=getConnection();
		String sql = "SELECT * FROM BOOKS ";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		
		
		List<Books>list= new ArrayList<Books>();
		while(resultSet.next()) {
			Books books=new Books();
			books.setId(resultSet.getInt("id"));
			books.setName(resultSet.getString("name"));
			books.setAuthor(resultSet.getString("author"));
			books.setGenre(resultSet.getString("genre"));
			books.setPrice(resultSet.getDouble("price"));
			
			list.add(books);
			
			
		}
		connection.close();
			
		return list;
		
	}
	
	
	
	public int delBooks(int id) throws ClassNotFoundException, SQLException {
		Connection connection= getConnection();
		String sql="DELETE FROM BOOKS WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int result= preparedStatement.executeUpdate();
		
		connection.close();
		return result;
		
	}
	public Books findBook(int id) throws ClassNotFoundException, SQLException {
		Connection connection= getConnection();
		String sql="SELECT * FROM BOOKS WHERE ID=?";
		
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet set= preparedStatement.executeQuery();
		
		Books books= new Books();
		while(set.next()) {
			books.setId(set.getInt("id"));
			books.setName(set.getString("name"));
			books.setAuthor(set.getString("author"));
			books.setGenre(set.getString("genre"));
			books.setPrice(set.getDouble("price"));
			
		}
		connection.close();
		return books;
		
	}
	public int updateBooks(Books books) throws ClassNotFoundException, SQLException {
		Connection connection= getConnection();
		String sql="UPDATE BOOKS SET NAME=?, AUTHOR=?,GENRE=?,PRICE=? WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setString(1, books.getName());
		preparedStatement.setString(2, books.getAuthor());
		preparedStatement.setString(3, books.getGenre());
		preparedStatement.setDouble(4, books.getPrice());
		preparedStatement.setInt(5, books.getId());
		int result = preparedStatement.executeUpdate();
		
		connection.close();
		return result;
		
	}

}
