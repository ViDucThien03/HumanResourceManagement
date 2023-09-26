package model;

public class Department {
	protected String departmentid;
	protected String departmentname;
	private String departmentaddress;
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDepartmentaddress() {
		return departmentaddress;
	}
	public void setDepartmentaddress(String departmentaddress) {
		this.departmentaddress = departmentaddress;
	}
	public Department() {
		super();
	}
	public Department(String departmentid, String departmentname, String departmentaddress) {
		super();
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.departmentaddress = departmentaddress;
	}
	
	
	
}
