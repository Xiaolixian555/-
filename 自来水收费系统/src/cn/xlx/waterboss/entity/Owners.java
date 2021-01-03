package cn.xlx.waterboss.entity;

import java.sql.Date;
	//业主实体类
public class Owners {
	private Long id;  // 编号
	private String name;   // 业主名称
	private String password; //业主密码
	private Long addressid;   //地址编号
	private String housenumber;   //门牌号
	private String watermeter;   //水表编号
	private Date adddate;  //登记日期
	private Long ownertypeid;  //业主类型ID
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
	public Long getAddressid() {
		return addressid;
	}
	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getWatermeter() {
		return watermeter;
	}
	public void setWatermeter(String watermeter) {
		this.watermeter = watermeter;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public Long getOwnertypeid() {
		return ownertypeid;
	}
	public void setOwnertypeid(Long ownertypeid) {
		this.ownertypeid = ownertypeid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
