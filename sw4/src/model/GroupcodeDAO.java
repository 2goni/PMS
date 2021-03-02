package model;

import java.sql.SQLException;
import java.util.List;

public interface GroupcodeDAO {
	public List<GroupcodeVO> readList() throws SQLException;
}
	
