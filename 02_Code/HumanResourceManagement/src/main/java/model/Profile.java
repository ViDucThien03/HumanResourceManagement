package model;

import java.util.Date;

public class Profile {
	private String employeeid;
	private String image;
	private String employeename;
	private Date employeebirth;
	private String employeeaddress;
	private String employeehometown;
	private String employeephone;
	private Date employeeworkday;
	private String employeeexp;
	private String positionid;
	private String departmentid;
	private String positionname;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public Date getEmployeebirth() {
		return employeebirth;
	}
	public void setEmployeebirth(Date employeebirth) {
		this.employeebirth = employeebirth;
	}
	public String getEmployeeaddress() {
		return employeeaddress;
	}
	public void setEmployeeaddress(String employeeaddress) {
		this.employeeaddress = employeeaddress;
	}
	public String getEmployeehometown() {
		return employeehometown;
	}
	public void setEmployeehometown(String employeehometown) {
		this.employeehometown = employeehometown;
	}
	public String getEmployeephone() {
		return employeephone;
	}
	public void setEmployeephone(String employeephone) {
		this.employeephone = employeephone;
	}
	public Date getEmployeeworkday() {
		return employeeworkday;
	}
	public void setEmployeeworkday(Date employeeworkday) {
		this.employeeworkday = employeeworkday;
	}
	public String getEmployeeexp() {
		return employeeexp;
	}
	public void setEmployeeexp(String employeeexp) {
		this.employeeexp = employeeexp;
	}
	
	
	public String getPositionid() {
		return positionid;
	}
	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public Profile() {
		super();
	}
	public Profile(String employeeid, String image, String employeename, Date employeebirth, String employeeaddress,
			String employeehometown, String employeephone, Date employeeworkday, String employeeexp, String positionid,
			String departmentid, String positionname) {
		super();
		this.employeeid = employeeid;
		this.image = image;
		this.employeename = employeename;
		this.employeebirth = employeebirth;
		this.employeeaddress = employeeaddress;
		this.employeehometown = employeehometown;
		this.employeephone = employeephone;
		this.employeeworkday = employeeworkday;
		this.employeeexp = employeeexp;
		this.positionid = positionid;
		this.departmentid = departmentid;
		this.positionname = positionname;
	}
	
}
