package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AssignedWork;
import model.Top5Employee;

public class AssignedWorkDAO {
	public List<AssignedWork> getAll(){
		List<AssignedWork> listWorks = new ArrayList<AssignedWork>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from assignedwork";
		//String sql = "select jobid,deliverydate,descriptions,deadline,workprogressemployee,employeename,employee.employeeid from assignedwork inner join employee on assignedwork.employeeid = employee.employeeid";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AssignedWork work = new AssignedWork();
				work.setJobid(rs.getString("jobid"));
				work.setDeliverydate(rs.getDate("deliverydate"));
				work.setDescriptions(rs.getNString("descriptions"));
				work.setDeadline(rs.getDate("deadline"));
				work.setWorkrogress(rs.getNString("workprogressemployee"));
				//work.setEmployeeid(rs.getNString("employeename"));
				work.setEmployeeid(rs.getString("employeeid"));
				listWorks.add(work);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listWorks;
	}
	public AssignedWork getByID(String jobid) {
		AssignedWork work = null;
		Connection conn = DBConnect.getConnection();
		//String sql = "select jobid,descriptions,deliverydate,deadline,workprogressemployee,employeename from assignedwork inner join employee on assignedwork.employeeid = employee.employeeid where jobid=?";
		String sql = "select * from assignedwork where jobid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, jobid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				work = new AssignedWork();
				work.setJobid(rs.getString("jobid"));
				work.setDeliverydate(rs.getDate("deliverydate"));
				work.setDescriptions(rs.getNString("descriptions"));
				work.setDeadline(rs.getDate("deadline"));
				work.setWorkrogress(rs.getNString("workprogressemployee"));
				work.setEmployeeid(rs.getString("employeeid"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return work;
	}
	public boolean insert(AssignedWork work) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into assignedwork values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, work.getJobid());
			ps.setDate(2, new java.sql.Date(work.getDeliverydate().getTime()));
			ps.setString(3, work.getDescriptions());
			ps.setDate(4, new java.sql.Date(work.getDeadline().getTime()));
			ps.setString(5, work.getWorkrogress());
			ps.setString(6, work.getEmployeeid());
			
			int row = ps.executeUpdate();
			if(row>0) {
				check= true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public boolean update(AssignedWork assignedWork) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update assignedwork set deliverydate=?,descriptions=?,deadline=?,workprogressemployee=?,employeeid=? where jobid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(assignedWork.getDeliverydate().getTime()));
			ps.setString(2, assignedWork.getDescriptions());
			ps.setDate(3, new java.sql.Date(assignedWork.getDeliverydate().getTime()));
			ps.setString(4, assignedWork.getWorkrogress());
			ps.setString(5, assignedWork.getEmployeeid());
			ps.setString(6, assignedWork.getJobid());
			int row = ps.executeUpdate();
			if(row > 0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public void delete(String jobid) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from assignedwork where jobid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, jobid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int countTodayAssignedWorks() {
        int count = 0;
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT COUNT(deliverydate) FROM assignedwork WHERE deliverydate = CURDATE()";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
	public int countJobDone() {
        int countjd = 0;
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT COUNT(workprogressemployee) FROM assignedwork WHERE workprogressemployee like 'Hoàn thành' ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                countjd = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countjd;
    }
	public double percentDone() {
        int percent = 0;
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT (COUNT(CASE WHEN workprogressemployee = 'Hoàn thành' THEN 1 END) / COUNT(*) * 100) AS completion_percentage FROM assignedwork";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	percent = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return percent;
    }
//	public Employee getEmployeeID(String employeeid) {
//		Employee employee = null;
//		Connection conn = DBConnect.getConnection();
//		//String sql = "select jobid,descriptions,deliverydate,deadline,workprogressemployee,employeename from assignedwork inner join employee on assignedwork.employeeid = employee.employeeid where jobid=?";
//		String sql = "select * from employee where employeeid=?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, employeeid);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				employee = new Employee();
//				employee.setEmployeeid(rs.getString("employeeid"));
//				employee.setEmployeename(rs.getNString("employeename"));
//				employee.setEmployeebirth(rs.getDate("employeebirth"));
//				employee.setEmployeeaddress(rs.getNString("employeeaddress"));
//				employee.setEmployeehometown(rs.getNString("employeehometown"));
//				employee.setEmployeehometown(rs.getNString("employeephone"));
//				employee.setEmployeeworkday(rs.getDate("employeeworkday"));
//				employee.setEmployeeexp(rs.getNString("employeeexp"));
//				employee.setPositionid(rs.getString("positionid"));
//				employee.setDepartmentid(rs.getString("departmentid"));
//				employee.setImage(rs.getNString("image"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return employee;
//	}
	
	public List<Top5Employee> getTop5Employee(){
		List<Top5Employee> list = new ArrayList<Top5Employee>();
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT e.employeeid, e.employeename, e.image,"
				+ " COUNT(CASE WHEN aw.workprogressemployee = 'Hoàn thành' THEN 1 END) AS completed_works,"
				+ " ROUND(COUNT(CASE WHEN aw.workprogressemployee = 'Hoàn thành' THEN 1 END) * 100.0 / COUNT(*), 2) AS completion_percentage "
				+ "FROM employee e JOIN assignedwork aw ON e.employeeid = aw.employeeid "
				+ "GROUP BY e.employeeid, e.employeename  "
				+ "ORDER BY completed_works DESC LIMIT 3";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String employeeid = rs.getString("employeeid");
				String employeename = rs.getString("employeename");
				String image = rs.getString("image");
	
				
				int totalAssignedWorks = getTotalAssignedWorksForEmployee(employeeid);
                int completedWorks = getCompletedWorksForEmployee(employeeid);
                double completionPercentage = (double) completedWorks / totalAssignedWorks * 100;
                Top5Employee employee = new Top5Employee();
                employee.setEmployeeid(employeeid);
                employee.setEmployeename(employeename);
                employee.setImage(image);
                employee.setCompletionPercentage(completionPercentage);
                employee.setCompletedWorks(completedWorks);
                list.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	private int getTotalAssignedWorksForEmployee(String employeeid) {
		int totalAssignedWorks = 0;
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT COUNT(*) FROM assignedwork WHERE employeeid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				totalAssignedWorks = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalAssignedWorks;
	}
	private int getCompletedWorksForEmployee(String employeeid) {
		int completedWorks = 0;
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT COUNT(workprogressemployee) FROM assignedwork WHERE employeeid = ? AND workprogressemployee like 'Hoàn thành'";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				completedWorks = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return completedWorks;
	}	
}
