package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl extends DAOBase implements ProductDAO {

	@Override
	public int create(ProductVO vo) throws SQLException {
		//1. db 연결
		Connection conn = getConnection();
		//2. db 쓰기
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO product(code,pname,cost,pnum,inum,sale,gcode) VALUES(?,?,?,?,?,?,?)");
		pstmt.setString(1, vo.getCode());
		pstmt.setString(2, vo.getPname());
		pstmt.setInt(3, vo.getCost());
		pstmt.setInt(4, vo.getPnum());
		pstmt.setInt(5, vo.getInum());
		pstmt.setInt(6, vo.getSale());
		pstmt.setString(7, vo.getGcode());
		int result = pstmt.executeUpdate();
		//3. db 닫기
		closeDBResources(null, pstmt, conn);
		//4. 결과값 리턴
		return result;
	}

	@Override
	public ProductVO readOne(ProductVO vo) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select pname, cost, pnum, inum, sale, gcode from product where code = " + vo.getCode());
		ResultSet rs = pstmt.executeQuery();
		vo.setPname(rs.getString(1));
		vo.setCost(rs.getInt(2));
		vo.setPnum(rs.getInt(3));
		vo.setInum(rs.getInt(4));
		vo.setSale(rs.getInt(5));
		vo.setGcode(rs.getString(6));
		return vo;
	}

	@Override
	public List<ProductVO> readList() throws SQLException {
		
		return null;
	}

	@Override
	public int update(ProductVO vo) throws SQLException {
		
		return 0;
	}

	@Override
	public int delete(ProductVO vo) throws SQLException {

		return 0;
	}

}
