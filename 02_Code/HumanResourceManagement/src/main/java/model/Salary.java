package model;

import java.math.BigDecimal;

public class Salary {
	private String employeeid;
//	private String positionid;
	private String employeename;
	private String positionname;
	private BigDecimal actualsalary;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
//	public String getPositionid() {
//		return positionid;
//	}
//	public void setPositionid(String positionid) {
//		this.positionid = positionid;
//	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public BigDecimal getActualsalary() {
		return actualsalary;
	}
	public void setActualsalary(BigDecimal actualsalary) {
		this.actualsalary = actualsalary;
	}
	public Salary() {
		super();
	}
	public Salary(String employeeid, String employeename, String positionname, BigDecimal actualsalary) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.positionname = positionname;
		this.actualsalary = actualsalary;
	}
	
	
		
}
