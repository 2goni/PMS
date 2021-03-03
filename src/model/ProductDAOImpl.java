package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		PreparedStatement pstmt = conn.prepareStatement("select code, pname, cost, pnum, inum, sale, gcode from product where code = " + "'"+ vo.getCode() + "'");
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		vo.setCode(rs.getString(1));
		vo.setPname(rs.getString(2));
		vo.setCost(rs.getInt(3));
		vo.setPnum(rs.getInt(4));
		vo.setInum(rs.getInt(5));
		vo.setSale(rs.getInt(6));
		vo.setGcode(rs.getString(7));
		return vo;
	}

	@Override
	public List<ProductVO> readList() throws SQLException {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select pname, ROUND((inum*0.2)-pnum) 'fnum' from product WHERE pnum < inum*0.2");
			ResultSet rs = pstmt.executeQuery();
			List<ProductVO> list = new ArrayList<>();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setPname(rs.getString(1));
				vo.setPnum(rs.getInt(2));
				list.add(vo);
			}
			return list;
	}

	@Override
	public int update(ProductVO vo) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update product set code = ?, pname = ?, cost = ?, pnum = ?, inum = ?, sale = ?, gcode = ?  where code = '"+ vo.getCode() + "'");
		pstmt.setString(1, vo.getCode());
		pstmt.setString(2, vo.getPname());
		pstmt.setInt(3, vo.getCost());
		pstmt.setInt(4, vo.getPnum());
		pstmt.setInt(5, vo.getInum());
		pstmt.setInt(6, vo.getSale());
		pstmt.setString(7, vo.getGcode());
		int result = pstmt.executeUpdate();
		
		return result;
	}

	@Override
	public int delete(ProductVO vo) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from product where code = ? and pname = ? and cost = ? and pnum = ? and inum = ? and sale = ? and gcode = ?");
		pstmt.setString(1, vo.getCode());
		pstmt.setString(2, vo.getPname());
		pstmt.setInt(3, vo.getCost());
		pstmt.setInt(4, vo.getPnum());
		pstmt.setInt(5, vo.getInum());
		pstmt.setInt(6, vo.getSale());
		pstmt.setString(7, vo.getGcode());
		int result = pstmt.executeUpdate();
		
		return result;
	}

}
