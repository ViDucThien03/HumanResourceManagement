package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EmployeeDetail;
import model.EmployeeSummary;
import model.Profile;

public class EmployeeDAO {
public List<EmployeeSummary> getEmployee(String departmentid){
    List<EmployeeSummary> list = new ArrayList<EmployeeSummary>();
    Connection conn = DBConnect.getConnection();
    String sql = "SELECT employeeid, employeename, employeephone, positionname, departmentname, employee.departmentid "
                + "FROM employee "
                + "INNER JOIN positions ON employee.positionid = positions.positionid "
                + "INNER JOIN department ON employee.departmentid = department.departmentid "
                + "WHERE employee.departmentid=?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, departmentid);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            EmployeeSummary employeeit = new EmployeeSummary();
            employeeit.setEmployeeid(rs.getString("employeeid"));
            employeeit.setEmployeename(rs.getNString("employeename"));
            employeeit.setEmployeephone(rs.getString("employeephone"));
            employeeit.setPositionname(rs.getNString("positionname"));
            employeeit.setDepartmentname(rs.getNString("departmentname"));
            employeeit.setDepartmentid(rs.getString("departmentid"));
            list.add(employeeit);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
	public Profile profiledisplay(String employeeid) {
		Profile profile = null;
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT employeeid, image, employeename, employeebirth, employeeaddress, employeehometown, employeephone, employeeworkday, employeeexp,positions.positionid, positionname, department.departmentid FROM employee INNER JOIN positions ON employee.positionid = positions.positionid INNER JOIN department on employee.departmentid = department.departmentid WHERE employeeid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				profile = new Profile();
				profile.setEmployeeid(rs.getString("employeeid"));
				profile.setImage(rs.getString("image"));
				profile.setEmployeename(rs.getNString("employeename"));
				profile.setEmployeephone(rs.getString("employeephone"));
				profile.setEmployeebirth(rs.getDate("employeebirth"));
				profile.setEmployeehometown(rs.getNString("employeehometown"));
				profile.setEmployeeaddress(rs.getNString("employeeaddress"));
				profile.setEmployeeworkday(rs.getDate("employeeworkday"));
				profile.setEmployeeexp(rs.getNString("employeeexp"));
				profile.setPositionid(rs.getNString("positionid"));
				profile.setPositionname(rs.getNString("positionname"));
				profile.setDepartmentid(rs.getString("departmentid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profile;
	}
	public EmployeeDetail getByID(String employeeid) {
		EmployeeDetail emDetail = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from employee where employeeid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emDetail = new EmployeeDetail();
				emDetail.setEmployeeid(rs.getString("employeeid"));
				emDetail.setEmployeename(rs.getNString("employeename"));
				emDetail.setEmployeephone(rs.getString("employeephone"));
				emDetail.setEmployeebirth(rs.getDate("employeebirth"));
				emDetail.setEmployeehometown(rs.getNString("employeehometown"));
				emDetail.setEmployeeaddress(rs.getNString("employeeaddress"));
				emDetail.setEmployeeworkday(rs.getDate("employeeworkday"));
				emDetail.setEmployeeexp(rs.getNString("employeeexp"));
				emDetail.setPositionid(rs.getNString("positionid"));
				emDetail.setDepartmentid(rs.getString("departmentid"));
				emDetail.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emDetail;
		
	}
	public boolean insert(EmployeeDetail profile) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into employee value(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, profile.getEmployeeid());
			ps.setString(2, profile.getEmployeename());
			ps.setDate(3, new java.sql.Date(profile.getEmployeebirth().getTime()));
			ps.setString(4, profile.getEmployeeaddress());
			ps.setString(5, profile.getEmployeehometown());
			ps.setString(6, profile.getEmployeephone());
			ps.setDate(7, new java.sql.Date(profile.getEmployeeworkday().getTime()));
			ps.setString(8, profile.getEmployeeexp());
			ps.setString(9, profile.getPositionid());
			ps.setString(10, profile.getDepartmentid());
			ps.setString(11, profile.getImage());
			int row = ps.executeUpdate();
			if(row>0) {
				check = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	}
}
