package kime.sshdemo.service;

import java.util.List;

import kime.sshdemo.dao.UserDao;
import kime.sshdemo.po.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(User user) {
		if (userDao.queryByID(user.getId())==null) {
			userDao.save(user);
		}else{
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		if (userDao.queryByID(user.getId())!=null) {
			userDao.delete(user.getId());
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		if (userDao.queryByID(user.getId())!=null) {
			userDao.update(user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List queryAllUser() {
		return userDao.queryAll();
	}

	@Override
	public User queryUserByID(int id) {
		return (User)userDao.queryByID(id);
	}

}
