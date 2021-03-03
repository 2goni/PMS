package model;

import java.sql.SQLException;
import java.util.List;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		GroupcodeDAOImpl pro = new GroupcodeDAOImpl();
		List<GroupcodeVO> list = pro.readList();
//		vo.setCode("A02");
//		vo.setPname("컴퓨터CDROM");
//		vo.setCost(1200);
//		vo.setPnum(500);
//		vo.setInum(100);
//		vo.setSale(1500);
//		vo.setGcode("A");
		for (GroupcodeVO vo : list) {
			System.out.println(vo.toString());
		}

	}
}
