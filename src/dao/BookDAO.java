package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbConn.ConnectionProvider;
import dto.BookDTO;

public class BookDAO {
	public ArrayList<BookDTO> getBookList(){
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement("select no, name, publisher, author, regDate, rentYn, rentDate, returnDate, returnYn from book");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookNo(rs.getString("no"));
				dto.setBookName(rs.getString("name"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setAuthor(rs.getString("author"));
				dto.setRegDate(rs.getString("regDate"));
				dto.setRentYn(rs.getString("rentYn"));
				dto.setRentDate(rs.getString("rentDate"));
				dto.setReturnDate(rs.getString("returnDate"));
				dto.setReturnYn(rs.getString("returnYn"));
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
