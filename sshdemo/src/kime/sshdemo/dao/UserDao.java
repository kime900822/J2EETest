package kime.sshdemo.dao;

import java.util.List;

import kime.sshdemo.po.User;

public interface UserDao {
	public void save(User user);
	public void delete(int id);
	public void update(User user);
	public List queryAll();
	public User queryByID(int id);
	
	
}
