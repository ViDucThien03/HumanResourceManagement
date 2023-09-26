package model;

import java.util.Date;

public class AssignedWork {
	private String jobid;
	private Date deliverydate;
	private String descriptions;
	private Date deadline;
	private String workrogress;
	//private String employeename;
	private String employeeid;
	
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public Date getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getWorkrogress() {
		return workrogress;
	}
	public void setWorkrogress(String workrogress) {
		this.workrogress = workrogress;
	}
//	public String getEmployeename() {
//		return employeename;
//	}
//	public void setEmployeename(String employeename) {
//		this.employeename = employeename;
//	}
	
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	
	
	public AssignedWork() {
		super();
	}
	public AssignedWork(String jobid, Date deliverydate, String descriptions, Date deadline, String workrogress,
			 String employeeid) {
		super();
		this.jobid = jobid;
		this.deliverydate = deliverydate;
		this.descriptions = descriptions;
		this.deadline = deadline;
		this.workrogress = workrogress;
		//this.employeename = employeename;
		this.employeeid = employeeid;
		
	}
	
	
	
}
