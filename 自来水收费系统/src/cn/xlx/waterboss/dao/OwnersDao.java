package cn.xlx.waterboss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import cn.xlx.waterboss.entity.Owners;

//业主的Dao方法
public class OwnersDao {
	// 新增业主add()方法
	public static void add(Owners owners) {
		// 先清除连接对象和语句发射器
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection(); // 获取连接对象
			stmt = conn.prepareStatement("insert into T_OWNERS values(?,?,?,?,?,?,?,?)"); // 获取语句发射器
			stmt.setLong(1, owners.getId());
			stmt.setString(2, owners.getName());
			stmt.setString(3, owners.getPassword());
			stmt.setLong(4, owners.getAddressid());
			stmt.setString(5, owners.getHousenumber());
			stmt.setString(6, owners.getWatermeter());
			stmt.setDate(7, new java.sql.Date(owners.getAdddate().getTime()));
			stmt.setLong(8, owners.getOwnertypeid());
			stmt.execute(); // 语句发射
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}

	// 修改业主update()方法
	public static void update(Owners owners) {
		// 先清除连接对象和语句发射器
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection(); // 获取连接对象
			stmt = conn.prepareStatement("update T_OWNERS set name=?,password=?,addressid=?,housenumber=?,"
					+ "watermeter=?,adddate=?,ownertypeid=?where id=?"); // 获取语句发射器
			stmt.setString(1, owners.getName());
			stmt.setString(2, owners.getPassword());
			stmt.setLong(3, owners.getAddressid());
			stmt.setString(4, owners.getHousenumber());
			stmt.setString(5, owners.getWatermeter());
			stmt.setDate(6, new java.sql.Date(owners.getAdddate().getTime()));
			stmt.setLong(7, owners.getOwnertypeid());
			stmt.setLong(8, owners.getId());
			stmt.execute(); // 语句发射
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}

	// 删除业主delete()方法
	public static void delete(Long id) {
		// 先清除连接对象和语句发射器
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection();
			stmt = conn.prepareStatement("delete from T_OWNERS where id=?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}

	// 判断登录的账号密码是否正确
	public static boolean checkLogin(Long id, String password) {
		Owners owner = new Owners();
		owner = find(id);
		// 如果得到的是空对象
		if (owner == null) {
			return false;
		} 
		// 否则，说明是有这个id的人的话
		else {
			//判断他的密码是否为传入的password，如果是
			if (owner.getPassword().equals(password)) {
				// 那么返回真
				return true;
			} else {
				// 否则返回假
				return false;
			}
		}
	}

	// 根据id查找指定的Owner
	public static Owners find(Long id) {
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接
			conn = BaseDao.getConnection();
			// 获得语句发射器
			stmt = conn.prepareStatement("select * from T_OWNERS where id=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery(); // 语句发射(执行)
			// 处理结果集
			while (rs.next()) {
				Owners owners = new Owners();
				owners.setId(rs.getLong("ID"));
				owners.setName(rs.getString("NAME"));
				owners.setPassword(rs.getString("PASSWORD"));
				owners.setAddressid(rs.getLong("ADDRESSID"));
				owners.setHousenumber(rs.getString("HOUSENUMBER"));
				owners.setWatermeter(rs.getString("WATERMETER"));
				owners.setAdddate(rs.getDate("ADDDATE"));
				owners.setOwnertypeid(rs.getLong("OWNERTYPEID"));
				return owners;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, stmt, conn);
		}
		return null;
	}
}
