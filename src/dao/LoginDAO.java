package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConn.ConnectionProvider;
import dto.LoginDTO;

public class LoginDAO {
	public LoginDTO login(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs;
		LoginDTO dto = new LoginDTO();
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement("select id, uname from member where id=? and pw=sha1(?)");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setResult(true);
				dto.setId(rs.getString(1));   // 쿼리의 1번째 필드값 => id
				dto.setName(rs.getString(2)); // 쿼리의 2번째 필드값 => uname
			}else {
				System.out.println("해당 계정없음!! ("+id+")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}

