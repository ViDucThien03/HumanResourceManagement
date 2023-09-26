package model;
public class EmployeeSummary {
	private String employeeid;
	private String employeename;
	private String employeephone;
	private String positionname;
	private String departmentname;
	private String departmentid;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeephone() {
		return employeephone;
	}
	public void setEmployeephone(String employeephone) {
		this.employeephone = employeephone;
	}
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public EmployeeSummary() {
		super();
	}
	public EmployeeSummary(String employeeid, String employeename, String employeephone, String positionname,
			String departmentname, String departmentid) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeephone = employeephone;
		this.positionname = positionname;
		this.departmentname = departmentname;
		this.departmentid = departmentid;
	}
	
	
}
