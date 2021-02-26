package model;

import java.sql.SQLException;
import java.util.List;

public interface PMSDAO {
	void create(PMSDTO vo) throws SQLException;
	//PMSDTO readOne(PMSDTO vo) throws SQLException;
	//List<PMSDTO> readList() throws SQLException;
	//int update(PMSDTO vo) throws SQLException;
	//int delete(PMSDTO vo) throws SQLException;
}
