package kime.shweb.dao;

import java.nio.channels.ScatteringByteChannel;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import kime.shweb.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save(Product p) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		HibernateUtil.closerSession(session);
	}

	@Override
	public void delete(String id) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		String hql="DELETE Product WHERE id=?";
		Query q=session.createQuery(hql);
		q.setParameter(0, id);
		q.executeUpdate();
		session.getTransaction().commit();
		HibernateUtil.closerSession(session);	
	}

	@Override
	public void update(Product p) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		HibernateUtil.closerSession(session);	
	}

	@Override
	public List queryAll() {
		Session session=HibernateUtil.getSession();
		String hql="FROM Product ";
		Query q=session.createQuery(hql);
		List list=q.list();
		HibernateUtil.closerSession(session);
		return list;
	}

	@Override
	public Product queryByID(String id) {
		Session session=HibernateUtil.getSession();
		String hql=" FROM Product WHERE id=:id";
		Query q=session.createQuery(hql);
		q.setParameter("id", id);
		List list=q.list();
		Product product=null;
		Iterator iterator=list.iterator();
		if (iterator.hasNext()) {
			product=(Product)iterator.next();
		}
				
		HibernateUtil.closerSession(session);
		return product;
	}
	
}
