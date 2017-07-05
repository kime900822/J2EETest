package kime.sshdemo.service;

import java.util.List;

import kime.sshdemo.po.User;

public interface UserService {
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public List queryAllUser();
	public User queryUserByID(int id);
	
}
