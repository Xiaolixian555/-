package cn.xlx.operator.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.xlx.operator.entity.Operators;
import cn.xlx.operator.entity.UpdateBill;
import cn.xlx.operator.entity.ViewOwner;
import cn.xlx.waterboss.dao.BaseDao;
import cn.xlx.waterboss.entity.Owners;

public class OperatorsDao {
	public static boolean ifadd = true;
	public static boolean ifdelete = true;

	// 判断旧密码是否正确
	public static boolean isOld(Long id, String oldpassword) {
		return find(id).getPassword().equals(oldpassword);
	}

	// 修改密码
	public static void changePassword(Long id, String newpassword) {
		// 先清除连接对象和语句发射器
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection(); // 获取连接对象
			stmt = conn.prepareStatement("update T_OPERATOR set password=?where id=?"); // 获取语句发射器
			stmt.setString(1, newpassword);
			stmt.setLong(2, id);
			stmt.execute(); // 语句发射
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}

	// 判断登录的账号密码是否正确
	public static boolean checkLogin(Long id, String password) {
		Operators operators = new Operators();
		operators = find(id);
		// 如果得到的是空对象
		if (operators == null) {
			return false;
		}
		// 否则，说明是有这个id的人的话
		else {
			// 判断他的密码是否为传入的password，如果是
			if (operators.getPassword().equals(password)) {
				// 那么返回真
				return true;
			} else {
				// 否则返回假
				return false;
			}
		}
	}

	// 根据id查找指定的Operators
	public static Operators find(Long id) {
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据库连接
			conn = BaseDao.getConnection();
			// 获得语句发射器
			stmt = conn.prepareStatement("select * from T_OPERATOR where id=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery(); // 语句发射(执行)
			// 处理结果集
			while (rs.next()) {
				Operators operators = new Operators();
				operators.setId(rs.getLong("ID"));
				operators.setName(rs.getString("NAME"));
				operators.setPassword(rs.getString("PASSWORD"));
				return operators;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, stmt, conn);
		}
		return null;
	}

	// 添加业主的功能(返回添加是否成功)
	public static void addOwner(Long id, String name, String password, Long addressid, String housenumber,
			String watermeter, Date adddate, Long ownertypeid) {
		Owners newowner = new Owners();
		newowner.setId(id);
		newowner.setName(name);
		newowner.setPassword(password);
		newowner.setAddressid(addressid);
		newowner.setHousenumber(housenumber);
		newowner.setWatermeter(watermeter);
		newowner.setAdddate(adddate);
		newowner.setOwnertypeid(ownertypeid);
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		try {
			conn = BaseDao.getConnection(); // 获取连接对象
			stmt = conn.prepareStatement("insert into T_OWNERS values(?,?,?,?,?,?,?,?)"); // 获取语句发射器
			stmt.setLong(1, newowner.getId());
			stmt.setString(2, newowner.getName());
			stmt.setString(3, newowner.getPassword());
			stmt.setLong(4, newowner.getAddressid());
			stmt.setString(5, newowner.getHousenumber());
			stmt.setString(6, newowner.getWatermeter());
			stmt.setDate(7, new java.sql.Date(newowner.getAdddate().getTime()));
			stmt.setLong(8, newowner.getOwnertypeid());
			if (stmt.executeUpdate() == 0) { // 若影响条数为0，则返回FALSE
				ifadd = false;
			} else {
				ifadd = true;
			}
		} catch (SQLException e) {
			ifadd = false;
		} finally {
			BaseDao.closeAll(null, stmt, conn);
		}
	}

	// 删除业主功能(返回删除是否成功)

	public static void deleteOwner(Long id) {
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = BaseDao.getConnection(); // 获取连接对象
			stmt = conn.prepareStatement("delete from T_OWNERS where id=?"); // 获取语句发射器
			stmt.setLong(1, id);
			if (stmt.executeUpdate() == 0) { // 若影响条数为0，则返回FALSE
				ifdelete = false;
			} else {
				ifdelete = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			BaseDao.closeAll(null, stmt, conn);
		}

	}

	// 获取管理者所管理的所有业主
	public static ArrayList<ViewOwner> getViewOwners(Long id) {
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<ViewOwner> list = new ArrayList<ViewOwner>(); // 存放所有业主的集合
		try {
			// 获得数据库连接
			conn = BaseDao.getConnection();
			// 获得语句发射器
			stmt = conn.prepareStatement(
					"select o.id id,o.name name,ot.name ownertype,ar.name area,a.money money,a.isfee isfee,a.feedate feedate from t_account a,t_owners o,t_area ar,t_ownertype ot where a.ownerid(+)=o.id and a.feeuserid=? and a.areaid=ar.id and ot.id=o.ownertypeid");
			stmt.setLong(1, id);
			rs = stmt.executeQuery(); // 语句发射(执行)
			// 处理结果集
			while (rs.next()) {
				ViewOwner viewOwner = new ViewOwner();
				viewOwner.setId(rs.getLong("ID"));
				viewOwner.setName(rs.getString("NAME"));
				viewOwner.setOwnertypename(rs.getString("OWNERTYPE"));
				viewOwner.setArea(rs.getString("AREA"));
				viewOwner.setMoney(rs.getLong("MONEY"));
				viewOwner.setIsfee(rs.getString("ISFEE"));
				viewOwner.setFeedate(rs.getDate("FEEDATE"));
				list.add(viewOwner); // 将获取到的每一行对象，装进这个集合里
			}
			return list; // 返回该集合
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, stmt, conn);
		}
		return null;
	}

	// 获取业主名下的账务
	public static ArrayList<UpdateBill> getUpdateBills(Long id) {
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<UpdateBill> list = new ArrayList<UpdateBill>(); // 存放所有账务的集合

		try {
			// 获得数据库连接
			conn = BaseDao.getConnection();
			// 获得语句发射器
			stmt = conn.prepareStatement(
					"select ac.id id,ac.year year,ac.month month,ac.num0 num0,ac.num1 num1,ac.usenum usenum,ac.money money,ac.isfee isfee,ac.feedate feedate,op.name feeuser from t_account ac,t_operator op where ac.feeuserid=op.id(+) and ac.ownerid=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery(); // 语句发射(执行)
			// 处理结果集
			while (rs.next()) {
				UpdateBill updateBill = new UpdateBill();
				updateBill.setId(rs.getLong("ID"));
				updateBill.setYear(rs.getString("YEAR"));
				updateBill.setMonth(rs.getString("Month"));
				updateBill.setNum0(rs.getLong("NUM0"));
				updateBill.setNum1(rs.getLong("NUM1"));
				updateBill.setUsenum(rs.getLong("USENUM"));
				updateBill.setMoney(rs.getLong("MONEY"));
				updateBill.setIsfee(rs.getString("ISFEE"));
				updateBill.setFeedate(rs.getDate("FEEDATE"));
				updateBill.setFeeuser(rs.getString("FEEUSER"));
				list.add(updateBill); // 将获取到的每一行对象，装进这个集合里
			}
			return list; // 返回该集合
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, stmt, conn);
		}
		return null;
	}

	// 设置业主名下的账务
	public static void setUpdateBills(ArrayList<UpdateBill> list, Long id) {
		// 先清除连接对象和语句发射器和结果集
		java.sql.Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		try {
			// 获得数据库连接
			conn = BaseDao.getConnection();
			// 获得语句发射器
			stmt = conn.prepareStatement(
					"update t_account set year=?,month=?,num0=?,num1=?,usenum=?,money=?,isfee=?,feedate=? where ownerid=?");
			for (int i = 0; i < list.size(); i++) {
				stmt.setString(1, list.get(i).getYear());
				stmt.setString(2, list.get(i).getMonth());
				stmt.setLong(3, list.get(i).getNum0());
				stmt.setLong(4, list.get(i).getNum1());
				stmt.setLong(5, list.get(i).getUsenum());
				stmt.setLong(6, list.get(i).getMoney());
				if (list.get(i).getIsfee().equals("未缴费")) {
					stmt.setString(7, "n");
				} else {
					stmt.setString(7, "y");
				}
				if(list.get(i).getFeedate().equals("暂无记录")){
					stmt.setDate(8,null);
				}
				else{
					stmt.setDate(8,list.get(i).getFeedate());
				}		
				stmt.setLong(9, id);
				stmt.executeUpdate(); // 语句发射(执行)
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, stmt, conn);
		}

	}
}
