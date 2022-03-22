package dao;

import entity.User;

public interface UserDao {
	
	User getByUsername(String username);

}
