package kime.sshdemo.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import kime.sshdemo.po.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(int id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(User.class, id));
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().saveOrUpdate(user);
	}

	@Override
	public List queryAll() {
		return this.getHibernateTemplate().find("from User");
	}

	@Override
	public User queryByID(int id) {
		return (User)this.getHibernateTemplate().get(User.class, id);
	}

}
