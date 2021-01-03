package cn.xlx.waterboss.dao;

import java.sql.SQLException;

public class BaseDao {
	static {
		// 加载驱动类
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获取数据库连接对象Connection
	 */
	public static java.sql.Connection getConnection() throws SQLException {
		return java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Xlx608378");
	}

	// 关闭资源(结果集，语句发射器，连接对象)
	public static void closeAll(java.sql.ResultSet rs, java.sql.Statement stmt, java.sql.Connection conn) {
		// 关闭结果集
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭语句发射器
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//关闭连接对象
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
