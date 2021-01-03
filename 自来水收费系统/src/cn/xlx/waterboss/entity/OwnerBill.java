package cn.xlx.waterboss.entity;

import java.sql.Date;

public class OwnerBill {
	private Long id;  // 编号
	private String year; //账务年份
	private String month;   //账务月份
	private Long usenum;   //本月用水量
	private Long money;   //应缴金额
	private String isfee;  //是否已缴
	private Date feedate;  //缴费日期 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Long getUsenum() {
		return usenum;
	}
	public void setUsenum(Long usenum) {
		this.usenum = usenum;
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
