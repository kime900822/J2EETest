package kime.shweb.control;

import java.util.List;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import kime.shweb.dao.DaoFactory;
import kime.shweb.dao.ProductDao;
import kime.shweb.model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		ProductDao dao=DaoFactory.getDaoInstance();
		if (dao.queryByID(p.getId())==null) {
			dao.save(p);
		}else{
			System.out.println("id已经存在");
		}
	}

	@Override
	public void deleteProduct(String id) {

		ProductDao dao=DaoFactory.getDaoInstance();
		if (dao.queryByID(id)==null) {
			dao.delete(id);
		}else{
			System.out.println("id不存在");
		}
	}

	@Override
	public void updateProduct(Product p) {
		ProductDao dao=DaoFactory.getDaoInstance();
		if (dao.queryByID(p.getId())==null) {
			dao.update(p);
		}else{
			System.out.println("id不存在");
		}
		
	}

	@Override
	public List queryAllProduct() {
		ProductDao dao=DaoFactory.getDaoInstance();
		return dao.queryAll();
	}

	@Override
	public Product queryProductByID(String id) {
		ProductDao dao=DaoFactory.getDaoInstance();
		return dao.queryByID(id);
	}

}
