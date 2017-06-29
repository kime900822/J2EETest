package kime.shweb.dao;

public class DaoFactory {
	public static ProductDao getDaoInstance(){
		return new ProductDaoImpl();
		
	}
}
