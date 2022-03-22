package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;

import dao.UserDao;
import entity.User;

public class UserService extends Util implements UserDao {
	
	private static final String GET_BY_USERNAME = "SELECT username, password FROM public.users where username=?";
	
	DataSource ds = getDataSource();

	
	public User getByUsername(String username) {
		try {
		Connection connection = ds.getConnection();
		PreparedStatement ps = connection.prepareStatement(GET_BY_USERNAME);
		ps.setString(1, username);
		ResultSet resultSet = ps.executeQuery();
		User tempUser = new User();
		if (!resultSet.next()) {
			tempUser.setUserName("");
			tempUser.setUserPassword("");
		} else {
			tempUser.setUserName(resultSet.getString(1));
			tempUser.setUserPassword(resultSet.getString(2));
		}
		return tempUser;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean userIsExsist(String username, String password) {
		User tempUser = getByUsername(username);
		
		if (tempUser.getUserName().equals(username) &&
				tempUser.getUserPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
