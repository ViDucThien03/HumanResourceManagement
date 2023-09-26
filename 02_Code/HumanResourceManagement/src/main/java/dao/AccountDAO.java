package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountDAO {
	//Các phương thức
	//getAll
	//getById
	//insert
	//update
	//delete
	
	//Phương thức để kiểm tra đăng nhập hệ thống
	public Account checkLogin(String userName, String password) {
		Account account = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from accounts where username=? and password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				account = new Account();
				account.setId(rs.getInt(1));
				account.setUserName(rs.getString(2));
				account.setActive(rs.getBoolean(3));
				account.setPassword(rs.getString(4));
				account.setUserRole(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
}
