package dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Salary;
import model.SalaryDetail;

public class SalaryDAO {
	public List<Salary> getTotalSalary() {
		List<Salary> listsalary = new ArrayList<Salary>();
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT e.employeeid, e.employeename, positionname, actualsalary  " + "FROM employee e "
				+ "INNER JOIN positions ON e.positionid = positions.positionid "
				+ "INNER JOIN salary ON positions.positionid = salary.positionid";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String employeeid = rs.getString("employeeid");
				String employeename = rs.getNString("employeename");
				String positionname = rs.getNString("positionname");
				BigDecimal actualsalary = rs.getBigDecimal("actualsalary");
				Salary salary = new Salary();
				salary.setEmployeeid(employeeid);
				salary.setEmployeename(employeename);
				salary.setPositionname(positionname);
				salary.setActualsalary(actualsalary);
				listsalary.add(salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsalary;
	}

	public SalaryDetail payrolldisplay(String employeeid) {
		SalaryDetail salary = null;
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT e.employeeid, e.employeename, positionname, salaryid, salarygrade, salarybasic, salaryfactor, workingday, pit, totalsalary, actualsalary "
				+ "FROM salary s " + "INNER JOIN positions p ON s.positionid = p.positionid "
				+ "INNER JOIN employee e ON s.employeeid = e.employeeid " 
				+ "WHERE e.employeeid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				salary = new SalaryDetail();
				salary.setEmployeeid(rs.getString("employeeid"));
				salary.setEmployeename(rs.getNString("employeename"));
				salary.setPositionname(rs.getNString("positionname"));
				salary.setSalaryid(rs.getNString("salaryid"));
				salary.setSalarygrade(rs.getDouble("salarygrade"));
				salary.setSalarybasic(rs.getDouble("salarybasic"));
				salary.setSalaryfactor(rs.getDouble("salaryfactor"));
				salary.setWorkday(rs.getInt("workingday"));

				double totalsalarys = rs.getDouble("salarygrade") * rs.getDouble("salarybasic")
						* rs.getDouble("salaryfactor")
						- ((rs.getDouble("salarybasic") / 22) * (22 - rs.getInt("workingday")));
				BigDecimal totalsalary = new BigDecimal(totalsalarys);
				double pits = calculatePIT(totalsalarys);
				BigDecimal pit = new BigDecimal(pits);
				BigDecimal actualsalary = totalsalary.subtract(pit);
				BigDecimal roundedPit = pit.setScale(2, RoundingMode.HALF_UP);
				BigDecimal roundedTotalSalary = totalsalary.setScale(2, RoundingMode.HALF_UP);
				BigDecimal roundedActualSalary = actualsalary.setScale(2, RoundingMode.HALF_UP);
				salary.setPit(roundedPit);
				salary.setTotalsalary(roundedTotalSalary);
				salary.setActualsalary(roundedActualSalary);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salary;
	}

	private double calculatePIT(double totalsalarys) {
		double pits = 0;
		if(totalsalarys <= 1100000) {
			pits = 0;
		}
		else if(totalsalarys <= 16000000) {
			pits = (totalsalarys-1100000)*(5/100);
		}
		else if(totalsalarys <= 21000000) {
			pits = 5000000*0.05 + (totalsalarys-16000000)*0.1;
		}
		else if(totalsalarys <= 29000000) {
			pits = 5000000*0.05 + 5000000*0.1 + (totalsalarys-21000000)*0.15;
		}
		else if(totalsalarys <= 43000000){
			pits = 5000000*0.05 + 5000000*0.1 + 8000000*0.15 + (totalsalarys-29000000)*0.2;
		}
		else if(totalsalarys <= 63000000) {
			pits = 5000000*0.05 + 5000000*0.1 + 8000000*0.15 + 14000000*0.2 + (totalsalarys-43000000)*0.25;
		}
		else if(totalsalarys <= 91000000) {
			pits = 5000000*0.05 + 5000000*0.1 + 8000000*0.15 + 14000000*0.2 +20000000*0.25+ (totalsalarys-63000000)*0.3;
		}
		else {
			pits = 5000000*0.05 + 5000000*0.1 + 8000000*0.15 + 14000000*0.2 +20000000*0.25+28000000*0.3+(totalsalarys-91000000)*0.35;
		}
		return pits;
	}
}
