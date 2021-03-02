package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupcodeDAOImpl extends DAOBase implements GroupcodeDAO {

	@Override
	public List<GroupcodeVO> readList() throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from groupcode");
		ResultSet rs = pstmt.executeQuery();
		List<GroupcodeVO> list = new ArrayList<>();
		while(rs.next()) {
			GroupcodeVO vo = new GroupcodeVO();
			vo.setGcode(rs.getString(1));
			vo.setGname(rs.getString(2));
			list.add(vo);
		}
		return list;
	}

}
