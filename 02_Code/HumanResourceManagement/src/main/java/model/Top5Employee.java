package model;

public class Top5Employee {
	private String employeeid;
	private String employeename;
	private String image;
	private double completionPercentage;
	private int completedWorks;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getCompletionPercentage() {
		return completionPercentage;
	}
	public void setCompletionPercentage(double completionPercentage) {
		this.completionPercentage = completionPercentage;
	}
	public int getCompletedWorks() {
		return completedWorks;
	}
	public void setCompletedWorks(int completedWorks) {
		this.completedWorks = completedWorks;
	}
	public Top5Employee() {
		super();
	}
	public Top5Employee(String employeeid, String employeename, String image, double completionPercentage, int completedWorks) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.image = image;
		this.completionPercentage = completionPercentage;
		this.completedWorks = completedWorks;
	}
}
