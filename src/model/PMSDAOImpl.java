package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PMSDAOImpl implements PMSDAO{
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	
	public PMSDAOImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/bigdata", "big", "1234");
		} catch (Exception e) {
			System.out.println("드라이버 오류");
			e.getStackTrace();
		}
	}
	@Override
	public void create(PMSDTO vo) throws SQLException{
		pstmt = conn.prepareStatement("INSERT INTO product(code,pname,cost,pnum,inum,sale,gcode) VALUES(?,?,?,?,?,?,?)");
		pstmt.setString(1, vo.getCode());
		pstmt.setString(2, vo.getPname());
		pstmt.setInt(3, vo.getCost());
		pstmt.setInt(4, vo.getPnum());
		pstmt.setInt(5, vo.getInum());
		pstmt.setInt(6, vo.getSale());
		pstmt.setString(7, vo.getGcode());
		// 4. 쿼리 실행
		pstmt.executeUpdate();
	}
}
