package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConn.ConnectionProvider;

public class AddBookDAO {
	public boolean addBook(String bookName, String publisher, String author) {

		Connection conn = null;
		PreparedStatement pstmt;
		String sql = "INSERT into book(NAME, publisher, author)\r\n" + "VALUES(?, ?, ?)";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			pstmt.setString(2, publisher);
			pstmt.setString(3, author);
			int r = pstmt.executeUpdate();
			System.out.println("변경된 row : "+r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
