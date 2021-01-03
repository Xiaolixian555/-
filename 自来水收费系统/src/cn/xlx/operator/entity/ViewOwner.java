package cn.xlx.operator.entity;

import java.sql.Date;

public class ViewOwner {
	//查看业主的每一个实体类
	private Long id;  // 业主编号
	private String name;   // 业主姓名
	private String ownertypename; //业主类型名
	private String area; //业主所属区域
	private Long money;  //应缴金额
	private String isfee; //是否已缴费
	private Date feedate; //缴费日期
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnertypename() {
		return ownertypename;
	}
	public void setOwnertypename(String ownertypename) {
		this.ownertypename = ownertypename;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	public String getIsfee() {
		return isfee;
	}
	public void setIsfee(String isfee) {
		this.isfee = isfee;
	}
	public Date getFeedate() {
		return feedate;
	}
	public void setFeedate(Date feedate) {
		this.feedate = feedate;
	}
	
	
}
