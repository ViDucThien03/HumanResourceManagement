package model;

import java.math.BigDecimal;

public class SalaryDetail extends Salary{
	private BigDecimal totalsalary;
	private String salaryid;
	private double salarygrade;
	private double salarybasic;
	private double salaryfactor;
	private int workday;
	private BigDecimal pit;
	public BigDecimal getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(BigDecimal totalsalary) {
		this.totalsalary = totalsalary;
	}
	public String getSalaryid() {
		return salaryid;
	}
	public void setSalaryid(String salaryid) {
		this.salaryid = salaryid;
	}
	public double getSalarygrade() {
		return salarygrade;
	}
	public void setSalarygrade(double salarygrade) {
		this.salarygrade = salarygrade;
	}
	public double getSalarybasic() {
		return salarybasic;
	}
	public void setSalarybasic(double salarybasic) {
		this.salarybasic = salarybasic;
	}
	public double getSalaryfactor() {
		return salaryfactor;
	}
	public void setSalaryfactor(double salaryfactor) {
		this.salaryfactor = salaryfactor;
	}
	public int getWorkday() {
		return workday;
	}
	public void setWorkday(int workday) {
		this.workday = workday;
	}
	public BigDecimal getPit() {
		return pit;
	}
	public void setPit(BigDecimal pit) {
		this.pit = pit;
	}
	public SalaryDetail() {
		super();
	}
	public SalaryDetail(BigDecimal totalsalary, String salaryid, double salarygrade, double salarybasic,
			double salaryfactor, int workday, BigDecimal pit) {
		super();
		this.totalsalary = totalsalary;
		this.salaryid = salaryid;
		this.salarygrade = salarygrade;
		this.salarybasic = salarybasic;
		this.salaryfactor = salaryfactor;
		this.workday = workday;
		this.pit = pit;
	}
	
}
