package model;

public class Positions {
	private String positionid;
	private String positionname;
	private String departmentid;
	public String getPositionid() {
		return positionid;
	}
	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public Positions() {
		super();
	}
	public Positions(String positionid, String positionname, String departmentid) {
		super();
		this.positionid = positionid;
		this.positionname = positionname;
		this.departmentid = departmentid;
	}
	
	
}
