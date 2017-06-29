package kime.shweb.dao;


import java.util.List;

import kime.shweb.model.Product;

public interface ProductDao {
	public void save(Product p);
	public void delete(String id);
	public void update(Product p);
	public List queryAll();
	public Product queryByID(String id);
	
	
	
}
