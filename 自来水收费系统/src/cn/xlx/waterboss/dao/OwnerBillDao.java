package cn.xlx.waterboss.dao;

import java.sql.ResultSet;

import cn.xlx.waterboss.entity.OwnerBill;

public class OwnerBillDao {
	// 根据id查找指定的Owner
	public static OwnerBill find(Long id) {
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接
			conn = BaseDao.getConnection();
			// 获得语句发射器
			stmt = conn.prepareStatement("select * from T_ACCOUNT where ownerid=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery(); // 语句发射(执行)
			// 处理结果集
			while (rs.next()) {
				OwnerBill ownerbill = new OwnerBill();
				ownerbill.setId(rs.getLong("OWNERID"));
				ownerbill.setYear(rs.getString("YEAR"));
				ownerbill.setMonth(rs.getString("MONTH"));
				ownerbill.setUsenum(rs.getLong("USENUM"));
				ownerbill.setMoney(rs.getLong("MONEY"));
				ownerbill.setIsfee(rs.getString("ISFEE"));
				ownerbill.setFeedate(rs.getDate("FEEDATE"));
				return ownerbill;
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
