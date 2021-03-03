package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOBase implements DAO{
	public Connection getConnection() throws SQLException{		
        String jdbc_driver = "org.mariadb.jdbc.Driver";
        String db_url = "jdbc:mariadb://localhost:3307/sampledb";
        try{
			Class.forName(jdbc_driver);
			Connection conn = DriverManager.getConnection(db_url,"system","hrdkorea");  
			return conn;
               } catch(Exception e) {
                    e.printStackTrace();
               }
                return null;		
	}
	public void closeDBResources(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}


