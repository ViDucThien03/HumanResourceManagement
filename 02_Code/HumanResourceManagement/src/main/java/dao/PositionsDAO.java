package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Positions;

public class PositionsDAO {
	public List<Positions> getAll(){
		List<Positions> listPositions = new ArrayList<Positions>();
		Connection conn = DBConnect.getConnection();
		String sql = "SELECT positions.positionid, positions.positionname, department.departmentname FROM positions INNER JOIN department ON positions.departmentid = department.departmentid";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Positions positions = new Positions();
				positions.setPositionid(rs.getString("positionid"));
				positions.setPositionname(rs.getNString("positionname"));
				positions.setDepartmentid(rs.getString("departmentname"));
				listPositions.add(positions);
			}
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPositions;
	}
}
