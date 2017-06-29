package kime.shweb.control;

import java.util.List;

import kime.shweb.model.Product;

public interface ProductService {
	public void addProduct(Product p);
	public void deleteProduct(String id);
	public void updateProduct(Product p);
	public List queryAllProduct();
	public Product queryProductByID(String id);
}
