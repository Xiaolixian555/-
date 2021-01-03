package cn.xlx.operator.entity;

import java.sql.Date;

public class UpdateBill {
	private Long id;
	private String year;
	private String month;
	private Long num0;
	private Long num1;
	private Long usenum;
	private Long money;
	private String isfee;
	private Date feedate;
	private String feeuser;
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
	public Long getNum0() {
		return num0;
	}
	public void setNum0(Long num0) {
		this.num0 = num0;
	}
	public Long getNum1() {
		return num1;
	}
	public void setNum1(Long num1) {
		this.num1 = num1;
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
	public String getFeeuser() {
		return feeuser;
	}
	public void setFeeuser(String feeuser) {
		this.feeuser = feeuser;
	}
	
}
